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

    @Test
    public void testPlayerDrawCard() {
        Uno game = Uno.instance();
        game.startGame(2, List.of("P1", "P2"));

        Player player1 = game.getPlayerList().getPlayers().get(0);
        Player player2 = game.getPlayerList().getPlayers().get(1);
        int player1InitialHandSize = player1.getHand().size();
        int player2InitialHandSize = player2.getHand().size();

        game.playerDrawCard(1, player1);
        game.playerDrawCard(2, player2);

        assertEquals(player1InitialHandSize + 1, player1.getHand().size());
        assertEquals(player2InitialHandSize + 2, player2.getHand().size());
    }
}
