package com.team4.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Uno")
@CrossOrigin(origins = "http://localhost:4200")
public class Uno {

	@Id
	@GeneratedValue
	private Long id;
	public static Uno uno;

	@OneToOne
	private PlayerList playerList;

	@OneToOne
	private Deck deck;
	@OneToOne
	private Card playedCard;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private List<Card> playedCards = new ArrayList<Card>();

	public Uno() {
		playerList = PlayerList.instance();
		deck = Deck.instance();
	}

	public static Uno instance() {
		if (uno == null) {
			return (uno = new Uno());
		} else {
			return uno;
		}
	}

	public void startGame(int numOfPlayers, List<String> gamerTag) {
		resetGame();
		for (int i = 0; i < numOfPlayers; i++) {
			playerList.createPlayer(gamerTag.get(i));
		}
		for (Player player : playerList.getPlayers()) {
			player.getHand().drawCards(deck.draw7());
		}
		playedCard = deck.drawCard();
	}
	public void resetGame() {
	    playerList.clearPlayers();
	    deck.resetDeck();
	    playedCard = null;
	}
	public void play(int card, Player player, String selectedColor) throws InvalidCardException, SkipException, ReverseException,
			Draw2Exception, WildException, WildDraw4Exception {
		var currentPlayer = playerList.getPlayers();
		Player realPlayer = null ;
		for(int i = 0; i<currentPlayer.size(); i++) {
			var gameTag = currentPlayer.get(i).getGameTag();
			if(gameTag.equals(player.getGameTag())) {
				realPlayer=currentPlayer.get(i);
			}
		}
		
		
		Card playingCard = realPlayer.getHand().playCard(card - 1);

		if (isCardPlayable(playingCard)) {
			playedCards.add(playingCard);
			playedCard = playingCard;
			if(playedCard instanceof Wild || playedCard instanceof WildDraw4) {
				playedCard.setColor(selectedColor);
			}
			if(playingCard instanceof WildDraw4)
				playerDrawCard(4,player);
			else if(playingCard instanceof Draw2)
				playerDrawCard(2,player);
				
			applyCardEffect(realPlayer, playingCard);
		} else {
			realPlayer.getHand().returnCard(playingCard);
			throw new InvalidCardException();
		}
	}
	public void playerDrawCard(int amountOfCards, Player player) {
		var currentPlayer = playerList.getPlayers();
		Player realPlayer = null ;
		int realPlayerIndex=0;
		for(int i = 0; i<currentPlayer.size(); i++) {
			
			var gameTag = currentPlayer.get(i).getGameTag();
			if(gameTag.equals(player.getGameTag())) {
				realPlayer=currentPlayer.get(i);
				realPlayerIndex = i;
			}
		}
		int nextPlayerIndex =  currentPlayer.size()-1 == realPlayerIndex ?  0 : realPlayerIndex+1 ;
		Player nextPlayer = currentPlayer.get(nextPlayerIndex);
		if (amountOfCards == 1) {
			realPlayer.getHand().drawCard(deck.drawCard());
		} else if (amountOfCards == 2) {
			nextPlayer.getHand().drawCards(deck.draw2());
		} else if (amountOfCards == 4) {
			nextPlayer.getHand().drawCards(deck.draw4());
		}
	}
	private boolean isCardPlayable(Card playingCard) {
		return playingCard.getColor().equals(playedCard.getColor()) || (playingCard.getNum() == playedCard.getNum() && !(playedCard instanceof Wild ||playedCard instanceof WildDraw4) )
				|| playingCard instanceof Wild || playingCard instanceof WildDraw4;
	}

	private void applyCardEffect(Player player, Card playingCard)
			throws SkipException, ReverseException, Draw2Exception, WildException, WildDraw4Exception {
		if (playingCard instanceof Skip) {
			throw new SkipException();
		} else if (playingCard instanceof Reverse) {
			playerList.reverse(player);
			throw new ReverseException();
		} else if (playingCard instanceof Draw2) {
			throw new Draw2Exception();
		} else if (playingCard instanceof Wild) {
			throw new WildException();
		} else if (playingCard instanceof WildDraw4) {
			throw new WildDraw4Exception();
		}
	}

	public boolean checkIfPlayerHasPlayableHand(Player player) {
		for (int i = 0; i < player.getHand().size(); i++) {
			if (playedCard.getColor().equals(player.getHand().getCard(i).getColor())) {
				return true;
			} else {
				if (playedCard.getClass().getSimpleName().equals("Numbered")
						&& player.getHand().getCard(i).getClass().getSimpleName().equals("Numbered")) {
					if (playedCard.getNum() == player.getHand().getCard(i).getNum()) {
						return true;
					}
				} else if (playedCard.getClass().getSimpleName()
						.equals(player.getHand().getCard(i).getClass().getSimpleName())) {
					return true;
				}
			}
		}
		return false;
	}

	

	public Card getPlayedCard() {
		return playedCard;
	}

	public PlayerList getPlayerList() {
		return playerList;
	}

	public Deck getDeck() {
		return deck;
	}

}