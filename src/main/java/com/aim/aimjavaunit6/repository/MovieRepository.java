package com.aim.aimjavaunit6.repository;

import java.util.*;

import com.aim.aimjavaunit6.model.Movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>
{
  
  @Query("SELECT m FROM Movie m WHERE m.title = ?1")
  Optional<Movie> findMovieByTitle(String title);

}
