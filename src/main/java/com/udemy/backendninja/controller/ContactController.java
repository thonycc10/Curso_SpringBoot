package com.udemy.backendninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.constant.ViewConstant;
import com.udemy.backendninja.model.ContactModel;
import com.udemy.backendninja.service.ContactService;

@Controller
@RequestMapping("/contact")
public class ContactController {

//	@GetMapping("/")
//	public String redirectContac() {
//		return "redirect:/contact/contactform";
//	}
	@Autowired
	@Qualifier("contactServiceImpl")
	private ContactService contactService;
	
	private static final Log LOG = LogFactory.getLog(ContactController.class);
	
	@GetMapping("/cancel")
	public String cancel() {
		return "redirect:/contact/listcontacts";
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
		if(null != contactService.addContact(contactModel)) {
		model.addAttribute("result", 1); // utiliza para el alert
		}else {
		model.addAttribute("result", 0); // utiliza para el alert
		}
		return "redirect:/contact/listcontacts";
	}
	
	@GetMapping("/listcontacts")
	public ModelAndView listContacts() {
		ModelAndView modelAndView = new ModelAndView(ViewConstant.CONTACTS);
		modelAndView.addObject("contacts", contactService.listAllContacts());
		return modelAndView;
	}
}
