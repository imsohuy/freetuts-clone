package com.group4.serviceImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group4.entity.Post;
import com.group4.repo.PostRepository;
import com.group4.service.PostService;

@Service
public class PostServiceImplement implements PostService{

	@Autowired
	PostRepository postRepo;
	
	@Override
	public List<Post> findTop5ByCategoryIdInOrderByPostIdDesc(List<Integer> categoryID) {
		return postRepo.findTop5TittleByCategoryIdInOrderByPostIdDesc(categoryID);
	}

	@Override
	public List<Post> findTop7ByCategoryIdInOrderByPostIdDesc(List<Integer> categoryID) {
		return postRepo.findTop7ByCategoryIdInOrderByPostIdDesc(categoryID);
	}

	@Override
	public List<Post> findTop12ByCategoryIdInOrderByPostIdDesc(List<Integer> categoryID) {
		return postRepo.findTop12ByCategoryIdInOrderByPostIdDesc(categoryID);
	}
	
}
