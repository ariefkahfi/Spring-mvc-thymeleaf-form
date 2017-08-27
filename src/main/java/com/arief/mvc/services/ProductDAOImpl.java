package com.arief.mvc.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.arief.mvc.entity.Product;

@Repository
public class ProductDAOImpl implements ProductDAO{

	
	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	
	
	
	@Override
	public void save(Product t) {
		Map<String,Object> map = new HashMap<>();
		
		map.put("id",t.getId());
		map.put("name", t.getName());
		map.put("price", t.getPrice());
		map.put("stock", t.getStock());
		
		
		SqlParameterSource sql = new MapSqlParameterSource(map);
		
		
		jdbc.update("insert into product values (:id,:name,:price,:stock)", sql);
	
	}

	@Override
	public List<Product> getAll() {
		return jdbc.query("select * from product", new BeanPropertyRowMapper<Product>(Product.class));
	}

	@Override
	public void delete(String id) {
		Map<String,String> paramMap = new HashMap<>();
		
		paramMap.put("id", id);
		
		jdbc.update("delete from product where id = :id", paramMap);
	}

	@Override
	public Product getOne(String id) {
		Map<String,String> paramSource = new HashMap<>();
		
		paramSource.put("id", id);
		
		return jdbc.queryForObject("select * from product where id = :id", paramSource, new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet arg0, int arg1) throws SQLException {
				return new Product(arg0.getString("name"), arg0.getFloat("price"),arg0.getInt("stock"));
			}
		});
	}

	@Override
	public void update(Product newT) {
		
		Map<String,Object> map = new HashMap<>();
		
		map.put("id", newT.getId());
		
		map.put("a", newT.getName());
		map.put("b", newT.getPrice());
		map.put("c", newT.getStock());
		
		jdbc.update("update product set name = :a , price = :b , stock = :c where "
				+ " id  = :id", map);
	}

	@Override
	public void buyProduct(int qty, String id) {
		Map<String,Object> paramMap = new HashMap<>();
		
		
		paramMap.put("id", id);
		paramMap.put("qty", qty);
		
		jdbc.update("update product set stock = stock - :qty where id = :id", paramMap);
	}

}
