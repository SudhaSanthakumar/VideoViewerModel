package com.youtube.model;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="comment")
public class Comment {
	
	@Id
	@Column(name="commentId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int commentId;
	
	@Column(name="commentText")
	private String commentText;
	

	@Column(name="likes")
	private int likes;
	
	@Column(name="dislikes")
	private int dislikes;
	
	@ManyToOne
	@JoinColumn(name="videoId")
	private Video video;
	

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

	@OneToMany(mappedBy="comment")
	private List<Reply> replies;

	public Comment() {
		super();
	}

	

	public Comment(String commentText, Video video) {
		super();
		this.commentText = commentText;
		this.video = video;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public List<Reply> getReplies() {
		return replies;
	}

	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}
	
	
	

}
