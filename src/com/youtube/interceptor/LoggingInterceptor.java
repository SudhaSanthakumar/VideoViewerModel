package com.youtube.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoggingInterceptor implements HandlerInterceptor {
	
		
	@Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Inside pre handle"+request.getRequestURI());
        
        if(request.getRequestURI().contains("subscriptions") || request.getRequestURI().contains("likedVideos") ||request.getRequestURI().contains("historyPage") ) {
        	
        	System.out.println(request.getContextPath()+"/redirect");
        	response.sendRedirect(request.getContextPath()+"/redirect");
        return true;
        }
        else
        	return true;
    }
 
    @Override
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        //System.out.println("Inside post handle "+modelAndView.getViewName());
        
    
    }
    
    
    @Override
    public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception exception)
            throws Exception {
        System.out.println("Inside after completion");
    }
}
