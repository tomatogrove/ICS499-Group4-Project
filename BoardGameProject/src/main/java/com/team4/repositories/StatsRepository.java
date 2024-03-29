package com.team4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team4.model.Stats;

public interface StatsRepository extends JpaRepository<Stats, Long> {
	Stats findByGameTag(String gameTag);

}