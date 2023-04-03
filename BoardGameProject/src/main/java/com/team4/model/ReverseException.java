package com.team4.model;

public class ReverseException extends Exception {

	public ReverseException() {
		super("The order has been reversed");
	}

	public ReverseException(String message) {
		super(message);
	}
}
