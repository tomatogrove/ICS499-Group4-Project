package com.team4.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.team4.model.Card;
import com.team4.model.Numbered;
import com.team4.repositories.CardRepository;

public class CardControllerTest {

   private MockMvc mockMvc;

   @Mock
   private CardRepository cardRepo;

   @InjectMocks
   private CardController cardController;

   @BeforeEach
   public void init() {
      MockitoAnnotations.initMocks(this);
      mockMvc = MockMvcBuilders.standaloneSetup(cardController).build();
   }

   @Test
   public void testGetAllCards() throws Exception {
      List<Card> cards = List.of(new Numbered("Card1", 1), new Numbered("Card2", 2));
      Mockito.when(cardRepo.findAll()).thenReturn(cards);

      MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/card/all")
            .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

      MockHttpServletResponse response = mvcResult.getResponse();
      String json = response.getContentAsString();
      ObjectMapper objectMapper = new ObjectMapper();
      List<Card> actualCards = objectMapper.readValue(json, List.class);

      assertEquals(cards.size(), actualCards.size());
   }

   @Test
   public void testGetCardById() throws Exception {
      Long cardId = 1L;
      Card card = new Numbered("Card1", 1);
      Mockito.when(cardRepo.getReferenceById(cardId)).thenReturn(card);

      MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/card/" + cardId)
            .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

      MockHttpServletResponse response = mvcResult.getResponse();
      String json = response.getContentAsString();
      ObjectMapper objectMapper = new ObjectMapper();
      Card actualCard = objectMapper.readValue(json, Numbered.class);

      assertNotNull(actualCard);
      assertEquals(cardId, actualCard.getNum());
   }


} 