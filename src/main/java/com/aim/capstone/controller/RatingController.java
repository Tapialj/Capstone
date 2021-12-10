package com.aim.capstone.controller;

import java.util.*;

import com.aim.capstone.model.Rating;
import com.aim.capstone.service.RatingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "api/ratings")
public class RatingController 
{

  private final RatingService ratingService;

  @Autowired
  public RatingController(RatingService ratingService)
  {
    this.ratingService = ratingService;
  }

  @GetMapping
  public List<Rating> getRatings()
  {
    return ratingService.getRatings();
  }
  
}
