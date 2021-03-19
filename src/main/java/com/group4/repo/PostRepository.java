package com.group4.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.group4.entity.Post;

public interface PostRepository extends CrudRepository<Post, Integer>{
	List<Post> findTop5ByCategoryIdInAndStatusOrderByPostIdDesc(List<Integer> categoryID, boolean status);
	
	List<Post> findTop20ByCategoryIdInAndStatusOrderByPostIdDesc(List<Integer> categoryID, boolean status);
	
	List<Post> findTop12ByCategoryIdInAndStatusOrderByPostIdDesc(List<Integer> categoryID, boolean status);
	
	@Query(value = "SELECT coalesce(max(p.post_id), 0) FROM post p", nativeQuery = true)
	int getMaxPostID();
	
	Post findByPostIdAndStatus(int postID, boolean status);
	
	Post findByPostId(int postID);
	
	List<Post> findByTitleLikeAndCategoryId(String title, int categoryID);
}
