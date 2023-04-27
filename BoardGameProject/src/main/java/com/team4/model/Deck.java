package com.team4.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

//import contents.Card;
//import contents.Deck;
//import contents.Numbered;
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Id;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;

@Entity
public class Deck {
	@Id
	@GeneratedValue
	private Long deckID;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Uno uno;
	
	public static Deck deck;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private List<Card> cards = new ArrayList<Card>();
	
	public Deck() {
		createDeck();
	}
	
	public static Deck instance() {
		if (deck == null) {
			return (deck = new Deck());
		} else {
			return deck;
		}
	}
	
	private void createDeck() {
		//Create the numbered cards
		for(int i = 0; i < 10; i++) {
			cards.add(new Numbered("Red", i));
			cards.add(new Numbered("Blue", i));
			cards.add(new Numbered("Green", i));
			cards.add(new Numbered("Yellow", i));
		}
		for(int i = 1; i < 10; i++) {
			cards.add(new Numbered("Red", i));
			cards.add(new Numbered("Blue", i));
			cards.add(new Numbered("Green", i));
			cards.add(new Numbered("Yellow", i));
		}
		//Create the skip, reverse, & draw 2 cards
		for(int i = 0; i < 2; i++) {
			cards.add(new Skip("Red"));
			cards.add(new Skip("Blue"));
			cards.add(new Skip("Green"));
			cards.add(new Skip("Yellow"));
			
			cards.add(new Reverse("Red"));
			cards.add(new Reverse("Blue"));
			cards.add(new Reverse("Green"));
			cards.add(new Reverse("Yellow"));
			
			cards.add(new Draw2("Red"));
			cards.add(new Draw2("Blue"));
			cards.add(new Draw2("Green"));
			cards.add(new Draw2("Yellow"));
		}
		//Create the wild & wild draw 4 cards
		for(int i = 0; i < 4; i++) {
			cards.add(new Wild());
			
			//cards.add(new WildDraw4());
		}
		shuffle();
	}
	public void resetDeck() {
	    cards.clear();
	    createDeck(); // This should be the method that creates and shuffles the initial deck of cards.
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public List<Card> draw7(){
		List<Card> result = new ArrayList<Card>();
		for(int i = 0; i < 7; i++) {
			result.add(cards.remove(i));
		}
		return result;
	}
	
	public Card drawCard() {
		return cards.remove(0);
	}
	
	public List<Card> draw2(){
		List<Card> result = new ArrayList<Card>();
		for(int i = 0; i < 2; i++) {
			result.add(cards.remove(i));
		}
		return result;
	}
	
	public List<Card> draw4(){
		List<Card> result = new ArrayList<Card>();
		for(int i = 0; i < 4; i++) {
			result.add(cards.remove(i));
		}
		return result;
	}
	
	public List<Card> getCards() {
	    return cards;
	}
	
	public int size() {
		return deck.size();
	}
	
	public String toString() {
		String result = "";
		for(int i = 0; i < cards.size(); i++) {
			result += cards.get(i).toString() + "\n";
		}
		return result;
	}

}