package com.team4.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Uno")
@CrossOrigin(origins = "http://localhost:4200")
public class Uno {
	
  
	 @Id
	  @GeneratedValue private Long id;
	public static Uno uno;
	
	@OneToOne
	private PlayerList playerList;
	
	@OneToOne
	private Deck deck;
	 @OneToOne
	private Card playedCard;
	 @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private List<Card> playedCards = new ArrayList<Card>();
	
	public Uno() {
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
		System.out.print(numOfPlayers);
		System.out.println(gamerTag.toString());
		for(int i = 0; i < numOfPlayers; i++) {
			playerList.createPlayer(gamerTag.get(i));
		}
		for(Player player : playerList.getPlayers()) {
			player.getHand().drawCards(deck.draw7());
		}
		playedCard = deck.drawCard();
	}
	
	/*
	 * public void play(int card, Player player) throws InvalidCardException,
	 * SkipException, ReverseException, Draw2Exception, WildException,
	 * WildDraw4Exception { Card playingCard = player.getHand().playCard((card -
	 * 1));
	 * 
	 * if(playedCard.getColor().equals(playingCard.getColor())) {
	 * playedCards.add(playedCard); playedCard = playingCard;
	 * if(playedCard.getClass().getSimpleName().equals("Skip")) { throw new
	 * SkipException(); } else
	 * if(playedCard.getClass().getSimpleName().equals("Reverse")) {
	 * playerList.reverse(player); throw new ReverseException(); } else
	 * if(playedCard.getClass().getSimpleName().equals("Draw2")) { throw new
	 * Draw2Exception(); } } else
	 * if(playedCard.getClass().getSimpleName().equals("Skip") &&
	 * !playedCard.getColor().equals(playingCard.getColor())) {
	 * playedCards.add(playedCard); playedCard = playingCard; throw new
	 * SkipException(); } else
	 * if(playedCard.getClass().getSimpleName().equals("Reverse") &&
	 * !playedCard.getColor().equals(playingCard.getColor())) {
	 * playedCards.add(playedCard); playedCard = playingCard;
	 * playerList.reverse(player); throw new ReverseException(); } else
	 * if(playedCard.getClass().getSimpleName().equals("Draw2") &&
	 * !playedCard.getColor().equals(playingCard.getColor())) {
	 * playedCards.add(playedCard); playedCard = playingCard; throw new
	 * Draw2Exception(); } else
	 * if(playingCard.getClass().getSimpleName().equals("Wild")) {
	 * playedCards.add(playedCard); playedCard = playingCard; throw new
	 * WildException(); } else
	 * if(playingCard.getClass().getSimpleName().equals("WildDraw4")) {
	 * playedCards.add(playedCard); playedCard = playingCard; throw new
	 * WildDraw4Exception(); } else if(playedCard.getNum() == playingCard.getNum()){
	 * playedCards.add(playedCard); playedCard = playingCard; } else {
	 * player.getHand().returnCard(playingCard); throw new InvalidCardException(); }
	 * }
	 */
	
	public boolean checkIfPlayerHasPlayableHand(Player player) {
		for(int i = 0; i < player.getHand().size(); i++) {
			if(playedCard.getColor().equals(player.getHand().getCard(i).getColor())) {
				return true;
			} else {
				if(playedCard.getClass().getSimpleName().equals("Numbered") && player.getHand().getCard(i).getClass().getSimpleName().equals("Numbered")) {
					if(playedCard.getNum() == player.getHand().getCard(i).getNum()) {
						return true;
					}
				} else if(playedCard.getClass().getSimpleName().equals(player.getHand().getCard(i).getClass().getSimpleName())) {
					return true;
				}
			}
		}
		return false;
	}
	
	public void playerDrawCard(int amountOfCards, Player player) {
		if(amountOfCards == 1) {
			player.getHand().drawCard(deck.drawCard());
		} else if(amountOfCards == 2) {
			player.getHand().drawCards(deck.draw2());
		} else if(amountOfCards == 4) {
			player.getHand().drawCards(deck.draw4());
		}
	}

	public Card getPlayedCard() {
		return playedCard;
	}

	public PlayerList getPlayerList() {
		return playerList;
	}

	public Deck getDeck() {
		return deck;
	}

}