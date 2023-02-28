package com.team4.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<<< HEAD:BoardGameProject/src/main/java/com/team4/controllers/DeckController.java
import com.team4.model.Deck;
import com.team4.repositories.DeckRepository;
========
import com.team4.model.User;
import com.team4.repositories.UserRepository;
>>>>>>>> main:BoardGameProject/src/main/java/com/team4/controllers/UserController.java

@RestController
@RequestMapping("/deck")
public class DeckController {

	@Autowired 
	private DeckRepository deckRepo;
	
	@GetMapping("/all")
	public List<Deck> list() {
		return deckRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Deck get(@PathVariable Long id) {
		return deckRepo.getReferenceById(id);
	}
	
	@PostMapping("/add")
	public Deck create(@RequestBody final Deck deck) {
		return deckRepo.saveAndFlush(deck);
	}
	
	@PutMapping("/update")
	public Deck update(@RequestBody final Deck deck) {
		return deckRepo.saveAndFlush(deck);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		deckRepo.deleteById(id);
	}
}
