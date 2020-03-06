package com.youtube.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reply")
public class Reply {
	
	@Id
	@Column(name="replyId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int replyId;
	
	@Column(name="replyText")
	private String replyText;
	
	
	@Column(name="likes")
	private int likes;
	
	@Column(name="dislikes")
	private int dislikes;
	
	
	@ManyToOne
	@JoinColumn(name="commentId")
	private Comment comment;

	public Reply() {
		super();
	}

	public Reply(String replyText, Comment comment) {
		super();
		this.replyText = replyText;
		this.comment=comment;
	}

	public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

	public String getReplyText() {
		return replyText;
	}

	public void setReplyText(String replyText) {
		this.replyText = replyText;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getDislikes() {
		return dislikes;
	}

	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}
	
	
	
	
	
	

}
