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

import com.team4.model.Draw2Exception;
import com.team4.repositories.Draw2ExceptionRepository;


@RestController
@RequestMapping("/draw2Exception")
public class Draw2ExceptionController {

	@Autowired 
	private Draw2ExceptionRepository draw2ExceptionRepo;
	
	@GetMapping("/all")
	public List<Draw2Exception> list() {
		return draw2ExceptionRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Draw2Exception get(@PathVariable Long id) {
		return draw2ExceptionRepo.getReferenceById(id);
	}
	
	@PostMapping("/add")
	public Draw2Exception create(@RequestBody final Draw2Exception draw2Exception) {
		return draw2ExceptionRepo.saveAndFlush(draw2Exception);
	}
	
	@PutMapping("/update")
	public Draw2Exception update(@RequestBody final Draw2Exception draw2Exception) {
		return draw2ExceptionRepo.saveAndFlush(draw2Exception);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		draw2ExceptionRepo.deleteById(id);
	}
}
