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

import com.team4.model.ReverseException;
import com.team4.repositories.ReverseExceptionRepository;


@RestController
@RequestMapping("/reverseException")
public class ReverseExceptionController {

	@Autowired 
	private ReverseExceptionRepository reverseExceptionRepo;
	
	@GetMapping("/all")
	public List<ReverseException> list() {
		return reverseExceptionRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public ReverseException get(@PathVariable Long id) {
		return reverseExceptionRepo.getReferenceById(id);
	}
	
	@PostMapping("/add")
	public ReverseException create(@RequestBody final ReverseException reverseException) {
		return reverseExceptionRepo.saveAndFlush(reverseException);
	}
	
	@PutMapping("/update")
	public ReverseException update(@RequestBody final ReverseException reverseException) {
		return reverseExceptionRepo.saveAndFlush(reverseException);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		reverseExceptionRepo.deleteById(id);
	}
}
