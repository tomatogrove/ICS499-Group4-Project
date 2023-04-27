package com.team4.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class PlayerTest {

	private Player player;
	private Hand hand;

	@BeforeEach
	public void setUp() {
		player = new Player("testPlayer");
		hand = new Hand();
	}

	@Test
	public void testGetGameTag() {
		assertEquals("testPlayer", player.getGameTag());
	}

	@Test
	public void testSetGameTag() {
		player.setGameTag("newTag");
		assertEquals("newTag", player.getGameTag());
	}

	@Test
	public void testGetHand() {
		assertNotNull(player.getHand());
	}

	@Test
	public void testSetHand() {
		player.setHand(hand);
		assertEquals(hand, player.getHand());
	}
}
