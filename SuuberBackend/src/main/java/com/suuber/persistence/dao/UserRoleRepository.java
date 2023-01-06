package com.suuber.persistence.dao;

import com.suuber.persistence.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, UUID> {

    Optional<UserRole> findById(UUID id);

    List<UserRole> findUserRolesByUsersEquals(UUID userId);

    List<UserRole> findAll();

    UserRole findByName(String name);
}
