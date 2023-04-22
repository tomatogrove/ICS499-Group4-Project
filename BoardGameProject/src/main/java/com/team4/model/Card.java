package com.team4.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Card {

	@Id
	@GeneratedValue
	private Long cardID;

	@ManyToOne(cascade = CascadeType.ALL)
	private Deck deck;

	@ManyToOne(cascade = CascadeType.ALL)
	private Hand hand;

	private String color;
	protected int num;

	public Card() {
	}

	public Card(String color) {
		this.color = color;
	}

	public int getNum() {
		return num;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String toString() {
		return color;
	}

}