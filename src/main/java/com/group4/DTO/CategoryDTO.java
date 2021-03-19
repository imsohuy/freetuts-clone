package com.group4.DTO;


public class CategoryDTO{
	private Integer categoryId;
	
	private String categoryName;	
	
	private String preCategoryId;
	
	private String path;
	
	private Integer postId;	
	
	private boolean status;

	public CategoryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoryDTO(Integer categoryId, String categoryName, String preCategoryId, String path, Integer postId,
			boolean status) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.preCategoryId = preCategoryId;
		this.path = path;
		this.postId = postId;
		this.status = status;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getPreCategoryId() {
		return preCategoryId;
	}

	public void setPreCategoryId(String preCategoryId) {
		this.preCategoryId = preCategoryId;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
