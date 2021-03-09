package com.group4.service;

import java.util.List;

import com.group4.entity.Post;

public interface PostService {
	List<Post> findTop5ByCategoryIdInOrderByPostIdDesc(List<Integer> categoryID);

	List<Post> findTop20ByCategoryIdInOrderByPostIdDesc(List<Integer> categoryID);

	List<Post> findTop12ByCategoryIdInOrderByPostIdDesc(List<Integer> categoryID);
}
