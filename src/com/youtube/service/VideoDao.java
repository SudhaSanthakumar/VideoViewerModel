package com.youtube.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.youtube.model.Video;

@Service
public interface VideoDao  {
	
	public List<Video> getVideos();
	
	public Video getVideo(String fileName);
	
	public List<Video> getVideos(String filename);
	
	public List<Video> getVideosByTagName(String tagName);
	
	public Video updateVideoForLikes(String fileName);
	
	public void insertVideo(String filename, String tags, String channelName, String videoName) ;
	
}
