package com.team4.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="reverseexception")
@SuppressWarnings("serial")
public class ReverseException extends Exception {
	
	@Id
	@GeneratedValue
	private Long reverseexceptionID;
	
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
	public ReverseException() {
		super("The order has been reversed");
	}

	public ReverseException(String message) {
		super(message);
	}
}
