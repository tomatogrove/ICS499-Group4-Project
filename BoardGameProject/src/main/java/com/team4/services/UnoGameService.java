package com.team4.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.team4.model.Card;
import com.team4.model.Draw2Exception;
import com.team4.model.InvalidCardException;
import com.team4.model.Player;
import com.team4.model.ReverseException;
import com.team4.model.Skip;
import com.team4.model.SkipException;
import com.team4.model.Uno;
import com.team4.model.WildDraw4Exception;
import com.team4.model.WildException;

@Service
public class UnoGameService {

    private Uno uno;

    public void startGame(int numOfPlayers, List<String> gamerTags) {
        uno = new Uno();
        uno.startGame(numOfPlayers, gamerTags);
    }
    public List<Player> getPlayers() {
        if (uno == null || uno.getPlayerList() == null) {
            return new ArrayList<>();
        }
        return uno.getPlayerList().getPlayers();
    }
    public Card getPlayedCard() {
        return uno.getPlayedCard();
     }
    public boolean currentPlayerHasPlayableCard() {
        Player currentPlayer = uno.getPlayerList().getPlayers().get(currentPlayerIndex);
        return uno.checkIfPlayerHasPlayableHand(currentPlayer);
    }

    private Player getPlayerById(Long playerId) {
        List<Player> players = uno.getPlayerList().getPlayers();
        for (Player player : players) {
            if (player.getId().equals(playerId)) {
                return player;
            }
        }
        return null;
    }

    private int currentPlayerIndex = 0;
    private int turnDirection = 1;

    public int getNextPlayerIndex() {
        int numOfPlayers = uno.getPlayerList().getPlayers().size();
        currentPlayerIndex = (currentPlayerIndex + turnDirection + numOfPlayers) % numOfPlayers;
        return currentPlayerIndex;
    }

    public void reverseTurnOrder() {
    	turnDirection = 1;
        turnDirection = -turnDirection;
    }

	
    public void playCard(int cardIndex, Player player, String selectedColor) {
        try {
        	var currentCard = player.getHand().getCard(cardIndex-1);
        	if(currentCard.getType().equals("skip") ) {
        		getNextPlayerIndex();
        	}
            uno.play(cardIndex, player, selectedColor);
        } catch (InvalidCardException | SkipException | ReverseException | Draw2Exception | WildException
                | WildDraw4Exception e) {
        }
    }

    public void drawCard(Player player) {
        uno.playerDrawCard(1, player);
    }

}
