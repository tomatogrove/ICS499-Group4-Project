package com.team4.model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.team4.model.Stats;

public class StatsTest {

    private Stats stats;

    @BeforeEach
    public void setUp() {
        stats = new Stats();
        stats.setGameTag("player1");
        stats.setGamesWon(3);
    }

    @Test
    public void testGetId() {
        // Ensure that the ID is null before the entity is persisted
        Assertions.assertNull(stats.getId());
    }

    @Test
    public void testGetGameTag() {
        // Ensure that the correct gameTag is returned
        Assertions.assertEquals("player1", stats.getGameTag());
    }

    @Test
    public void testSetGameTag() {
        // Ensure that the gameTag is set correctly
        stats.setGameTag("player2");
        Assertions.assertEquals("player2", stats.getGameTag());
    }

    @Test
    public void testGetGamesWon() {
        // Ensure that the correct gamesWon count is returned
        Assertions.assertEquals(3, stats.getGamesWon());
    }

    @Test
    public void testSetGamesWon() {
        // Ensure that the gamesWon count is set correctly
        stats.setGamesWon(5);
        Assertions.assertEquals(5, stats.getGamesWon());
    }
}