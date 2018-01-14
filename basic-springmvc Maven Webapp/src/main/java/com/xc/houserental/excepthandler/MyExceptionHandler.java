package com.xc.houserental.excepthandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyExceptionHandler implements HandlerExceptionResolver {
	 private static final Logger logger = Logger.getLogger(MyExceptionHandler.class); 
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		 logger.error("",ex);     
		return new ModelAndView("error").addObject("exception",ex);    
	}

}
