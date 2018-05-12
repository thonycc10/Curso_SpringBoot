package com.udemy.backendninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.backendninja.model.Person;

@Controller
@RequestMapping("/example3")
public class Examen3Controller {
	
	private static final Log LOGGER = LogFactory.getLog(Examen3Controller.class);

	public final static String FORM_VIEW = "form";
	public final static String RESULT_VIEW = "result";
	
	/*Forma 1 redirect*/
//	@GetMapping("/")
//	public String redirect() {
//		return "redirect:/example3/showform";
//	}

	/*Forma 2*/
	@GetMapping("/")
	public RedirectView redirect() {
		return new RedirectView("/example3/showform");
	}
	
	@GetMapping("/showform")
	public String showForm(Model model) {
//		LOGGER.info("INFO TRACE");
//		LOGGER.warn("WARNING TRACE");
//		LOGGER.error("ERROR TRACE");
//		LOGGER.debug("DEBUG TRACE");
		model.addAttribute("person" , new Person());
//		int i= 6/0;
		return FORM_VIEW;
	}
	
	@PostMapping("/addPerson")
	public ModelAndView addperson(@ModelAttribute("person") Person person) {
		LOGGER.info("METHOD: 'addPerson' -- PARAMS: '" + person +"'");
		ModelAndView mav = new ModelAndView(RESULT_VIEW);
		/*capturamos lo que nos enviara de la plantilla example3*/
		mav.addObject("person", person);
		LOGGER.info("TEMPLATE: '" + RESULT_VIEW + "' -- DATA: '" + person + "'");
		return mav;
	}
}
