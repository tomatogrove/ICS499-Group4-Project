package com.team4.model;

public class WildDraw4 extends Card {

	public WildDraw4() {
		super("");
	}
	
	@Override
	public String toString() {
		String result = "Wild Draw 4";
		if(super.getColor() != "") {
			result = super.toString() + " Wild Draw 4";
		}
		return result;
	}

}
