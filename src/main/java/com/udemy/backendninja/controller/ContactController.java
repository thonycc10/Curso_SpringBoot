package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udemy.backendninja.constant.ViewConstant;
import com.udemy.backendninja.model.ContactModel;

@Controller
@RequestMapping("/contact")
public class ContactController {

//	@GetMapping("/")
//	public String redirectContac() {
//		return "redirect:/contact/contactform";
//	}
	
	@GetMapping("/cancel")
	public String cancel() {
		return ViewConstant.CONTACTS;
	}
	
	@GetMapping("/contactform")
	public String redirectContac(Model model) {
		model.addAttribute("contact", new ContactModel());
		return ViewConstant.CONTACT_FORM;
	}
	
}
