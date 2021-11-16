package com.aim.aimjavaunit6.service;

import java.util.*;

import com.aim.aimjavaunit6.model.Movie;
import com.aim.aimjavaunit6.repository.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class MovieService 
{
 
  private final MovieRepository movieRepository;

  
  @Autowired
  public MovieService(MovieRepository movieRepository)
  {
    this.movieRepository = movieRepository;
  }

  public List<Movie> getMovies()
  {
    return movieRepository.findAll();
  }

  public Movie getMovie(Long id)
  {
    return movieRepository.findById(id).orElseThrow(() -> new IllegalStateException("Movie does not Exist."));
    //other options are findById(id).get(); or findById(id).orElse(new Movie());
  }

  public void addNewMovie(Movie movie)
  {
    Optional<Movie> movieOptional = movieRepository.findMovieByTitle(movie.getTitle());

    if(movieOptional.isPresent())
    {
      throw new IllegalStateException("Title already exists.");
    }

    movieRepository.save(movie);
  }

  public void deleteMovie(Long id)
  {

  }

  @Transactional
  public void updateMovie()
  {

  }

}
