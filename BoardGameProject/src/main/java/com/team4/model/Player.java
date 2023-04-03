package com.team4.model;

public class Player {
	private String gameTag;
	private Hand hand;
	
	public Player(String gameTag) {
		this.gameTag = gameTag;
		hand = new Hand();
	}

	public String getGameTag() {
		return gameTag;
	}

	public Hand myHand() {
		return hand;
	}

	@Override
	public String toString() {
		return gameTag;
	}

}