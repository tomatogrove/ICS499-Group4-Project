package com.team4.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public class Skip extends Card {

	@Id
	@GeneratedValue
	private Long skipID;
	
	
	public Skip(String color) {
		super(color);
	}

	@Override
	public String toString() {
		return super.toString() + " Skip";
	}
	
	
}
