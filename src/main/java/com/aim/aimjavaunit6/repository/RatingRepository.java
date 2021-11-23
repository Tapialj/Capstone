package com.aim.aimjavaunit6.repository;

import com.aim.aimjavaunit6.model.Rating;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RatingRepository extends JpaRepository<Rating, Long>
{
  
}
