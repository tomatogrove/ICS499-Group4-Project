package com.team4.model;

public class Numbered extends Card{
	
	public Numbered(String color, int num) {
		super(color);
		super.num = num;
	}

	@Override
	public String toString() {
		return super.toString() + " " + num;
	}

}
