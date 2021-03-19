package com.group4.service;

import java.util.List;

import com.group4.DTO.PostDTO;

public interface PostService {
	List<PostDTO> findTop5ByCategoryIdInAndStatusOrderByPostIdDesc(List<Integer> categoryID, boolean status);

	List<PostDTO> findTop20ByCategoryIdInAndStatusOrderByPostIdDesc(List<Integer> categoryID, boolean status);

	List<PostDTO> findTop12ByCategoryIdInAndStatusOrderByPostIdDesc(List<Integer> categoryID, boolean status);
	
	int getMaxPostID();
	
	boolean createUpdatePost(PostDTO postDTO);
	
	PostDTO findByPostIDAndStatus(int postID, boolean status);
	
	PostDTO findByPostId(int postID);
	
	List<PostDTO> findByTitleLikeAndCategoryId(String title, int categoryID);
}
