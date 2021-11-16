package com.aim.aimjavaunit6.controller;

import java.util.*;

import com.aim.aimjavaunit6.model.Movie;
import com.aim.aimjavaunit6.service.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "api/movies")
public class MovieController 
{

  private final MovieService movieService;

  @Autowired
  public MovieController(MovieService movieService)
  {
    this.movieService = movieService;
  }

  @GetMapping
  public List<Movie> getMovies()
  {
    return movieService.getMovies();
  }

  @GetMapping(path = "{movieId}")
  public Movie getMovie(@PathVariable("movieId") Long movieId)
  {
    return movieService.getMovie(movieId);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void createMovie(@RequestBody Movie movie)
  {
    movieService.addNewMovie(movie);
  }

}
