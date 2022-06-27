package com.AirfTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppContoller {
	
	@Autowired
	private UserRepository therepo;
	
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/registeruser")
	public String formForSignUp(Model model) {
		model.addAttribute("user", new User());
		return "form_signup";
	}
	
	@PostMapping("/form_register")
	public String formRegistration (User user) {
	therepo.save(user);
	return " validation_form";
	}
}
