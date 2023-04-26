package com.team4.model;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CardTest {

	private Card card;
	
	@BeforeEach
	public void setUp() throws Exception {
		card = new Numbered("red", 5);
	}

	@Test
	void testGetNum() {
		assertEquals(5, card.getNum());
	}

	@Test
	void testGetColor() {
		assertEquals("red", card.getColor());
	}

	@Test
	void testSetColor() {
		card.setColor("red");
		assertEquals("red", card.getColor());
	}

//	@Test
//	void testToString() {
//		assertEquals("red", card.toString());
//	}

	@Test
	void testGetType() {
		assertEquals("numbered", card.getType());
	}

}
