package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example")
public class exampleController {

	// recomendado utilizar
	public static final String EXAMPLE_VIEW = "example";
	
	// primera forma
//	@RequestMapping(value = "/exampleString", method = RequestMethod.GET)
	@GetMapping("/exampleString")
	public String exampleString(Model model) {
		model.addAttribute("name", "Thonyd");
		return EXAMPLE_VIEW;
	}
	
	// segunda forma
//	@RequestMapping(value = "/exampleMAV", method = RequestMethod.GET)
	@GetMapping("/exampleMAV")
	public ModelAndView exampleMAV() {
		ModelAndView andView= new ModelAndView(EXAMPLE_VIEW); // añdaes el nombre de la plantilla html
		andView.addObject("name", "Remy");
//		return new ModelAndView(EXAMPLE_VIEW);
		return andView;
	}
		
}
