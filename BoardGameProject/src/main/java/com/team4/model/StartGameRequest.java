package com.team4.model;

import java.util.List;

public class StartGameRequest {
    private int numOfPlayers;
    private List<String> gamerTags;
	public int getNumOfPlayers() {
		return numOfPlayers;
	}
	public void setNumOfPlayers(int numOfPlayers) {
		this.numOfPlayers = numOfPlayers;
	}
	public List<String> getGamerTags() {
		return gamerTags;
	}
	public void setGamerTags(List<String> gamerTags) {
		this.gamerTags = gamerTags;
	}

  
    
}