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

import com.team4.model.Skip;
import com.team4.repositories.SkipRepository;

@RestController
@RequestMapping("/skip")
public class SkipController {
	
	@Autowired 
	private SkipRepository skipRepo;
	
	@GetMapping("/all")
	public List<Skip> list() {
		return skipRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Skip get(@PathVariable Long id) {
		return skipRepo.getReferenceById(id);
	}
	
	@PostMapping("/add")
	public Skip create(@RequestBody final Skip skip) {
		return skipRepo.saveAndFlush(skip);
	}
	
	@PutMapping("/update")
	public Skip update(@RequestBody final Skip skip) {
		return skipRepo.saveAndFlush(skip);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		skipRepo.deleteById(id);
	}

}