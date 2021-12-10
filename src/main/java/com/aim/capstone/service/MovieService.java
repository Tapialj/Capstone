package com.aim.capstone.service;

import java.util.*;

import com.aim.capstone.model.*;
import com.aim.capstone.model.response.AlreadyExistsException;
import com.aim.capstone.model.response.DoesNotExistException;
import com.aim.capstone.repository.MovieRepository;

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
    return movieRepository.findById(id).orElseThrow(() -> new DoesNotExistException("Movie does not exist."));
    //other options are findById(id).get(); or findById(id).orElse(new Movie());
  }

  public Movie addNewMovie(Movie movie)
  {
    Optional<Movie> movieOptional = movieRepository.findMovieByTitle(movie.getTitle());

    if(movieOptional.isPresent())
    {
      throw new AlreadyExistsException("Title already exists.");
    }

    movieRepository.save(movie);

    return movie;
  }

  public void deleteMovie(Long id)
  {
    movieRepository.deleteById(id);
  }

  @Transactional
  public Movie updateMovie(Movie movie)
  {
    movieRepository.save(movie);

    return movie;
  }

}
