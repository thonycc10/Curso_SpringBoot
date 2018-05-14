package com.udemy.backendninja.controller;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.LogMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.backendninja.service.EjercicioService;

@Controller
@RequestMapping("/ejercicio")
public class EjercicioController {
	
	public static final String SHOW_EJERCICIO = "example";
	
	@Autowired
	@Qualifier("ejercicioService")
	private EjercicioService ejercicioService;
	
	@Autowired
	private HttpServletRequest request;
	
	@GetMapping("/")
	public RedirectView redirecEjercicio(){
		return new RedirectView("/ejercicio/showFormEjercicio");
	}
	
	
	@GetMapping("/showFormEjercicio")
	public ModelAndView showFormEjercicio() {
		long timeInt = (long) request.getAttribute("startTime");
		ModelAndView mav = new ModelAndView(SHOW_EJERCICIO);
		mav.addObject("mensaje", "Este es el mensaje");
		mav.addObject("people", ejercicioService.findAll()); // igual aqui people debe ser como 
		long timeDifference = System.currentTimeMillis() - timeInt;
		System.out.println("Total TIME: " +timeDifference+ "ms");
		return mav;
	}
	
}
