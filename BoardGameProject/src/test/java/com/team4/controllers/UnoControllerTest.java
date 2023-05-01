package com.team4.controllers;

import com.team4.model.Player;
import com.team4.model.Uno;
import com.team4.model.Deck;
import com.team4.model.StartGameRequest;
import com.team4.repositories.DeckRepository;
import com.team4.repositories.UnoRepository;
import com.team4.services.UnoGameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UnoControllerTest {

    private UnoController unoController;

    @Mock
    private UnoGameService unoGameService;

    @Mock
    private UnoRepository unoRepository;

    @Mock
    private DeckRepository deckRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        unoController = new UnoController(unoGameService);
        unoController.unoRepo = unoRepository;
        unoController.deckRepo = deckRepository;
    }

    @Test
    public void testList() {
        List<Uno> unoList = new ArrayList<>();
        Uno uno = new Uno();
        unoList.add(uno);
        when(unoRepository.findAll()).thenReturn(unoList);

        List<Uno> result = unoController.list();

        assertEquals(1, result.size());
        assertEquals(uno, result.get(0));
        verify(unoRepository).findAll();
    }

    @Test
    public void testGet() {
        Uno uno = new Uno();
        when(unoRepository.getReferenceById(1L)).thenReturn(uno);

        Uno result = unoController.get(1L);

        assertEquals(uno, result);
        verify(unoRepository).getReferenceById(1L);
    }

    @Test
    public void testUpdate() {
        Uno uno = new Uno();
        when(unoRepository.saveAndFlush(any(Uno.class))).thenReturn(uno);

        Uno result = unoController.update(uno);

        assertEquals(uno, result);
        verify(unoRepository).saveAndFlush(any(Uno.class));
    }

    @Test
    public void testDelete() {
        unoController.delete(1L);

        verify(unoRepository).deleteById(1L);
    }

    @Test
    public void testStartGame() {
        StartGameRequest request = new StartGameRequest();
        request.setNumOfPlayers(2);
        List<String> gamerTags = new ArrayList<>();
        gamerTags.add("Player1");
        gamerTags.add("Player2");
        request.setGamerTags(gamerTags);

        ResponseEntity<Void> responseEntity = unoController.startGame(request);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(unoGameService).startGame(2, gamerTags);
    }

    @Test
    public void testGetPlayers() {
        List<Player> players = new ArrayList<>();
        Player player1 = new Player();
        Player player2 = new Player();
        players.add(player1);
        players.add(player2);
    }
}