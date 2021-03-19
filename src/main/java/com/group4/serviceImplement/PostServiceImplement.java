package com.group4.serviceImplement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group4.DTO.PostDTO;
import com.group4.entity.Post;
import com.group4.repo.PostRepository;
import com.group4.service.PostService;

@Service
public class PostServiceImplement implements PostService{

	@Autowired
	PostRepository postRepo;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public List<PostDTO> findTop5ByCategoryIdInAndStatusOrderByPostIdDesc(List<Integer> categoryID, boolean status) {
		List <Post> postList = postRepo.findTop5ByCategoryIdInAndStatusOrderByPostIdDesc(categoryID, status);
		List<PostDTO> postDTOList = new ArrayList<PostDTO>();
		for (Iterator<Post> iterator = postList.iterator(); iterator.hasNext();) {
			Post post = (Post) iterator.next();
			PostDTO postDTO = mapper.map(post, PostDTO.class);
			postDTOList.add(postDTO);
		}
		return postDTOList;
	}

	@Override
	public List<PostDTO> findTop20ByCategoryIdInAndStatusOrderByPostIdDesc(List<Integer> categoryID, boolean status) {
		List <Post> postList = postRepo.findTop20ByCategoryIdInAndStatusOrderByPostIdDesc(categoryID, status);
		List<PostDTO> postDTOList = new ArrayList<PostDTO>();
		for (Iterator<Post> iterator = postList.iterator(); iterator.hasNext();) {
			Post post = (Post) iterator.next();
			PostDTO postDTO = mapper.map(post, PostDTO.class);
			postDTOList.add(postDTO);
		}
		return postDTOList;
	}

	@Override
	public List<PostDTO> findTop12ByCategoryIdInAndStatusOrderByPostIdDesc(List<Integer> categoryID, boolean status) {
		List <Post> postList = postRepo.findTop12ByCategoryIdInAndStatusOrderByPostIdDesc(categoryID, status);
		List<PostDTO> postDTOList = new ArrayList<PostDTO>();
		for (Iterator<Post> iterator = postList.iterator(); iterator.hasNext();) {
			Post post = (Post) iterator.next();
			PostDTO postDTO = mapper.map(post, PostDTO.class);
			postDTOList.add(postDTO);
		}
		return postDTOList;
	}

	@Override
	public int getMaxPostID() {
		return postRepo.getMaxPostID();
	}

	@Override
	public boolean createUpdatePost(PostDTO postDTO) {
		// TODO Auto-generated method stub
		try {
			Post post = mapper.map(postDTO, Post.class);
			postRepo.save(post);
			return true;
		}
		catch(IllegalArgumentException ex) {
			return false;
		}
	}

	@Override
	public PostDTO findByPostIDAndStatus(int postID, boolean status) {
		// TODO Auto-generated method stub
		Post post = postRepo.findByPostIdAndStatus(postID, status);
		if(post != null) {
			PostDTO postDTO = mapper.map(post, PostDTO.class);
			return postDTO;
		}
		return null;
	}

	@Override
	public List<PostDTO> findByTitleLikeAndCategoryId(String title, int categoryID) {
		List<Post> postList = postRepo.findByTitleLikeAndCategoryId(title, categoryID);
		List<PostDTO> postDTOList = new ArrayList<PostDTO>();
		for (Iterator<Post> iterator = postList.iterator(); iterator.hasNext();) {
			Post post = (Post) iterator.next();
			PostDTO postDTO = mapper.map(post, PostDTO.class);
			postDTOList.add(postDTO);
		}
		return postDTOList;
	}

	@Override
	public PostDTO findByPostId(int postID) {
		Post post = postRepo.findByPostId(postID);
		if(post != null) {
			PostDTO postDTO = mapper.map(post, PostDTO.class);
			return postDTO;
		}
		return null;
	}
	
}
