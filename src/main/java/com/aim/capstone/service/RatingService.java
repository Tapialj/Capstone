package com.aim.capstone.service;

import java.util.*;

import com.aim.capstone.model.Rating;
import com.aim.capstone.repository.RatingRepository;

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
