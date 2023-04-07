/*
 * package com.team4.controllers;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.web.bind.annotation.DeleteMapping; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.PutMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.team4.model.WildDraw4; import
 * com.team4.repositories.WildDraw4Repository;
 * 
 * @RestController
 * 
 * @RequestMapping("/wildDraw4") public class WildDraw4Controller {
 * 
 * @Autowired private WildDraw4Repository wildDraw4Repo;
 * 
 * @GetMapping("/all") public List<WildDraw4> list() { return
 * wildDraw4Repo.findAll(); }
 * 
 * @GetMapping("/{id}") public WildDraw4 get(@PathVariable Long id) { return
 * wildDraw4Repo.getReferenceById(id); }
 * 
 * @PostMapping("/add") public WildDraw4 create(@RequestBody final WildDraw4
 * wildDraw4) { return wildDraw4Repo.saveAndFlush(wildDraw4); }
 * 
 * @PutMapping("/update") public WildDraw4 update(@RequestBody final WildDraw4
 * wildDraw4) { return wildDraw4Repo.saveAndFlush(wildDraw4); }
 * 
 * @DeleteMapping("/delete/{id}") public void delete(@PathVariable Long id) {
 * wildDraw4Repo.deleteById(id); }
 * 
 * }
 */