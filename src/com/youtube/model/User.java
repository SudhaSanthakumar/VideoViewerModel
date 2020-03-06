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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	
	@Id
	@Column(name="userId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	
	@Column(name="userName")
	private String userName;
	
	
	@Column(name="password")
	private String password;
	
	
	@OneToMany(mappedBy="owner")
	private List<Channel> channels;
	
	@ManyToMany(mappedBy="subscribers")
	private List<Channel> subscribedChannels;
	
	
	@ManyToMany
	@JoinTable(name="user_video",  joinColumns={@JoinColumn(name="userId")},
    inverseJoinColumns={@JoinColumn(name="videoId")})
	private List<Video> likedVideos;
	
	
	
	public User() {
		super();
	}



	public User(String userName, String password) {
		super();
		
		this.userName = userName;
		this.password = password;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public List<Channel> getChannels() {
		return channels;
	}



	public void setChannels(List<Channel> channels) {
		this.channels = channels;
	}



	public List<Channel> getSubscribedChannels() {
		return subscribedChannels;
	}



	public void setSubscribedChannels(List<Channel> subscribedChannels) {
		this.subscribedChannels = subscribedChannels;
	}



	public List<Video> getLikedVideos() {
		return likedVideos;
	}



	public void setLikedVideos(List<Video> likedVideos) {
		this.likedVideos = likedVideos;
	}
	
	
	

}
