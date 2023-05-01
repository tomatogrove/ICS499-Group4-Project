package com.team4.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team4.model.Stats;
import com.team4.repositories.StatsRepository;

@RestController
@RequestMapping("/stats")
@CrossOrigin(origins = "http://localhost:4200")
public class StatsController {
	
	@Autowired 
	private StatsRepository statsRepo;
	
	@GetMapping("/all")
	public List<Stats> list() {
		return statsRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Stats get(@PathVariable Long id) {
		return statsRepo.getOne(id);
	}
	
	@PostMapping("/add")
    public Stats create(@RequestBody final Stats stat) {
        // Check if a stat for the gameTag already exists
        Stats existingStat = statsRepo.findByGameTag(stat.getGameTag());

        if (existingStat != null) {
            // If a stat for the gameTag already exists, increment the gamesWon count
            existingStat.setGamesWon(existingStat.getGamesWon() + 1);
            return statsRepo.saveAndFlush(existingStat);
        } else {
            // If a stat for the gameTag doesn't exist, save the new stat
            return statsRepo.saveAndFlush(stat);
        }
    }
	
	@PutMapping("/update")
	public Stats update(@RequestBody final Stats stats) {
		return statsRepo.saveAndFlush(stats);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		statsRepo.deleteById(id);
	}
}
