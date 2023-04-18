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
 * import com.team4.model.WildDraw4Exception; import
 * com.team4.repositories.WildDraw4ExceptionRepository;
 * 
 * 
 * @RestController
 * 
 * @RequestMapping("/wildDraw4Exception") public class
 * WildDraw4ExceptionController {
 * 
 * @Autowired private WildDraw4ExceptionRepository wildDraw4ExceptionRepo;
 * 
 * @GetMapping("/all") public List<WildDraw4Exception> list() { return
 * wildDraw4ExceptionRepo.findAll(); }
 * 
 * @GetMapping("/{id}") public WildDraw4Exception get(@PathVariable Long id) {
 * return wildDraw4ExceptionRepo.getReferenceById(id); }
 * 
 * @PostMapping("/add") public WildDraw4Exception create(@RequestBody final
 * WildDraw4Exception wildDraw4Exception) { return
 * wildDraw4ExceptionRepo.saveAndFlush(wildDraw4Exception); }
 * 
 * @PutMapping("/update") public WildDraw4Exception update(@RequestBody final
 * WildDraw4Exception wildDraw4Exception) { return
 * wildDraw4ExceptionRepo.saveAndFlush(wildDraw4Exception); }
 * 
 * @DeleteMapping("/delete/{id}") public void delete(@PathVariable Long id) {
 * wildDraw4ExceptionRepo.deleteById(id); } }
 */