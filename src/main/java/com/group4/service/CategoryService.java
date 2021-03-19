package com.group4.service;

import java.util.List;

import com.group4.DTO.CategoryDTO;

public interface CategoryService {
	CategoryDTO findByCategoryName(String categoryName);
	
	CategoryDTO findByPostId(Integer postID);
	
	List<Integer> findAllSubCatId(int preCategoryId);
	
	List<Integer> findByCategoryNameLike(String categoryName);
	
	List<CategoryDTO> findAll();
	
	List<CategoryDTO> findByStatus(boolean status);
}
