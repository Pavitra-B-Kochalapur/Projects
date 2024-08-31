package com.springboot.mphasis_jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springboot.mphasis_jdbc.model.EProduct;

@Repository
public class EProductDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<EProduct> getProducts() {
		
		return jdbcTemplate.query("select * from eproduct", new RowMapper<EProduct>() {

			@Override
			public EProduct mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				EProduct ep = new EProduct();
				ep.setId(rs.getInt(1));
				ep.setName(rs.getString(2));
				ep.setDateAdded(rs.getDate(3));
				
				return ep;
			}
			
		});
	}
}
