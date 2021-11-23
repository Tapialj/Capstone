package com.aim.aimjavaunit6.controller;

import java.util.*;

import com.aim.aimjavaunit6.model.Rating;
import com.aim.aimjavaunit6.service.RatingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
