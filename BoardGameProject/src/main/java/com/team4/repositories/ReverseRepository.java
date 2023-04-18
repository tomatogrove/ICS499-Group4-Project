package com.team4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team4.model.Reverse;

public interface ReverseRepository extends JpaRepository<Reverse, Long> {

}