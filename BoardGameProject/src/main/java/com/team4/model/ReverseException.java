
package com.team4.model;

import jakarta.persistence.Entity;

public class ReverseException extends Exception {

	public ReverseException() {
		super("The order has been reversed");
	}

	public ReverseException(String message) {
		super(message);
	}
}