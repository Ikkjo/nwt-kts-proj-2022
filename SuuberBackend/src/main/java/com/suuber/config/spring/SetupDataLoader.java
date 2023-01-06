package com.suuber.config.spring;

import java.util.*;

import com.suuber.persistence.dao.PrivilegeRepository;
import com.suuber.persistence.dao.UserRoleRepository;
import com.suuber.persistence.dao.UserRepository;
import com.suuber.persistence.models.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private boolean alreadySetup = false;

    private final UserRepository userRepository;

    private final UserRoleRepository roleRepository;

    private final PrivilegeRepository privilegeRepository;

    private final PasswordEncoder passwordEncoder;

    private final String ADMIN_EMAIL = "admin@test.com";
    private final String ADMIN_FIRST_NAME = "Super";
    private final String ADMIN_LAST_NAME = "Admin";
    private final String ADMIN_PASS = "admin";

    public SetupDataLoader(UserRepository userRepository,
                           UserRoleRepository roleRepository,
                           PrivilegeRepository privilegeRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.privilegeRepository = privilegeRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // API

    @Override
    @Transactional
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        if (alreadySetup) {
            return;
        }

        // == create initial privileges
        final Privilege readAllPrivilege = createPrivilegeIfNotFound("READ_ALL_PRIVILEGE");
        final Privilege writeAllPrivilege = createPrivilegeIfNotFound("WRITE_ALL_PRIVILEGE");
        final Privilege passwordPrivilege = createPrivilegeIfNotFound("CHANGE_PASSWORD_PRIVILEGE");

        // == create initial roles
        final List<Privilege> adminPrivileges = new ArrayList<>(Arrays.asList(readAllPrivilege, writeAllPrivilege,
                passwordPrivilege));
        final List<Privilege> clientPrivileges = new ArrayList<>(Arrays.asList(readAllPrivilege, passwordPrivilege));
        final List<Privilege> driverPrivileges = new ArrayList<>(Arrays.asList(readAllPrivilege, passwordPrivilege));

        UserRole adminRole = createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        createRoleIfNotFound("ROLE_CLIENT", clientPrivileges);
        createRoleIfNotFound("ROLE_DRIVER", driverPrivileges);


        // == create initial user
        userRepository.save(createUserIfNotFound(ADMIN_EMAIL,
                             ADMIN_FIRST_NAME,
                             ADMIN_LAST_NAME,
                             ADMIN_PASS,
                             new ArrayList<>(Collections.singletonList(adminRole))));

        alreadySetup = true;
    }

    @Transactional
    Privilege createPrivilegeIfNotFound(final String name) {
        Privilege privilege = privilegeRepository.findByName(name);
        if (privilege == null) {
            privilege = new Privilege(name);
            privilege = privilegeRepository.save(privilege);
        }
        return privilege;
    }

    @Transactional
    UserRole createRoleIfNotFound(final String name, final Collection<Privilege> privileges) {
        UserRole role = roleRepository.findByName(name);
        if (role == null) {
            role = new UserRole(name);
        }
        role.setPrivileges(privileges);
        role = roleRepository.save(role);
        return role;
    }

    @Transactional
    User createUserIfNotFound(final String email, final String firstName, final String lastName, final String password,
                              final Collection<UserRole> roles) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            user = new Admin();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setPassword(passwordEncoder.encode(password));
            user.setEmail(email);
            user.setEnabled(true);
        }
        user.setRoles(roles);
        user = userRepository.save(user);
        return user;
    }
}