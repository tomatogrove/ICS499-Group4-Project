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

import com.team4.model.UserInterface;
import com.team4.repositories.UserInterfaceRepository;

@RestController
@RequestMapping("/users")
public class UserInterfaceController {

	@Autowired
	private UserInterfaceRepository userInterfaceRepo;
	
	
	@GetMapping("/all")
	public List<UserInterface> list() {
		return userInterfaceRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public UserInterface get(@PathVariable Long id) {
		return userInterfaceRepo.getReferenceById(id);
	}
	
	@PostMapping("/add")
	public UserInterface create(@RequestBody final UserInterface user) {
		return userInterfaceRepo.saveAndFlush(user);
	}
	
	@PutMapping("/update")
	public UserInterface update(@RequestBody final UserInterface user) {
		return userInterfaceRepo.saveAndFlush(user);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		userInterfaceRepo.deleteById(id);
	}
}
