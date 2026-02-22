package com.portal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.portal.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

    @Query("select u from User u where u.email = :email")
    Optional<User> checkEmail(@Param("email") String email);

    @Query("select u from User u where u.email=:email and u.password=:password and u.role=:role")
    Optional<User> doLogin(
        @Param("email") String email,
        @Param("password") String password,
        @Param("role") String role
    );
}
