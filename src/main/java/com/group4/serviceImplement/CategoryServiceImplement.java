package com.group4.serviceImplement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group4.DTO.CategoryDTO;
import com.group4.entity.Category;
import com.group4.entity.Post;
import com.group4.repo.CategoryRepository;
import com.group4.repo.PostRepository;
import com.group4.service.CategoryService;

@Service
public class CategoryServiceImplement implements CategoryService{

	@Autowired
	CategoryRepository catRepo;
	
	@Autowired
	PostRepository postRepo;
	
	@Autowired
	ModelMapper mapper;

	@Override
	public CategoryDTO findByCategoryName(String categoryName) {
		Category category = catRepo.findByCategoryName(categoryName);
		if(category != null) {
			CategoryDTO categoryDTO = mapper.map(category, CategoryDTO.class);
			return categoryDTO;
		}
		return null;
	}

	@Override
	public List<Integer> findAllSubCatId(int preCategoryId) {
		return catRepo.findAllSubCatId(preCategoryId);
	}

	@Override
	public List<Integer> findByCategoryNameLike(String categoryName) {
		return catRepo.findByCategoryNameLike(categoryName);
	}

	@Override
	public List<CategoryDTO> findAll() {
		List <Category> categoryList = catRepo.findAll();
		List<CategoryDTO> categoryDTOList = new ArrayList<CategoryDTO>();
		for (Iterator<Category> iterator = categoryList.iterator(); iterator.hasNext();) {
			Category category = (Category) iterator.next();
			CategoryDTO categoryDTO = mapper.map(category, CategoryDTO.class);
			categoryDTOList.add(categoryDTO);
		}
		return categoryDTOList;
	}

	@Override
	public List<CategoryDTO> findByStatus(boolean status) {
		List <Category> categoryList = catRepo.findByStatus(status);
		List<CategoryDTO> categoryDTOList = new ArrayList<CategoryDTO>();
		for (Iterator<Category> iterator = categoryList.iterator(); iterator.hasNext();) {
			Category category = (Category) iterator.next();
			CategoryDTO categoryDTO = mapper.map(category, CategoryDTO.class);
			categoryDTOList.add(categoryDTO);
		}
		return categoryDTOList;
	}

	@Override
	public CategoryDTO findByPostId(Integer postID) {
		Post post = postRepo.findByPostId(postID);
		Category category = catRepo.findByCategoryId(post.getCategoryId());
		if(category != null) {
			CategoryDTO categoryDTO = mapper.map(category, CategoryDTO.class);
			return categoryDTO;
		}
		return null;
	}
}
