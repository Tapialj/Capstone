package com.aim.capstone.controller;

import java.util.*;

import com.aim.capstone.model.Comment;
import com.aim.capstone.service.CommentService;

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
  public Comment createComment(@RequestBody Comment comment)
  {
    return commentService.createComment(comment);
  }

}
