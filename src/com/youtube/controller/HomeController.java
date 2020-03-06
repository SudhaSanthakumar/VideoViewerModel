package com.youtube.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.youtube.dao.VideoService;
import com.youtube.model.Video;

@Controller
public class HomeController {
	
	@Autowired
	VideoService v;
	

	@RequestMapping("/home")
	protected ModelAndView getHome1(HttpServletRequest req, HttpServletResponse res) throws Exception{
				
		ModelAndView m=new ModelAndView("home");
		return m;
		
		
	}
	
	@RequestMapping("/exceptionTest")
	protected ModelAndView exceptionTest(HttpServletRequest req, HttpServletResponse res) throws Exception{
				
		ModelAndView m=new ModelAndView("home");
//		return m;
		
		throw new NullPointerException();
		
	}
	
	@RequestMapping("/newVideo")
	protected ModelAndView addNewVideo(HttpServletRequest req, HttpServletResponse res) throws Exception{
				
		ModelAndView m=new ModelAndView("newVideo");
		return m;
		
	}
	
	@RequestMapping("/video")
	protected ModelAndView insertVideo(HttpServletRequest req, HttpServletResponse res) throws Exception{
				
		ModelAndView m=new ModelAndView("home");
		m.addObject("name","video inserted");
		String filename=req.getParameter("fileName");
		String tags=req.getParameter("tags");
		String channelName=req.getParameter("channel");
		String videoName=req.getParameter("videoName");
		System.out.println("filename   "+filename);
		v.insertVideo(filename, tags, channelName,videoName);
		return m;
		
	}
	@RequestMapping("/youTubeHome")
	protected ModelAndView getHome(HttpServletRequest req, HttpServletResponse res) throws Exception{
				
		ModelAndView m=new ModelAndView("youTubeHome");
		
		m.addObject("videos",v.getVideos());
		//v.insertVideo(new Video());
		return m;
		
	}
	@RequestMapping("/subscriptions")
	protected ModelAndView getSubscriptionsPage(HttpServletRequest req, HttpServletResponse res) throws Exception{
				
		ModelAndView m=new ModelAndView("subscriptionsPage");
		
		m.addObject("videos",v.getVideos());
	
		//v.insertVideo(new Video());
		return m;
		
	}
	@RequestMapping("/redirect")
	protected ModelAndView getredirect(HttpServletRequest req, HttpServletResponse res) throws Exception{
				
		ModelAndView m=new ModelAndView("redirect");
		
		//m.addObject("videos",v.getVideos());
	
		//v.insertVideo(new Video());
		return m;
		
	}
	@RequestMapping("/likedVideos")
	protected ModelAndView getLikedVideos(HttpServletRequest req, HttpServletResponse res) throws Exception{
				
		ModelAndView m=new ModelAndView("likedVideos");
		
		m.addObject("videos",v.getVideos());
		//v.insertVideo(new Video());
		return m;
		
	}
	@RequestMapping("/historyPage")
	protected ModelAndView getHistory(HttpServletRequest req, HttpServletResponse res) throws Exception{
				
		ModelAndView m=new ModelAndView("historyPage");
		
		m.addObject("videos",v.getVideos());
		//v.insertVideo(new Video());
		return m;
		
	}
	@RequestMapping("/youTubePlay")
	protected ModelAndView playVideo(@RequestParam(name = "filename") String filename,HttpServletRequest req, HttpServletResponse res) throws Exception{
				String fileName1="1666/1666-720.mp4";
		ModelAndView m=new ModelAndView("youTubePlay");
		//m.addObject("name","video inserted");
		System.out.println("path varibale "+filename);
//		System.out.println("path varibale "+fileName2);
		m.addObject("video",v.getVideo(filename));
		m.addObject("nVideo",v.getRelatedVideos(filename).get(v.getRelatedVideos(filename).size()-1));
		m.addObject("relatedVideos",v.getRelatedVideos(filename));
		return m;
		
	}
	
	@RequestMapping("/youTubePlay/like")
	protected ModelAndView updateLike(@RequestParam(name = "f") String filename,HttpServletRequest req, HttpServletResponse res) throws Exception{
				String fileName1="1666/1666-720.mp4";
		ModelAndView m=new ModelAndView("youTubePlay");
		//m.addObject("name","video inserted");
		System.out.println("path varibale "+filename);
//		System.out.println("path varibale "+fileName2);
		m.addObject("video",v.updateVideoForLikes(filename));
		m.addObject("nVideo",v.getRelatedVideos(filename).get(v.getRelatedVideos(filename).size()-1));
		m.addObject("relatedVideos",v.getRelatedVideos(filename));
		return m;
		
	}
	

	@RequestMapping("/videos")
	protected ModelAndView getVideo(HttpServletRequest req, HttpServletResponse res) throws Exception{
				
		ModelAndView m=new ModelAndView("home");
		m.addObject("name","video inserted");
		HttpSession session=req.getSession();
		
		m.addObject("videos",v.getVideos());
		return m;
		
	}
	@RequestMapping("/channel")
	protected ModelAndView addChannel(HttpServletRequest req, HttpServletResponse res) throws Exception{
				
		ModelAndView m=new ModelAndView("home");
		m.addObject("name","channel inserted");
		v.insertChannel();	
		
		
		return m;
		
	}
	
	
	@RequestMapping("/user")
	protected ModelAndView addUser(HttpServletRequest req, HttpServletResponse res) throws Exception{
				
		ModelAndView m=new ModelAndView("home");
		m.addObject("name"," user inserted");
			v.insertUser();
		return m;
		
	}
	@RequestMapping("/comment")
	protected ModelAndView addComment(HttpServletRequest req, HttpServletResponse res) throws Exception{
				
		ModelAndView m=new ModelAndView("home");
		m.addObject("name"," comment inserted");
			v.insertComment();
		return m;
		
	}
	
	@RequestMapping("/reply")
	protected ModelAndView addReply(HttpServletRequest req, HttpServletResponse res) throws Exception{
				
		ModelAndView m=new ModelAndView("home");
		m.addObject("name"," reply inserted");
			v.addReply();
		return m;
		
	}
	@RequestMapping("/history")
	protected ModelAndView addHistory(HttpServletRequest req, HttpServletResponse res) throws Exception{
				
		ModelAndView m=new ModelAndView("home");
		m.addObject("name"," history inserted");
		v.insertHistory();
		return m;
		
	}
	
	

}
