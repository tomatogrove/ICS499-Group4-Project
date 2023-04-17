package com.team4.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Player {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String gameTag;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Hand hand;
	@ManyToOne
	private PlayerList playerList;
	
	public Player() {}
	
	public Player(String gameTag) {
		this.gameTag = gameTag;
		hand = new Hand();
	}

	public Long getId() {
		return id;
	}
	
	public String getGameTag() {
		return gameTag;
	}

	public void setGameTag(String gameTag) {
		this.gameTag = gameTag;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	@Override
	public String toString() {
		return gameTag;
	}

}
