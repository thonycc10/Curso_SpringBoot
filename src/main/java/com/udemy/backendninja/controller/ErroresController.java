package com.udemy.backendninja.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErroresController {

	public static final String ISE_VIEW = "error/500";
	
	@ExceptionHandler(Exception.class)
	public String showInternalSErverError() {
		return "ISE_VIEW";
	}
}
