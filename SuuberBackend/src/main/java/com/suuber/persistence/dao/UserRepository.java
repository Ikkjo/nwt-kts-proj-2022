package com.suuber.persistence.dao;

import com.suuber.persistence.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

public interface UserRepository extends JpaRepository<User, UUID> {

    List<User> findAll();
    User findByEmail(String email);

    Optional<User> findById(UUID id);

    List<User> findAllByFirstNameAndLastNameLike(String firstName, String lastName);
}
