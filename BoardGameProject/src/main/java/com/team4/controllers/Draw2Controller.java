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

import com.team4.model.Draw2;
import com.team4.repositories.Draw2Repository;

@RestController
@RequestMapping("/draw2")
public class Draw2Controller {
	
	@Autowired 
	private Draw2Repository draw2Repo;
	
	@GetMapping("/all")
	public List<Draw2> list() {
		return draw2Repo.findAll();
	}
	
	@GetMapping("/{id}")
	public Draw2 get(@PathVariable Long id) {
		return draw2Repo.getReferenceById(id);
	}
	
	@PostMapping("/add")
	public Draw2 create(@RequestBody final Draw2 draw2) {
		return draw2Repo.saveAndFlush(draw2);
	}
	
	@PutMapping("/update")
	public Draw2 update(@RequestBody final Draw2 draw2) {
		return draw2Repo.saveAndFlush(draw2);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		draw2Repo.deleteById(id);
	}

}
