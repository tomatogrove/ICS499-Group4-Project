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
 * import com.team4.model.InvalidCardException; import
 * com.team4.repositories.InvalidCardExceptionRepository;
 * 
 * 
 * @RestController
 * 
 * @RequestMapping("/invalidCardException") public class
 * InvalidCardExceptionController {
 * 
 * @Autowired private InvalidCardExceptionRepository invalidCardExceptionRepo;
 * 
 * @GetMapping("/all") public List<InvalidCardException> list() { return
 * invalidCardExceptionRepo.findAll(); }
 * 
 * @GetMapping("/{id}") public InvalidCardException get(@PathVariable Long id) {
 * return invalidCardExceptionRepo.getReferenceById(id); }
 * 
 * @PostMapping("/add") public InvalidCardException create(@RequestBody final
 * InvalidCardException invalidCardException) { return
 * invalidCardExceptionRepo.saveAndFlush(invalidCardException); }
 * 
 * @PutMapping("/update") public InvalidCardException update(@RequestBody final
 * InvalidCardException invalidCardException) { return
 * invalidCardExceptionRepo.saveAndFlush(invalidCardException); }
 * 
 * @DeleteMapping("/delete/{id}") public void delete(@PathVariable Long id) {
 * invalidCardExceptionRepo.deleteById(id); } }
 */