package com.aim.aimjavaunit6.controller;

import java.util.*;
import java.time.*;

import com.aim.aimjavaunit6.model.*;
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

  @DeleteMapping(path = "{movieId}")
  public void deleteMovie(@PathVariable("movieId") Long movieId)
  {
    movieService.deleteMovie(movieId);
  }

  @PutMapping(path = "{movieId}")
  public void updateMovie(@PathVariable("movieId") Long movieId, @RequestParam(required = false) String title, @RequestParam(required = false) int movieLength, @RequestParam(required = false) LocalDate releaseDate, @RequestParam(required = false) String trailerUrl, @RequestParam(required = false) Genre genre, @RequestParam(required = false) Rating rating, @RequestParam(required = false) Director director, @RequestParam(required = false) List<Actor> actors, @RequestParam(required = false) List<Comment> comments)
  {
    movieService.updateMovie(movieId, title, movieLength, releaseDate, trailerUrl, genre, rating, director, actors, comments);
  }

}
