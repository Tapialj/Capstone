package com.aim.aimjavaunit6.service;

import java.util.*;
import java.time.*;

import com.aim.aimjavaunit6.model.*;
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
    return movieRepository.findById(id).orElseThrow(() -> new IllegalStateException("Movie does not exist."));
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
  public void updateMovie(Long movieId, String title, int movieLength, LocalDate releaseDate, String trailerUrl, Genre genre, Rating rating, Director director, List<Actor> actors, List<Comment> comments)
  {
    Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new IllegalStateException("Movie with ID " + movieId + " does not exist."));

    if(title != null && title.length() > 0 && Objects.equals(movie.getTitle(), title))
    {
      movie.setTitle(title);
    }

    if(movieLength > 0 && Objects.equals(movie.getMovieLength(), movieLength))
    {
      movie.setMovieLength(movieLength);
    }

    if(releaseDate != null && Objects.equals(movie.getReleaseDate(), releaseDate))
    {
      movie.setReleaseDate(releaseDate);
    }

    if(trailerUrl != null && trailerUrl.length() > 0 && Objects.equals(movie.getTrailerUrl(), trailerUrl))
    {
      movie.setTrailerUrl(trailerUrl);
    }

    if(genre != null && Objects.equals(movie.getGenre(), genre))
    {
      movie.setGenre(genre);
    }

    if(rating != null && Objects.equals(movie.getRating(), rating))
    {
      movie.setRating(rating);
    }

    if(director != null && Objects.equals(movie.getDirector(), director))
    {
      movie.setDirector(director);
    }

    if(actors != null && actors.size() > 0)
    {
      List<Actor> actorCheck = movie.getActors();
      Collections.sort(actors);
      Collections.sort(actorCheck);

      if(actors.equals(actorCheck))
      {
        movie.setActors(actors);
      }
    }

    if(comments != null && comments.size() > 0)
    {
      List<Comment> commentsCheck = movie.getComments();
      Collections.sort(comments);
      Collections.sort(commentsCheck);

      if(comments.equals(commentsCheck))
      {
        movie.setComments(comments);
      }
    }
  }

}
