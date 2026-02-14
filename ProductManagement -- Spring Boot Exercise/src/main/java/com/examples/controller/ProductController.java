package com.examples.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.examples.dao.ProductDao;
import com.examples.model.Product;

@Controller
@RequestMapping("/products")
public class ProductController {

	private ProductDao dao;
	
	public ProductController(ProductDao dao) {
		this.dao = dao;
	}
	@GetMapping 
	public String list(Model model) {
		model.addAttribute("products", dao.getAll());
		return "products";
	}
	@GetMapping("/add")
	public String addForm(Model model) {
		model.addAttribute("product", new Product());
		return "add-product";
	}
	@PostMapping("/save")
	public String save(@ModelAttribute Product product) {
		dao.save(product);
		return "redirect:/products";
	}
	@GetMapping("/edit/{id}")
	public String editForm(@PathVariable int id, Model model) {
		model.addAttribute("product", dao.getById(id));
		return "edit-product";
	}
	@PostMapping("/update")
	public String update(@ModelAttribute Product product) {
		dao.update(product);
		return "redirect:/products";
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		dao.delete(id);
		return "redirect:/products";
	}
}
