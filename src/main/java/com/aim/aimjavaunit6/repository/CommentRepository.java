package com.aim.aimjavaunit6.repository;

import java.util.*;

import com.aim.aimjavaunit6.model.Comment;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface CommentRepository extends JpaRepository <Comment, Long>
{
  
  List<Comment> findByMovieId(Long movieId);

}
