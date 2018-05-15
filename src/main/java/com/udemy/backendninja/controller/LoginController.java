package com.udemy.backendninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.udemy.backendninja.constant.ViewConstant;
import com.udemy.backendninja.model.UserCredencial;

@Controller
public class LoginController {

	private static final Log LOG = LogFactory.getLog(LoginController.class);
	
	@GetMapping("/")
	public String redirecToLogin() {
		LOG.info("Method: redirecToLogin() " );
	return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String showLoginForm(Model model,
			@RequestParam(name="error", required=false) String error,
			@RequestParam(name="logout", required=false) String logout) {
		LOG.info("Method: showLoginForm() -- Params: error=" + error + "logout: " + logout );
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		model.addAttribute("userCredencial", new UserCredencial());
		LOG.info("Returing to login view");
		return ViewConstant.LOGIN;
	}
	
	@PostMapping("/logincheck")
	public String loginCheck(@ModelAttribute(name="userCredencial") UserCredencial userCredencial) {
		LOG.info("Method: loginCheck() -- Params: userCredencial=" + userCredencial.toString() );
		if(userCredencial.getUsername().equals("user") && userCredencial.getPassword().equals("user")) {
			LOG.info("Returing to contacts view");
			return ViewConstant.CONTACTS;
		}
		LOG.error("Redirect to login?error");
		return "redirect:/login?error";
	}
}
