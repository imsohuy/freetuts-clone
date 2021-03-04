package com.group4.repo;

import org.springframework.data.repository.CrudRepository;

import com.group4.entity.Comment;

public interface CommentRepository extends CrudRepository<Comment, Integer>{

}
