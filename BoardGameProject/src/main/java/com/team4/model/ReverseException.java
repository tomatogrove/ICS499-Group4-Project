package com.team4.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="reverseexception")
public class ReverseException extends Exception {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long reverseexceptionID;
	

	public ReverseException() {
		super("The order has been reversed");
	}

	public ReverseException(String message) {
		super(message);
	}
}
