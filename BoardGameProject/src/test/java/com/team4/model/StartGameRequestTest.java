package com.team4.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

@SpringBootTest(classes = StartGameRequest.class)
public class StartGameRequestTest {

    @Autowired
    private StartGameRequest startGameRequest;

    @Test
    void testGetNumOfPlayers() {
        startGameRequest.setNumOfPlayers(4);
        assertEquals(4, startGameRequest.getNumOfPlayers());
    }

    @Test
    void testGetGamerTags() {
        List<String> gamerTags = Arrays.asList("player1", "player2", "player3");
        startGameRequest.setGamerTags(gamerTags);
        assertEquals(gamerTags, startGameRequest.getGamerTags());
    }
}
