package com.ics499.team4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.team4.model.Player;
import com.team4.model.PlayerList;

public class PlayerListTest {

    private PlayerList playerList;
    
    @BeforeEach
    void setUp() {
        playerList = PlayerList.instance();
    }
    
    @AfterEach
    void tearDown() {
        playerList = null;
    }

    @Test
    void testCreatePlayer() {
        String gameTag = "player1";
        playerList.createPlayer(gameTag);
        List<Player> players = playerList.getPlayers();
        assertEquals(1, players.size());
        Player player = players.get(0);
        assertEquals(gameTag, player.getGameTag());
    }
    
    @Test
    void testNoWinner() {
        playerList.createPlayer("player1");
        playerList.createPlayer("player2");
        playerList.createPlayer("player3");
        playerList.createPlayer("player4");
        boolean noWinner = playerList.noWinner();
        assertEquals(true, noWinner);
    }
    
    @Test
    void testReverse() {
        playerList.createPlayer("player1");
        playerList.createPlayer("player2");
        playerList.createPlayer("player3");
        playerList.createPlayer("player4");
        Player player = playerList.getPlayer("player2");
        assertNotNull(player);
        playerList.reverse(player);
        List<Player> players = playerList.getPlayers();
        List<String> gameTags = Arrays.asList("player3", "player4", "player2", "player1");
        for (int i = 0; i < players.size(); i++) {
            Player p = players.get(i);
            assertEquals(gameTags.get(i), p.getGameTag());
        }
    }
    
    @Test
    void testGetPlayer() {
        playerList.createPlayer("player1");
        playerList.createPlayer("player2");
        playerList.createPlayer("player3");
        playerList.createPlayer("player4");
        Player player = playerList.getPlayer("player2");
        assertNotNull(player);
        assertEquals("player2", player.getGameTag());
    }
}
