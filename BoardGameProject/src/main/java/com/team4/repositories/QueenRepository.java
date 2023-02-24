
package com.team4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team4.model.classes.chess.pieces.Queen;

public interface QueenRepository extends JpaRepository<Queen, Long> {

}