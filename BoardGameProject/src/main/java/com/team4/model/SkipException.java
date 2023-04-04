package com.team4.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="skipexception")
@SuppressWarnings("serial")
public class SkipException extends Exception {
	
	@Id
	@GeneratedValue
	private Long skipexceptionID;
	

	public SkipException() {
		super("you have been skipped");
	}

	public SkipException(String message) {
		super(message);
	}

}