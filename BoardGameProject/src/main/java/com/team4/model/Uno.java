package com.team4.model;

import java.util.ArrayList;
import java.util.List;

public class Uno {

	public static Uno uno;
	private PlayerList playerList;
	private Deck deck;
	private Card playedCard;
	private List<Card> playedCards = new ArrayList<Card>();
	
	private Uno() {
		playerList = PlayerList.instance();
		deck = Deck.instance();
	}
	
	public static Uno instance() {
		if (uno == null) {
			return (uno = new Uno());
		} else {
			return uno;
		}
	}
	
	public void startGame(int numOfPlayers, List<String> gamerTag) {
		for(int i = 0; i < numOfPlayers; i++) {
			playerList.createPlayer(gamerTag.get(i));
		}
		for(Player player : playerList.getPlayers()) {
			player.myHand().drawCards(deck.draw7());
		}
		playedCard = deck.drawCard();
	}
	
//	public boolean isAWildCard(int card, Player player) {
//		//0 is a wild card, 1 isn't a wild card
//		Card playingCard = player.myHand().playCard((card - 1));
//		if(playingCard.getClass().toString() == "Wild" || playingCard.getClass().toString() == "WildDraw4") {
//			return true;
//		} else {
//			return false;
//		}
//	}
	
	public void play(int card, Player player) {
		Card playingCard = player.myHand().playCard((card - 1));
		if(playedCard.getColor().equals(playingCard.getColor())) {
			playedCards.add(playedCard);
			playedCard = playingCard;
		} else if(playedCard.getNum() == playingCard.getNum()){
			playedCards.add(playedCard);
			playedCard = playingCard;
		} else {
			player.myHand().returnCard(playingCard);
			throw new IllegalArgumentException("Invalid Card, Try Again!\nPlayed Card: " + playedCard.toString());
		}
	}
	
	public boolean checkIfPlayerHasPlayableHand(Player player) {
		for(int i = 0; i < player.myHand().size(); i++) {
			if(playedCard.getColor().equals(player.myHand().getCard(i).getColor())) {
				return true;
			} else if(playedCard.getNum() == player.myHand().getCard(i).getNum()) {
				return true;
			}
		}
		return false;
	}
	
	public void playerDrawCard(int amountOfCards, Player player) {
		if(amountOfCards == 1) {
			player.myHand().drawCard(deck.drawCard());
		}
	}

	public Card getPlayedCard() {
		return playedCard;
	}

	public PlayerList getPlayerList() {
		return playerList;
	}

}