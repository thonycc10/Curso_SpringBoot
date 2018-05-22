package com.udemy.backendninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.udemy.backendninja.constant.ViewConstant;

@Controller
public class LoginController {

	private static final Log LOG = LogFactory.getLog(LoginController.class);

	@GetMapping("/login")
	public String showLoginForm(Model model,
								@RequestParam(name = "error", required = false) String error,
								@RequestParam(name = "logout", required = false) String logout) {
		LOG.info("Method: showLoginForm() -- Params: error=" + error + "logout: " + logout);
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		LOG.info("Returing to login view");
		return ViewConstant.LOGIN;
	}

	@GetMapping({"/loginsuccess", "/"})  // dos funciones
	public String loginCheck() {
		LOG.info("Method: loginCheck()" );
		LOG.info("Returing to contacts view");
		return "redirect:/contact/listcontacts";
	}
}