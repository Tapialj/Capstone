package com.aim.aimjavaunit6.model;

import java.time.*;
import javax.persistence.*;


@Entity
@Table(name = "movies")
public class Movie 
{
  
  @Id
  @SequenceGenerator(name = "movie_sequence", sequenceName = "movie_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "movie_sequence")
  @Column(name = "movie_id")
  private Long id;
  @Column(name = "title")
  private String title;
  @Column(name = "genre")
  private String genre;
  @Column(name = "movie_length")
  private int movieLength;
  @Column(name = "release_date")
  private LocalDate releaseDate;
  @Column(name = "trailer_url")
  private String trailerUrl;
  @Column(name = "rating_id")
  private Long ratingId;
  @Column(name = "director_id")
  private Long directorId;

  
  public Movie()
  {

  }

  public Movie(String title, String genre, int movieLength, LocalDate releaseDate, String trailerUrl, Long ratingId, Long directorId) 
  {
    this.title = title;
    this.genre = genre;
    this.movieLength = movieLength;
    this.releaseDate = releaseDate;
    this.trailerUrl = trailerUrl;
    this.ratingId = ratingId;
    this.directorId = directorId;
  }

  public Movie(Long id, String title, String genre, int movieLength, LocalDate releaseDate, String trailerUrl, Long ratingId, Long directorId) 
  {
    this.id = id;
    this.title = title;
    this.genre = genre;
    this.movieLength = movieLength;
    this.releaseDate = releaseDate;
    this.trailerUrl = trailerUrl;
    this.ratingId = ratingId;
    this.directorId = directorId;
  }

  public Long getid()
  {
    return id;
  }

  public void setid(Long id) 
  {
    this.id = id;
  }

  public String getTitle() 
  {
    return title;
  }

  public void setTitle(String title) 
  {
    this.title = title;
  }

  public String getGenre() 
  {
    return genre;
  }

  public void setGenre(String genre) 
  {
    this.genre = genre;
  }

  public int getMovieLength() 
  {
    return movieLength;
  }

  public void setMovieLength(int movieLength) 
  {
    this.movieLength = movieLength;
  }

  public LocalDate getReleaseDate() 
  {
    return releaseDate;
  }

  public void setReleaseDate(LocalDate releaseDate) 
  {
    this.releaseDate = releaseDate;
  }

  public String getTrailerUrl() 
  {
    return trailerUrl;
  }

  public void setTrailerUrl(String trailerUrl) 
  {
    this.trailerUrl = trailerUrl;
  }

  public Long getRatingId() 
  {
    return ratingId;
  }

  public void setRatingId(Long ratingId) 
  {
    this.ratingId = ratingId;
  }

  public Long getDirectorId() 
  {
    return directorId;
  }

  public void setDirectorId(Long directorId) 
  {
    this.directorId = directorId;
  }
  
}