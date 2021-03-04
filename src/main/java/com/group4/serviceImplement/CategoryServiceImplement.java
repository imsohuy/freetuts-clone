package com.group4.serviceImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group4.entity.Category;
import com.group4.repo.CategoryRepository;
import com.group4.service.CategoryService;

@Service
public class CategoryServiceImplement implements CategoryService{

	@Autowired
	CategoryRepository catRepo;

	@Override
	public Category findByCategoryName(String categoryName) {
		return catRepo.findByCategoryName(categoryName);
	}

	@Override
	public List<Integer> findAllSubCatId(int preCategoryId) {
		return catRepo.findAllSubCatId(preCategoryId);
	}

	@Override
	public List<Integer> findByCategoryNameLike(String categoryName) {
		return catRepo.findByCategoryNameLike(categoryName);
	}
}
