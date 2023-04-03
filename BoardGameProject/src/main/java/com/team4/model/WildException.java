package com.team4.model;

public class WildException extends Exception {

	public WildException() {
		super("pick a color:\n1) Red\n2) Blue\n3) Green\n4) Yellow");
	}

	public WildException(String message) {
		super(message);
	}

}
