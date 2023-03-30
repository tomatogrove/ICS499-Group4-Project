package com.team4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team4.model.InvalidCardException;

public interface InvalidCardExceptionRepository extends JpaRepository<InvalidCardException, Long>{

}
