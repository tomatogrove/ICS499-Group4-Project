package com.team4.controllers;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.team4.model.UserAccount;

@RunWith(MockitoJUnitRunner.class)
public class UserAccountControllerTest {

	private MockMvc mockMvc;

	private ObjectMapper objectMapper = new ObjectMapper();
	private ObjectWriter objectWriter = objectMapper.writer();
	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	@Mock
	private UserAccountController userController;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(this.userController).build();
	}


	@Test
	public void testCreateValidUser() throws Exception {
		UserAccount account = new UserAccount();
		account.setUserID((long) 2);
		account.setUsername("testUsername");
		account.setEmail("testEmail");
		account.setPassword("testPassword");

		mockMvc.perform(post("/useraccount/add").contentType(APPLICATION_JSON_UTF8).content(objectWriter.writeValueAsString(account)))
			.andExpect(status().isOk())
			.andReturn();
	}

	@Test
	public void testCreateInvalidUser() throws Exception {
		// test makes a post call with no body
		mockMvc.perform(post("/useraccount/add")).andExpect(status().isBadRequest());
	}

	@Test
	public void testGetAllUsers() throws Exception {
		UserAccount account = new UserAccount();
		account.setUsername("testUsername");
		account.setEmail("testEmail");
		account.setPassword("testPassword");

		UserAccount account2 = new UserAccount();
		account2.setUsername("testUsername2");
		account2.setEmail("testEmail2");
		account2.setPassword("testPassword2");

		List<UserAccount> mockAccounts = new ArrayList<>();
		mockAccounts.add(account);
		mockAccounts.add(account2);

		when(userController.list()).thenReturn(mockAccounts);
		
		mockMvc.perform(get("/useraccount/all"))
			.andExpect(status().isOk())
			.andExpect(content().json(objectWriter.writeValueAsString(mockAccounts)));

	}

	@Test
	public void testGetUserByID() throws Exception {
		Long userID = 1L;
		UserAccount savedUser = new UserAccount();
		savedUser.setUsername("testUsername");
		savedUser.setPassword("testPassword");

		when(userController.get(userID)).thenReturn(savedUser);

		mockMvc.perform(get("/useraccount/{id}", userID))
		.andExpect(status().isOk())
		.andExpect(content().json(objectWriter.writeValueAsString(savedUser)));
	}

	@Test
	public void testUpdateUser() throws Exception {
		UserAccount updatedUser = new UserAccount();
		updatedUser.setUsername("testUserName");
		updatedUser.setPassword("testPassword");

		when(userController.update(any(UserAccount.class))).thenReturn(updatedUser);

		mockMvc.perform(put("/useraccount/update").contentType(APPLICATION_JSON_UTF8).content(objectWriter.writeValueAsString(updatedUser)))
			.andExpect(status().isOk())
			.andExpect(content().json(objectWriter.writeValueAsString(updatedUser)));
	}

	@Test
	public void testDeleteUserById() throws Exception {
		Long userID = 1L;

		doNothing().when(userController).delete(userID);

		mockMvc.perform(delete("/useraccount/delete/{id}", userID)).andExpect(status().isOk());
	}
}