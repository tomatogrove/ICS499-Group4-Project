package com.team4.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.OneToOne;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)  
public abstract class Piece {
	
	@Id
	@GeneratedValue
	protected Long pieceID;
	
	private Color color;
	private Type type;
	
	@OneToOne
	private Space currentSpace;
	
	@ManyToOne
	private Board board;

	public Piece() {
	}

	public Piece(Color color, Type type, Space currentSpace, Board board) {
		this.color = color;
		this.type = type;
		this.currentSpace = currentSpace;
		this.board = board;
	}

	public Long getPieceID() { 
		return pieceID; 
	}
	public void setPieceID(Long pieceID) {
		this.pieceID = pieceID;
	}
	
	public abstract List<Space> getPossibleMoves();

	public Color getColor() {
		return color;
	}
	
	public Type getType() {
		return type;
	}
	
	public void setType(Type type) {
		this.type = type;
	}

	public Space getCurrentSpace() {
		return currentSpace;
	}

	public void setCurrentSpace(Space currentSpace) {
		this.currentSpace = currentSpace;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public enum Color {
		WHITE, BLACK
	}
	
	public enum Type {
		PAWN, ROOK, KNIGHT, BISHOP, KING, QUEEN
	}
}