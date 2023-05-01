package com.team4.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserAccountTest {
	
	private UserAccount account;
	
	@BeforeEach
	public void setUp() {
		account = new UserAccount("testName", "testEmail", "testPassword");
	}

	@Test
	public void testGetUsername() {
		assertEquals("testName", account.getUsername());
	}
	
	@Test
	public void testGetEmail() {
		assertEquals("testEmail", account.getEmail());
	}
	
	@Test
	public void testGetPassword() {
		assertEquals("testPassword", account.getPassword());
	}
	
	@Test
	public void testSetUsername() {
		account.setUsername("newTestName");
		assertEquals("newTestName", account.getUsername());
	}
	
	@Test
	public void testSetEmail() {
		account.setEmail("newTestEmail");
		assertEquals("newTestEmail", account.getEmail());
	}
	
	@Test
	public void testSetPassword() {
		account.setPassword("newTestPassword");
		assertEquals("newTestPassword", account.getPassword());
	}
}
