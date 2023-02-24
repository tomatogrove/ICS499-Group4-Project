package com.team4.model.classes.chess.pieces;

import java.util.ArrayList;
import java.util.List;

import com.team4.model.abstrct.Piece;
import com.team4.model.classes.chess.Space;


import javax.persistence.Entity;


@Entity
public class Pawn extends Piece {
	
	
	public Pawn() {
		
	}
	
    public Pawn(Color color, Space currentSpace) {
        super(color, Piece.Type.PAWN, currentSpace);
    }

    @Override
    public List<Space> getPossibleMoves() {
        List<Space> possibleMoves = new ArrayList<>();
        // We gotta add some code here
        return possibleMoves;
    }

}
