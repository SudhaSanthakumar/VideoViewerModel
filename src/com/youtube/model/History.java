package com.youtube.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="history")
public class History {
	
	
	@Id
	@Column(name="historyId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int historyId;
	
	
	@Column(name="videoId")
	private int videoId;
	
	@Column(name="userId")
	private int userId;
	
	@Column(name="recentWatch")
	private Date recentWatch;

	public History() {
		super();
	}

	public History(int videoId, int userId, Date recentWatch) {
		super();
		this.videoId = videoId;
		this.userId = userId;
		this.recentWatch = recentWatch;
	}
	
	

	public int getHistoryId() {
		return historyId;
	}

	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}

	public int getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getRecentWatch() {
		return recentWatch;
	}

	public void setRecentWatch(Date recentWatch) {
		this.recentWatch = recentWatch;
	}
	
	
	

}
