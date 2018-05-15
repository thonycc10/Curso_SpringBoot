package com.udemy.backendninja.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;



@Component("requestTimeInterceptor") // creamos el bean
public class RequestTimeInterceptor extends HandlerInterceptorAdapter{
	
	// se extends HandlerInterceptorAdapter luego en sourc/override method
	
	private static final Log LOG = LogFactory.getLog(RequestTimeInterceptor.class);
		
	@Override // se ejecuta dentro del metodo
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("startTime", System.currentTimeMillis()); // tiempo en minisegundos
		return true;
	}
	
	@Override // se ejecuta justo antes que se muestre la vista return
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long startTime = (long) request.getAttribute("startTime");
		LOG.info("-- URL  to: '" + request.getRequestURL().toString() + "' -- IN: '" + (System.currentTimeMillis() - startTime) + "'ms" );
	}


	
	
	

}
