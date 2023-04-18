package com.team4.model;

import jakarta.persistence.Entity;


public class WildDraw4Exception extends Exception {
	String endingMessage = "we have drawn 4 cards for you and you have been skipped";
	
	public WildDraw4Exception() {
		super("pick a color:\n1) Red\n2) Blue\n3) Green\n4) Yellow");
	}

	public WildDraw4Exception(String message) {
		super(message);
	}

	public String getEndingMessage() {
		return endingMessage;
	}

}