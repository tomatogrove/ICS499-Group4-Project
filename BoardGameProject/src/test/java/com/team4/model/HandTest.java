package com.team4.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HandTest {
    private Hand hand;
    private List<Card> cards;
//    private Card card;
    
    @BeforeEach
    public void setUp() {
        hand = new Hand();
        cards = new ArrayList<>();
        cards.add(new Numbered("red", 5));
        cards.add(new Numbered("blue", 4));
//        cards.add(new Skip("green"));
    }
    
    @Test
    public void testDrawCard() {
        Card card = new Numbered("yellow", 2);
        hand.drawCard(card);
        assertEquals(1, hand.size());
        assertEquals(card, hand.getCard(0));
    }
    
    @Test
    public void testDrawCards() {
        hand.drawCards(cards);
        assertEquals(cards.size(), hand.size());
        for (int i = 0; i < cards.size(); i++) {
            assertEquals(cards.get(i), hand.getCard(i));
        }
    }
    
    @Test
    public void testReturnCard() {
        Card card = new Numbered("yellow", 2);
        hand.drawCard(card);
        assertEquals(1, hand.size());
        hand.returnCard(card);
        assertEquals(2, hand.size());
        assertEquals(card, hand.getCard(1));
    }
    
    @Test
    public void testPlayCard() {
        hand.drawCards(cards);
        Card card = hand.playCard(1);
        for (int i = 0; i < cards.size(); i++) {
        	assertEquals(cards.get(1), card);
        	assertEquals(cards.size() - 1, hand.size());
        }
    }
    
    @Test
    public void testGetCard() {
        hand.drawCards(cards);
        for (int i = 0; i < cards.size(); i++) {
            assertEquals(cards.get(i), hand.getCard(i));
        }
    }
    
    @Test
    public void testSize() {
        Hand hand = new Hand();
        assertEquals(0, hand.size());
        
        hand.drawCard(new Numbered("blue", 2));
        assertEquals(1, hand.size());
        
        hand.drawCard(new Numbered("red", 3));
        assertEquals(2, hand.size());
    }
    
}
