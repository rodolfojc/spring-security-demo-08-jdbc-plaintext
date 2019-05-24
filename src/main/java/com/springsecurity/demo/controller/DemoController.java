package com.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/")
	public String showHome() {
		
		return"home";
	}
	
	//ADD REQUEST MAPPING FOR LEADERS
	@GetMapping("/leaders")
	public String showsLeaders() {
		
		return "leaders";
	}
	
	//ADD REQUEST MAPPING FOR LEADERS
	@GetMapping("/systems")
	public String showsSystems() {
			
		return "systems";
	}
	
	
}
