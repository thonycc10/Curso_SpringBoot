package com.udemy.backendninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	private static final Log LOG = LogFactory.getLog(ContactController.class);
	
	@GetMapping("/cancel")
	public String cancel() {
		return ViewConstant.CONTACTS;
	}
	
	@GetMapping("/contactform")
	public String redirectContac(Model model) {
		model.addAttribute("contactModel", new ContactModel());
		return ViewConstant.CONTACT_FORM;
	}
	
	@PostMapping("/addcontacts")
	public String addContacts(@ModelAttribute(name= "contactModel") ContactModel contactModel,
			Model model) {
		LOG.info("Call: addContacts() -- Con PARAMS : " + contactModel.toString());
		model.addAttribute("result", 1);
		return ViewConstant.CONTACTS;
	}
	
}
