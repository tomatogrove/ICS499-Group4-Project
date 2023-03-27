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

import com.team4.model.PlayerList;
import com.team4.repositories.PlayerListRepository;

@RestController
@RequestMapping("/playerList")
public class PlayerListController {
	
	@Autowired 
	private PlayerListRepository playerListRepo;
	
	@GetMapping("/all")
	public List<PlayerList> list() {
		return playerListRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public PlayerList get(@PathVariable Long id) {
		return playerListRepo.getReferenceById(id);
	}
	
	@PostMapping("/add")
	public PlayerList create(@RequestBody final PlayerList playerList) {
		return playerListRepo.saveAndFlush(playerList);
	}
	
	@PutMapping("/update")
	public PlayerList update(@RequestBody final PlayerList playerList) {
		return playerListRepo.saveAndFlush(playerList);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		playerListRepo.deleteById(id);
	}

}
