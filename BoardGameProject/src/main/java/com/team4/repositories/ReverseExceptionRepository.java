package com.team4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team4.model.ReverseException;

public interface ReverseExceptionRepository extends JpaRepository<ReverseException, Long>{

}