package com.aim.aimjavaunit6.service;

import java.util.*;

import com.aim.aimjavaunit6.model.Rating;
import com.aim.aimjavaunit6.repository.RatingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService 
{
  
  private final RatingRepository ratingRepository;

  @Autowired
  public RatingService(RatingRepository ratingRepository)
  {
    this.ratingRepository = ratingRepository;
  }

  public List<Rating> getRatings()
  {
    return ratingRepository.findAll();
  }
}
