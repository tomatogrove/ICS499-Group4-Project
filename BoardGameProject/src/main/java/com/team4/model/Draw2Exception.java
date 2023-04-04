package com.team4.model;

@SuppressWarnings("serial")
public class Draw2Exception extends Exception {

	public Draw2Exception() {
		super("we have drawn 2 cards for you and you have been skipped");
	}

	public Draw2Exception(String message) {
		super(message);
	}

}
