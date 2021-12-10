package com.aim.capstone.service;

import java.util.*;

import com.aim.capstone.model.Comment;
import com.aim.capstone.repository.CommentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CommentService 
{
  
  private final CommentRepository commentRepository;

  @Autowired
  public CommentService(CommentRepository commentRepository)
  {
    this.commentRepository = commentRepository;
  }

  public List<Comment> getAllComments()
  {
    return commentRepository.findAll();
  }

  public List<Comment> getMovieComments(Long movieId)
  {
    return commentRepository.findByMovieId(movieId);
  }

  public Comment createComment(Comment comment)
  {
    if(comment != null)
    {
      commentRepository.save(comment);
    }

    return comment;
  }

  @Transactional
  public void updateComment()
  {
    
  }

}
