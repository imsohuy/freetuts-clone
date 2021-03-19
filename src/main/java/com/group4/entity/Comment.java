package com.group4.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "comment")
public class Comment {
	@Id
    @Column(name = "comment_id")
    private Integer commentId;
    
	@Column(name = "username")
    private String username;
    
	@Column(name = "email")
    private String email;
    
	@Column(name = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
	private Date datetime;
    
	@Column(name = "like_total")
    private Integer likeTotal;
    
	@Column(name = "post_id")
    private Integer postId;
    
	@Column(name = "pre_comment_id")
    private Integer preCommentId;

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public Integer getLikeTotal() {
		return likeTotal;
	}

	public void setLikeTotal(Integer likeTotal) {
		this.likeTotal = likeTotal;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public Integer getPreCommentId() {
		return preCommentId;
	}

	public void setPreCommentId(Integer preCommentId) {
		this.preCommentId = preCommentId;
	}
}
