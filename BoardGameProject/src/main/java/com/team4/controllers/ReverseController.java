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

import com.team4.model.Reverse;
import com.team4.repositories.ReverseRepository;

@RestController
@RequestMapping("/reverse")
public class ReverseController {
	
	@Autowired 
	private ReverseRepository reverseRepo;
	
	@GetMapping("/all")
	public List<Reverse> list() {
		return reverseRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Reverse get(@PathVariable Long id) {
		return reverseRepo.getReferenceById(id);
	}
	
	@PostMapping("/add")
	public Reverse create(@RequestBody final Reverse reverse) {
		return reverseRepo.saveAndFlush(reverse);
	}
	
	@PutMapping("/update")
	public Reverse update(@RequestBody final Reverse reverse) {
		return reverseRepo.saveAndFlush(reverse);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		reverseRepo.deleteById(id);
	}

}
