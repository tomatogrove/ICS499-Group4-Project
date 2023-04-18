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

import com.team4.model.Numbered;
import com.team4.repositories.NumberedRepository;

@RestController
@RequestMapping("/numbered")
public class NumberedController {
	
	@Autowired 
	private NumberedRepository numberedRepo;
	
	@GetMapping("/all")
	public List<Numbered> list() {
		return numberedRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Numbered get(@PathVariable Long id) {
		return numberedRepo.getReferenceById(id);
	}
	
	@PostMapping("/add")
	public Numbered create(@RequestBody final Numbered numbered) {
		return numberedRepo.saveAndFlush(numbered);
	}
	
	@PutMapping("/update")
	public Numbered update(@RequestBody final Numbered numbered) {
		return numberedRepo.saveAndFlush(numbered);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		numberedRepo.deleteById(id);
	}

}