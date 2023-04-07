package com.team4.model;

import jakarta.persistence.Entity;

@Entity
public class Reverse extends Card {

	public Reverse(String color) {
		super(color);
	}

	@Override
	public String toString() {
		return super.toString() + " Reverse";
	}

}
