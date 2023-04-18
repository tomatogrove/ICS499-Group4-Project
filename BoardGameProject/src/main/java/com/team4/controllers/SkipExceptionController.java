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
 * import com.team4.model.SkipException; import
 * com.team4.repositories.SkipExceptionRepository;
 * 
 * 
 * @RestController
 * 
 * @RequestMapping("/skipException") public class SkipExceptionController {
 * 
 * @Autowired private SkipExceptionRepository skipExceptionRepo;
 * 
 * @GetMapping("/all") public List<SkipException> list() { return
 * skipExceptionRepo.findAll(); }
 * 
 * @GetMapping("/{id}") public SkipException get(@PathVariable Long id) { return
 * skipExceptionRepo.getReferenceById(id); }
 * 
 * @PostMapping("/add") public SkipException create(@RequestBody final
 * SkipException skipException) { return
 * skipExceptionRepo.saveAndFlush(skipException); }
 * 
 * @PutMapping("/update") public SkipException update(@RequestBody final
 * SkipException skipException) { return
 * skipExceptionRepo.saveAndFlush(skipException); }
 * 
 * @DeleteMapping("/delete/{id}") public void delete(@PathVariable Long id) {
 * skipExceptionRepo.deleteById(id); } }
 */