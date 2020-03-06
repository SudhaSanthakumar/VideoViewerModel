package com.youtube.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="channel")
public class Channel {

	@Id
	@Column(name="channelId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int channelId;
	
	private String channelName;
	
	
	
	public int getChannelId() {
		return channelId;
	}



	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}



	public String getChannelName() {
		return channelName;
	}
	



	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}



	public Channel(String channelName) {
		super();
		
		this.channelName = channelName;
	}



	@ManyToOne
	@JoinColumn(name="userId")
	 private User owner;
	
	
	@ManyToMany
	@JoinTable(name="channel_subscribers",  joinColumns={@JoinColumn(name="channelId", referencedColumnName="channelId")},
		    inverseJoinColumns={@JoinColumn(name="userId", referencedColumnName="userId")})
	private List<User> subscribers;
	
	@ManyToMany
	@JoinTable(name="channel_video",  joinColumns={@JoinColumn(name="channelId", referencedColumnName="channelId")},
		    inverseJoinColumns={@JoinColumn(name="videoId", referencedColumnName="videoId")})
	private List<Video> channelVideos;

	public Channel() {
		super();
	}



	public Channel(String channelName, User owner) {
		super();
		this.channelName = channelName;
		this.owner = owner;
	}



	public User getOwner() {
		return owner;
	}



	public void setOwner(User owner) {
		this.owner = owner;
	}



	public List<User> getSubscribers() {
		return subscribers;
	}



	public void setSubscribers(List<User> subscribers) {
		this.subscribers = subscribers;
	}



	public List<Video> getChannelVideos() {
		return channelVideos;
	}



	public void setChannelVideos(List<Video> channelVideos) {
		this.channelVideos = channelVideos;
	}

	
	
	
	
	
	
	
	
}
