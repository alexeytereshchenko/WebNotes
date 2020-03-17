package org.moren.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String redirectHome() {
		return "redirect:/notes";
	}
	
	@GetMapping("/api")
	public String api() {
		return "api";
	}
}
