package com.team4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team4.model.classes.UserAccount;

public interface UserRepository extends JpaRepository<UserAccount, Long> {

}
