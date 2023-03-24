package com.team4.model;

import java.util.ArrayList;
import java.util.List;

public class PlayerList {
	
	public static PlayerList playerList;
	private List<Player> players = new ArrayList<Player>();
	private Player winner;

	private PlayerList() {

	}
	
	public static PlayerList instance() {
		if (playerList == null) {
			return (playerList = new PlayerList());
		} else {
			return playerList;
		}
	}
	
	public void createPlayer(String gameTag) {
		players.add(new Player(gameTag));
	}
	
	public boolean noWinner() {
		for(Player player : players) {
			if(player.myHand().size() == 0) {
				winner = player;
				return false;
			} 
		}
		return true;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public Player getPlayer(String gameTag) {
		for(Player p : players) {
			if(p.getGameTag().equals(gameTag)) {
				return p;
			}
		}
		return null;
	}
	
	public Player getWinner() {
		return winner;
	}

	public String toString() {
		String result = "";
		for(int i = 0; i < players.size(); i++) {
			result += players.get(i).toString() + "\n";
		}
		return result;
	}

}
