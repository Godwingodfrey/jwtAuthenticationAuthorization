package com.security.JWT.Authentication.and.Authorisation.repository;

import com.security.JWT.Authentication.and.Authorisation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
