package com.team4.model;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Id;
//import jakarta.persistence.ManyToOne;

public abstract class Card {
	private String color;
	protected int num;

	public Card(String color) {
		this.color = color;
	}

	public int getNum() {
		return num;
	}

	public String getColor() {
		return color;
	}
	
	public String toString() {
		return color;
	}

}
