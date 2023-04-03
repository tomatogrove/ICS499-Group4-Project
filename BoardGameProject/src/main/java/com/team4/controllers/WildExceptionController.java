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

import com.team4.model.WildException;
import com.team4.repositories.WildExceptionRepository;


@RestController
@RequestMapping("/wildException")
public class WildExceptionController {

	@Autowired 
	private WildExceptionRepository wildExceptionRepo;
	
	@GetMapping("/all")
	public List<WildException> list() {
		return wildExceptionRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public WildException get(@PathVariable Long id) {
		return wildExceptionRepo.getReferenceById(id);
	}
	
	@PostMapping("/add")
	public WildException create(@RequestBody final WildException wildException) {
		return wildExceptionRepo.saveAndFlush(wildException);
	}
	
	@PutMapping("/update")
	public WildException update(@RequestBody final WildException wildException) {
		return wildExceptionRepo.saveAndFlush(wildException);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		wildExceptionRepo.deleteById(id);
	}
}
