package com.team4.model;

import jakarta.persistence.Entity;

@Entity
public class Draw2 extends Card {

	public Draw2(String color) {
		super(color);
	}

	@Override
	public String toString() {
		return super.toString() + " Draw 2";
	}

}