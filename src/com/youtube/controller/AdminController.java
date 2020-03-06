package com.youtube.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.youtube.dao.VideoService;

@Controller
public class AdminController {
	
	@Autowired
	VideoService v;
	
	@RequestMapping("/admin/tag")
	protected ModelAndView addTag(HttpServletRequest req, HttpServletResponse res) throws Exception{
				
		ModelAndView m=new ModelAndView("home");
		m.addObject("name","tag inserted");
		v.insertTag(req.getParameter("tag"));
		return m;
		
	}
	
	@RequestMapping("/admin/tagPage")
	protected ModelAndView gettagPage(HttpServletRequest req, HttpServletResponse res) throws Exception{
				
		ModelAndView m=new ModelAndView("addTag");
		return m;
		
	}

}
