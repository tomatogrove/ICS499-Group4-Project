package com.team4.model;

public class Wild extends Card {

	public Wild() {
		super("");
	}

	@Override
	public String toString() {
		String result = "Wild";
		if(super.getColor() != "") {
			result = super.toString() + " Wild";
		}
		return result;
	}

}
