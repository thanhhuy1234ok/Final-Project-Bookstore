package com.bookstore.client.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.client.services.CustomerService;

@Controller 
class AppController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/")
	public String showHomeView() {
		return "index";
	}
	
	@RequestMapping("/login")
	public String showLoginView() {
		return "login";
	}
}
