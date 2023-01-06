package com.suuber.persistence.dao;

import com.suuber.persistence.models.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

public interface PrivilegeRepository extends JpaRepository<Privilege, UUID> {

    Optional<Privilege> findById(UUID id);

    Privilege findByName(String name);

    List<Privilege> findPrivilegesByRoles(UUID roleId);

    List<Privilege> findPrivilegesByName(String name);

}
