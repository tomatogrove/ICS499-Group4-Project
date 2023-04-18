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


import com.team4.model.UserAccount;
import com.team4.repositories.UserAccountRepository;

@RestController
@RequestMapping("/useraccount")
@CrossOrigin(origins = "http://localhost:4200")
public class UserAccountController {
	
	@Autowired 
	private UserAccountRepository userAccRepo;
	
	@GetMapping("/all")
	public List<UserAccount> list() {
		return userAccRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public UserAccount get(@PathVariable Long id) {
		return userAccRepo.getReferenceById(id);
	}
	
	@PostMapping("/add")
	public UserAccount create(@RequestBody final UserAccount userAcc) {
		return userAccRepo.saveAndFlush(userAcc);
	}
	
	@PutMapping("/update")
	public UserAccount update(@RequestBody final UserAccount userAcc) {
		return userAccRepo.saveAndFlush(userAcc);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		userAccRepo.deleteById(id);
	}

}