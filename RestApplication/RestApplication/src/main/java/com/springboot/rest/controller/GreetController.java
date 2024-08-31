package com.springboot.rest.controller;



import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.model.Greet;

@RestController
public class GreetController {

	@RequestMapping(value="/greetMe", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Greet greet() {
		Greet greet = new Greet();
		greet.setName("Dhruvik");
		greet.setMessage("Hello World!");

		return greet;
	}
}
