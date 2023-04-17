package com.team4.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Hand {
	@Id
	@GeneratedValue
	private Long handID;

	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private List<Card> hand;
	
	public Hand() {
		hand = new ArrayList<Card>();
	}
	
	public void drawCards(List<Card> cards) {
		hand.addAll(cards);
	}
	
	public void drawCard(Card card) {
		hand.add(card);
	}
	
	public void returnCard(Card card) {
		hand.add(card);
	}
	
	public Card playCard(int index) {
		Card result = hand.get(index);
		hand.remove(index);
		return result;
	}
	
	public Card getCard(int index) {
		return hand.get(index);
	}
	public List<Card> getCards() {
	    return hand;
	}
	public int size() {
		return hand.size();
	}

	public String toString() {
		String result = "Your Hand:\n";
		for(int i = 0; i < hand.size(); i++) {
			result += (i+1) + ") " + hand.get(i) + "\n";
		}
		return result;
	}

}