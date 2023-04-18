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

import com.team4.model.Wild;
import com.team4.repositories.WildRepository;

@RestController
@RequestMapping("/wild")
public class WildController {
	
	@Autowired 
	private WildRepository wildRepo;
	
	@GetMapping("/all")
	public List<Wild> list() {
		return wildRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Wild get(@PathVariable Long id) {
		return wildRepo.getReferenceById(id);
	}
	
	@PostMapping("/add")
	public Wild create(@RequestBody final Wild wild) {
		return wildRepo.saveAndFlush(wild);
	}
	
	@PutMapping("/update")
	public Wild update(@RequestBody final Wild wild) {
		return wildRepo.saveAndFlush(wild);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		wildRepo.deleteById(id);
	}

}