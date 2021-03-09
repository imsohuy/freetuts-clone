package com.group4.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.group4.entity.Post;

public interface PostRepository extends CrudRepository<Post, Integer>{
	List<Post> findTop5TittleByCategoryIdInOrderByPostIdDesc(List<Integer> categoryID);
	
	List<Post> findTop20ByCategoryIdInOrderByPostIdDesc(List<Integer> categoryID);
	
	List<Post> findTop12ByCategoryIdInOrderByPostIdDesc(List<Integer> categoryID);
}
