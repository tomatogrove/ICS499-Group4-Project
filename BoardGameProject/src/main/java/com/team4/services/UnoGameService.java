package com.team4.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.team4.model.Card;
import com.team4.model.Player;
import com.team4.model.Uno;

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
}
