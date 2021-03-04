package com.group4.service;

import java.util.List;

import com.group4.entity.Category;

public interface CategoryService {
	Category findByCategoryName(String categoryName);
	
	List<Integer> findAllSubCatId(int preCategoryId);
	
	List<Integer> findByCategoryNameLike(String categoryName);
}
