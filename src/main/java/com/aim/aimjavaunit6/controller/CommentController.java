package com.aim.aimjavaunit6.controller;

import java.util.*;

import com.aim.aimjavaunit6.model.Comment;
import com.aim.aimjavaunit6.model.Movie;
import com.aim.aimjavaunit6.service.ActorService;
import com.aim.aimjavaunit6.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "api/comments")
public class CommentController 
{

  private final CommentService commentService;

  @Autowired
  public CommentController(CommentService commentService)
  {
    this.commentService = commentService;
  }

  @GetMapping
  public List<Comment> getAllComments()
  {
    return commentService.getAllComments();
  }

  @GetMapping(path = "{movieId}")
  public List<Comment> getMovieComments(@PathVariable("movieId") Long movieId)
  {
    return commentService.getMovieComments(movieId);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void createComment(Comment comment)
  {
    commentService.createComment(comment);
  }

}
