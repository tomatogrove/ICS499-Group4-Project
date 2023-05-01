
package com.team4.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.team4.model.Player;
import com.team4.model.PlayerList;
import com.team4.model.Uno;

@SpringBootTest(classes = PlayerList.class)
class PlayerListTest {

	@Autowired
	private PlayerList playerList;

	@BeforeEach
	void setUp() {
		playerList.getPlayers().clear();
	}

	@Test
	void testCreatePlayer() {

		playerList.createPlayer("player1");
		assertEquals(1, playerList.getPlayers().size());
		assertEquals("player1", playerList.getPlayers().get(0).getGameTag());
	}

	@Test
	void testReverse() {

		Player player1 = new Player("player1");
		Player player2 = new Player("player2");
		Player player3 = new Player("player3");
		Player player4 = new Player("player4");
		playerList.getPlayers().add(player1);
		playerList.getPlayers().add(player2);
		playerList.getPlayers().add(player3);
		playerList.getPlayers().add(player4);

		playerList.reverse(player2);
		List<Player> expected = List.of(player1, player4, player3, player2);
		assertEquals(expected, playerList.getPlayers());
	}

	@Test
	void testGetPlayer() {
		Player player = new Player("player1");
		playerList.getPlayers().add(player);

		assertEquals(player, playerList.getPlayer("player1"));

		assertNull(playerList.getPlayer("player2"));
	}

}
