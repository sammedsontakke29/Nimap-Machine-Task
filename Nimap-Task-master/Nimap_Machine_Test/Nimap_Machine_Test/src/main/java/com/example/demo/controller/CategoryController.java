package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService cs;
	
	@PostMapping
	public Category c1(@RequestBody Category c) {
		return cs.save(c);
	}
	
	@GetMapping
	public ResponseEntity<List<Category>> c2(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size){
		Pageable p=(Pageable) PageRequest.of(page, size);
		Page<Category> cp=cs.findAll(p);
		return ResponseEntity.ok(cp.getContent());
	}
	
	@GetMapping("/{di}")
	public Category c3(@PathVariable("di") int id) {
		return cs.findById(id);
	}
	
	@DeleteMapping("/{di}")
	public void c4(@PathVariable("di")int id) {
		cs.deleteById(id);
	}
	
	@PutMapping("/{di}")
	public Category c5(@PathVariable("di") int id, @RequestBody Category c) {
		return cs.update(id, c);
	}
}