package com.team4.model.abstrct;

import com.backend.classes.Rule;
import com.team4.model.classes.Player;

public abstract class Game {

	private String type;
	private Player[] players;
	private Rule[] rules;
	
	public Game(String type, Player[] players, Rule[] rules) {
		super();
		this.type = type;
		this.players = players;
		this.rules = rules;
	}
	
	public String getType() { return type; }
	public void setType(String type) { this.type = type; }

	public Player[] getPlayers() { return players; }
	public void setPlayers(Player[] players) { this.players = players; }

	public Rule[] getRules() { return rules; }
	public void setRules(Rule[] rules) { this.rules = rules; }
}
