package com.team4.model;

<<<<<<< Updated upstream
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
=======
>>>>>>> Stashed changes

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.Entity;

<<<<<<< Updated upstream
=======
@Entity
@Table(name="skip")
>>>>>>> Stashed changes
public class Skip extends Card {
	
	@Id
	@GeneratedValue
	private Long skipID;
	

	public Skip(String color) {
		super(color);
	}

	@Override
	public String toString() {
		return super.toString() + " Skip";
	}
	
	
}
