package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductDao;
import com.example.demo.model.Product;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class ProductService{

	@Autowired
	private ProductDao pd;

	public Page<Product> findAll(Pageable p) {
		return pd.findAll(p);
	}

	public Product save(Product p) {
		return pd.save(p);
	}

	public void deleteById(int id) {
		pd.deleteById(id);
	}

	public Product findById(int id) {
		return pd.findById(id).orElseThrow();
	}

	public Product update(int id, Product p) {
		Product p2=pd.findById(id).orElseThrow();
		p2.setName(p.getName());
		p2.setPrice(p.getPrice());
		p2.setCategory(p.getCategory());
		return pd.save(p2);
	}

}