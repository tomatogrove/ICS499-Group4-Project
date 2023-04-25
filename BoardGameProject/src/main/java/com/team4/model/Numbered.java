package com.team4.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import jakarta.persistence.Entity;

@Entity
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
public class Numbered extends Card{
	public Numbered(){
		
	}
	public Numbered(String color, int num) {
		super(color, "numbered");
		super.num = num;
	}

	@Override
	public String toString() {
		return super.toString() + " " + num;
	}

}
