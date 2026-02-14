package com.examples.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.examples.mapper.ProductMapper;
import com.examples.model.Product;

@Repository
public class ProductDao {

	private final JdbcTemplate jdbcTemplate;
	public ProductDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Product> getAll(){
		return jdbcTemplate.query("select * from productinfo ", 
				new ProductMapper());
	}
	public Product getById(int id) {
		return jdbcTemplate.queryForObject("select * from productinfo where id = ?",
				new ProductMapper(), id);	
	}
	
	public int save(Product product) {
		String sql = "insert into productinfo(id, name, price, quantity) "
				+ "values(?, ?, ?, ?)";
		return jdbcTemplate.update(sql, product.getId(), product.getName(), 
				product.getPrice(), product.getQuantity());
	}
	
	public int update(Product product) {
		return jdbcTemplate.update("update productinfo set name = ?, "
				+ "price = ?, quantity = ? where id = ?",
				product.getName(), product.getPrice(), product.getQuantity(), 
				product.getId());
	}
	
	public int delete(int id) {
		return jdbcTemplate.update("delete from productinfo where id = ?",
				id);
	}
	
	
}
