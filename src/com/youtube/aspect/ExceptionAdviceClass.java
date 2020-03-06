package com.youtube.aspect;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
@Component
public class ExceptionAdviceClass {
	
	
	@ExceptionHandler(Exception.class)
	public ModelAndView exceptionHandler(Exception ex) {
		ModelAndView m=new ModelAndView("error");
		m.addObject("errorMessage", "THere is an Exception" + ex.toString());
		System.out.println("inside excception class" +ex);	
		return m;
		
	}

}
