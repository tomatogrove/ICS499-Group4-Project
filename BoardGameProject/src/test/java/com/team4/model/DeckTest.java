package com.team4.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DeckTest {
	
    private Deck deck;

    @BeforeEach
    public void setUp() {
        deck = Deck.instance();
    }

    @Test
    public void testDeckInstance() {
        assertNotNull(deck);
    }

    @Test
    public void testDeckSize() {
        int expectedSize = 108;
        assertEquals(expectedSize, deck.getCards().size());
    }

    @Test
    public void testDeckReset() {
        deck.resetDeck();
        int expectedSize = 108;
        assertEquals(expectedSize, deck.getCards().size());
    }

    @Test
    public void testDeckShuffle() {
        List<Card> originalCards = deck.getCards();
        deck.shuffle();
        List<Card> shuffledCards = deck.getCards();
        assertFalse(originalCards.equals(shuffledCards));
    }

    @Test
    public void testDraw7() {
        List<Card> drawnCards = deck.draw7();
        int expectedSize = 7;
        assertEquals(expectedSize, drawnCards.size());
    }

    @Test
    public void testDrawCard() {
        Card drawnCard = deck.drawCard();
        assertNotNull(drawnCard);
    }

    @Test
    public void testDraw2() {
        List<Card> drawnCards = deck.draw2();
        int expectedSize = 2;
        assertEquals(expectedSize, drawnCards.size());
    }

    @Test
    public void testDraw4() {
        List<Card> drawnCards = deck.draw4();
        int expectedSize = 4;
        assertEquals(expectedSize, drawnCards.size());
    }
}