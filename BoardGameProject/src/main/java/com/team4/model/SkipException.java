package com.team4.model;

public class SkipException extends Exception {

	public SkipException() {
		super("you have been skipped");
	}

	public SkipException(String message) {
		super(message);
	}

}