package com.team4.model;

@SuppressWarnings("serial")
public class InvalidCardException extends Exception {

	public InvalidCardException() {
		super("Invalid Card, Try Again!");
	}

	public InvalidCardException(String message) {
		super(message);
	}

}
