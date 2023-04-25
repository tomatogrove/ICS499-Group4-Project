package com.team4.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)  
@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
@JsonSubTypes({
    @JsonSubTypes.Type(Numbered.class)}
  
)
public abstract class Card {
	
	
	@Id
	@GeneratedValue
	private Long cardID;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Deck deck;
	
	
	
	private String color;
	protected int num;
	private String type;

	public Card() {}
	public Card(String color, String type) {
		this.color = color;
		this.type = type;
	}


	public int getNum() {
		return num;
	}

	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}

	public String toString() {
		return color;
	}
	public String getType() {
	    return type;
	  }
	
}
