package com.aim.capstone.controller;

import java.util.*;

import com.aim.capstone.model.*;
import com.aim.capstone.service.MovieService;

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
  public Movie createMovie(@RequestBody Movie movie)
  {
    return movieService.addNewMovie(movie);
  }

  @DeleteMapping(path = "{movieId}")
  public void deleteMovie(@PathVariable("movieId") Long movieId)
  {
    movieService.deleteMovie(movieId);
  }

  @PutMapping(path = "{movieId}")
  public Movie updateMovie(@RequestBody Movie movie)
  {
    return movieService.updateMovie(movie);
  }

}
