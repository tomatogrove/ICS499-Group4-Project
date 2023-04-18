package com.team4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team4.model.Numbered;

public interface NumberedRepository extends JpaRepository<Numbered, Long> {

}