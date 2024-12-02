package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CategoryDao;
import com.example.demo.model.Category;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoryService{

	@Autowired
	private CategoryDao cd;
	
	public Page<Category> findAll(Pageable p) {
		return cd.findAll(p);
	}
	public Category save(Category c) {
		return cd.save(c);
	}

	public Category findById(int id) {
		return cd.findById(id).orElseThrow();
	}

	public void deleteById(int id) {
		cd.deleteById(id);
	}

	public Category update(int id, Category c) {
		Category c2=cd.findById(id).orElseThrow();
		c2.setName(c.getName());
		c2.setDescription(c.getDescription());
		c2.setProducts(c.getProducts());
		return cd.save(c2);
	}


}
