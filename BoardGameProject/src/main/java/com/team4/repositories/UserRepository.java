package com.team4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team4.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}