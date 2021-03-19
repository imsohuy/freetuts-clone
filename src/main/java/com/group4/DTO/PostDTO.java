package com.group4.DTO;

import java.util.Date;

public class PostDTO{
	
    private Integer postId;
    
    private String title;
    
    private Date date;
    
    private String description;
    
    private String image;
    
    private String postContent;
    
    private String author;
    
    private Integer categoryId;
    
    private Integer templateId;
    
    private boolean status;

	public PostDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PostDTO(Integer postId, String title, Date date, String description, String image, String postContent,
			String author, Integer categoryId, Integer templateId, boolean status) {
		super();
		this.postId = postId;
		this.title = title;
		this.date = date;
		this.description = description;
		this.image = image;
		this.postContent = postContent;
		this.author = author;
		this.categoryId = categoryId;
		this.templateId = templateId;
		this.status = status;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	
	
}
