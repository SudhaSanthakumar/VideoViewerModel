package com.youtube.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tag")
public class Tag {

	@Id
	@Column(name="tagId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int tagId;
	
	@Column(name="tagName")
	private String tagName;
	
	
	@ManyToMany(mappedBy="tags")
	private List<Video> videos;
	

	public Tag(String tagName) {
		super();
		this.tagName = tagName;
		
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	public Tag() {
		super();
	}

	

	public int getTagId() {
		return tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	
	
}
