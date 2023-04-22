package com.team4.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team4.model.Card;
import com.team4.model.Deck;
import com.team4.model.Hand;
import com.team4.model.Player;
import com.team4.model.StartGameRequest;
import com.team4.model.Uno;
import com.team4.repositories.DeckRepository;
import com.team4.repositories.UnoRepository;
import com.team4.services.UnoGameService;

@RestController
@RequestMapping("/uno")
@CrossOrigin(origins = "*")
public class UnoController {

	private UnoGameService unoGameService = new UnoGameService();

	public UnoController(UnoGameService unoGameService) {
		this.unoGameService = unoGameService;
	}

	@Autowired
	private UnoRepository unoRepo;

	private Uno uno = Uno.instance();;

	@Autowired
	private DeckRepository deckRepo;

	@GetMapping("/all")
	public List<Uno> list() {
		return unoRepo.findAll();
	}

	@GetMapping("/{id}")
	public Uno get(@PathVariable Long id) {
		return unoRepo.getReferenceById(id);
	}

	@PostMapping("/add")
	public ResponseEntity<Uno> createUnoGame() {
		Deck deck = new Deck();
		deck.shuffle();
		deckRepo.save(deck);

		Uno uno = new Uno();
		unoRepo.save(uno);

		return new ResponseEntity<>(uno, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public Uno update(@RequestBody final Uno uno) {
		return unoRepo.saveAndFlush(uno);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		unoRepo.deleteById(id);
	}

	@PostMapping("/start")
	public ResponseEntity<Void> startGame(@RequestBody StartGameRequest request) {
		unoGameService.startGame(request.getNumOfPlayers(), request.getGamerTags());
		return ResponseEntity.ok().build();
	}

	@GetMapping("/players")
	public ResponseEntity<List<Player>> getPlayers() {
		List<Player> players = unoGameService.getPlayers();
		return ResponseEntity.ok(players);
	}
	@GetMapping("/played-card")
	  public ResponseEntity<Card> getPlayedCard() {
	    Card playedCard = unoGameService.getPlayedCard();
	    return ResponseEntity.ok(playedCard);
	  }

}