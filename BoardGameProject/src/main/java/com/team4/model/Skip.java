package com.team4.model;

import jakarta.persistence.Entity;

@Entity
public class Skip extends Card {

	public Skip(String color) {
		super(color);
	}

	@Override
	public String toString() {
		return super.toString() + " Skip";
	}
	
	
}
