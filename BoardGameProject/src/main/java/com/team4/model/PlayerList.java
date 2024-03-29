package com.team4.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
@Entity
public class PlayerList {
	
    @Id
    private Long id;
    
    @OneToMany(mappedBy = "playerList", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Player> players = new ArrayList<Player>();
    
    @OneToOne
    private Player winner;
	
	public static PlayerList playerList;
	
	@OneToOne
	private Uno uno;

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
			if(player.getHand().size() == 0) {
				winner = player;
				return false;
			} 
		}
		return true;
	}
	
	public void oldReverse() {
		Collections.reverse(players);
	}
	
	public void reverse(Player player) {
		List<Player> newOrder = new ArrayList<Player>();
		int size = players.size();
		int index = players.indexOf(player) - 1;
//		System.out.println(player.getGameTag() + " >> " + index);
		for(int i = index; i >= 0; i--) {
			newOrder.add(players.remove(i));
		}
		int nextIndex = size - index;
//		System.out.println("Next Index >> " + nextIndex);
		for(int i = (players.size() - 1); i >= 0; i--) {
			newOrder.add(players.remove(i));
		}
//		for(int i = 0; i < newOrder.size(); i++) {
//			System.out.println(newOrder.get(i).getGameTag());
//		}
		players.addAll(newOrder);
	}
	
	public Player getPlayer(String gameTag) {
		for(Player player : players) {
			if(player.getGameTag().equals(gameTag)) {
				return player;
			}
		}
		return null;
	}

	public List<Player> getPlayers() {
		return players;
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
	public void clearPlayers() {
	    players.clear();
	}


}
