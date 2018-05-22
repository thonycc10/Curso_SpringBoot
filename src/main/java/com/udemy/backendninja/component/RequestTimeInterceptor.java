package com.udemy.backendninja.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.udemy.backendninja.repository.LogRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import java.util.Date;


@Component("requestTimeInterceptor") // creamos el bean
public class RequestTimeInterceptor extends HandlerInterceptorAdapter{
	
	// se extends HandlerInterceptorAdapter luego en sourc/override method

	@Autowired
	@Qualifier("logRepository")
	private LogRepository logRepository;

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
		String url = request.getRequestURL().toString();

//		tecer paso
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = "";
		if ( null != authentication && authentication.isAuthenticated()){
			username = authentication.getName();
		}
//		com.udemy.backendninja.entity.Log log = new com.udemy.backendninja.entity.Log(new Date(), authentication.getDetails().toString(), username, url )
		logRepository.save( new com.udemy.backendninja.entity.Log(new Date(), authentication.getDetails().toString(), username, url ));

		LOG.info("-- URL  to: '" + url + "' -- IN: '" + (System.currentTimeMillis() - startTime) + "'ms" );
	}


	
	
	

}
