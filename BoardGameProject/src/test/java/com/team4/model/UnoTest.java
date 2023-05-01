package com.team4.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

public class UnoTest {

    @Test
    public void testStartGame() {
        Uno game = Uno.instance();
        game.startGame(4, List.of("P1", "P2", "P3", "P4"));

        assertEquals(4, game.getPlayerList().getPlayers().size());
        assertNotNull(game.getDeck());
        assertNotNull(game.getPlayedCard());
    }

    @Test
    public void testResetGame() {
        Uno game = Uno.instance();
        game.startGame(4, List.of("P1", "P2", "P3", "P4"));

        game.resetGame();

        assertTrue(game.getPlayerList().getPlayers().isEmpty());
        assertNotNull(game.getDeck());
        assertNull(game.getPlayedCard());
    }

}
