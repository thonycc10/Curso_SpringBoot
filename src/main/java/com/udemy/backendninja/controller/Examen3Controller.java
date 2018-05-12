package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.model.Person;

@Controller
@RequestMapping("/example3")
public class Examen3Controller {

	public final static String FORM_VIEW = "form";
	public final static String RESULT_VIEW = "result";
	
	@GetMapping("/showform")
	public String showForm(Model model) {
		model.addAttribute("person" , new Person());
		return FORM_VIEW;
	}
	
	@PostMapping("/addPerson")
	public ModelAndView addperson(@ModelAttribute("person") Person person) {
		ModelAndView mav = new ModelAndView(RESULT_VIEW);
		/*capturamos lo que nos enviara de la plantilla example3*/
		mav.addObject("person", person);
		return mav;
	}
}
