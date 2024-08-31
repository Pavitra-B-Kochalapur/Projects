package com.springboot.mphasis_jdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.mphasis_jdbc.dao.*;
import com.springboot.mphasis_jdbc.model.*;

@Controller
public class EProductController {

	@Autowired
	EProductDao eproductDao;
	
	@GetMapping("/listProducts")
	public String listProducts(Model model) {

		List<EProduct> products = eproductDao.getProducts();
		
		model.addAttribute("products", products);
		
		return "listProducts";
	}
}

