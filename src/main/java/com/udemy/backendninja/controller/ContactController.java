package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udemy.backendninja.constant.ViewConstant;

@Controller
@RequestMapping("/contact")
public class ContactController {

	@GetMapping("/")
	public String redirectContac() {
		return "redirect:/contact/contactform";
	}
	
	@GetMapping("/contactform")
	public String showContactForm() {
		return ViewConstant.CONTACT_FORM;
	}
	
}
