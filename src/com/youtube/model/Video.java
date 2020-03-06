package com.youtube.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="video")
public class Video {

	@Id
	@Column(name="videoId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int videoId;
	
	@Column(name="videoName")
	private String videoName;
	
	@Column(name="createdOn")
	private Date createdOn;
	
	@Column(name="lastUpdated")
	private Date lastUpdated;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="video_tag",  joinColumns={@JoinColumn(name="videoId")},
    inverseJoinColumns={@JoinColumn(name="tagId")})
	private List<Tag> tags;
	
	@Column(name="likes")
	private Integer likes;
	
	@Column(name="dislikes")
	private Integer dislikes;
	
	@Column(name="views")
	private Integer views;
	
	@Column(name="shares")
	private Integer shares;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="channelId")
	private Channel channel;
	
	@Column(name="fileName")
	private String fileName;
	
	@OneToMany(mappedBy="video")
	private List<Comment> comments;
	
	@ManyToMany(mappedBy="likedVideos")
	private List<User> user;

	public Video(String videoName, Date createdOn, List<Tag> tags, Channel channel, String fileName) {
		super();
		this.videoName = videoName;
		this.createdOn = createdOn;
		this.tags = tags;
		this.channel = channel;
		this.fileName = fileName;
	}



	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Video() {
		super();
	}

	
	public Integer getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public Integer getDislikes() {
		return dislikes;
	}

	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public Integer getShares() {
		return shares;
	}

	public void setShares(int shares) {
		this.shares = shares;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	
	
	
	
}
