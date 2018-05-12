package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example4")
public class Example4Controller {

	private final static String ERROR_404 = "404";
	private final static String ERROR_500 = "500";
	
	@GetMapping("/show404")
	public ModelAndView showError404() {
		ModelAndView mav = new ModelAndView(ERROR_404);
		return mav;
	}
	
	@GetMapping("/show500")
	public ModelAndView showError500 () {
		ModelAndView mav = new ModelAndView(ERROR_500);
		return mav;
	}
}
