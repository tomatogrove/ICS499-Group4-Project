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

import com.team4.model.Chess;
import com.team4.repositories.ChessRepository;

@RestController
@RequestMapping("/chess")
public class ChessController {

	@Autowired 
	private ChessRepository ChessRepo;
	
	@GetMapping("/all")
	public List<Chess> list() {
		return ChessRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Chess get(@PathVariable Long id) {
		return ChessRepo.getReferenceById(id);
	}
	
	@PostMapping("/add")
	public Chess create(@RequestBody final Chess chess) {
		return ChessRepo.saveAndFlush(chess);
	}
	
	@PutMapping("/update")
	public Chess update(@RequestBody final Chess chess) {
		return ChessRepo.saveAndFlush(chess);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		ChessRepo.deleteById(id);
	}
	
}
