package com.aim.capstone.model;

import java.time.*;
import java.util.*;
import javax.persistence.*;

//import com.fasterxml.jackson.annotation.*;
//import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "movies")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Movie implements Comparable<Movie>
{
  
  @Id
  @SequenceGenerator(name = "movie_sequence", sequenceName = "movie_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "movie_sequence")
  @Column(name = "id")
  private Long id;
  @Column(name = "title")
  private String title;
  @Column(name = "movie_length")
  private int movieLength;
  @Column(name = "release_date")
  private LocalDate releaseDate;
  @Column(name = "trailer_url")
  private String trailerUrl;
  @ManyToOne
  @JoinColumn(name = "genre_id", referencedColumnName = "id", nullable = false)
  private Genre genre;
  @ManyToOne
  @JoinColumn(name = "rating_id", referencedColumnName = "id", nullable = false)
  private Rating rating;
  @ManyToOne
  @JoinColumn(name = "director_id", referencedColumnName = "id")
  private Director director;
  @ManyToMany(fetch = FetchType.LAZY)//cascade = {CascadeType.MERGE, CascadeType.PERSIST})
  @JoinTable(name = "movie_cast", 
    joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "id"))
  private List<Actor> actors;
  @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
  private List<Comment> comments;
  
  
  public Movie()
  {

  }

  public Movie(String title, int movieLength, LocalDate releaseDate, String trailerUrl, Genre genre, Rating rating, Director director)
  {
    this.title = title;
    this.movieLength = movieLength;
    this.releaseDate = releaseDate;
    this.trailerUrl = trailerUrl;
    this.genre = genre;
    this.rating = rating;
    this.director = director;
  }

  public Movie(String title, int movieLength, LocalDate releaseDate, String trailerUrl, Genre genre, Rating rating, Director director, List<Actor> actors)
  {
    this.title = title;
    this.movieLength = movieLength;
    this.releaseDate = releaseDate;
    this.trailerUrl = trailerUrl;
    this.genre = genre;
    this.rating = rating;
    this.director = director;
    this.actors = actors;
  }

  public Movie(Long id, String title, int movieLength, LocalDate releaseDate, String trailerUrl, Genre genre, Rating rating, Director director)
  {
    this.id = id;
    this.title = title;
    this.movieLength = movieLength;
    this.releaseDate = releaseDate;
    this.trailerUrl = trailerUrl;
    this.genre = genre;
    this.rating = rating;
    this.director = director;
  }

  public Movie(Long id, String title, int movieLength, LocalDate releaseDate, String trailerUrl, Genre genre, Rating rating, Director director, List<Actor> actors)
  {
    this.id = id;
    this.title = title;
    this.movieLength = movieLength;
    this.releaseDate = releaseDate;
    this.trailerUrl = trailerUrl;
    this.genre = genre;
    this.rating = rating;
    this.director = director;
    this.actors = actors;
  }

  @Override
  public int compareTo(Movie m)
  {
    return this.getId().compareTo(m.getId());
  }

  public Long getId()
  {
    return id;
  }

  public void setId(Long id)
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

  public Genre getGenre()
  {
    return genre;
  }

  public void setGenre(Genre genre)
  {
    this.genre = genre;
  }

  public Rating getRating()
  {
    return rating;
  }

  public void setRating(Rating rating)
  {
    this.rating = rating;
  }

  public Director getDirector()
  {
    return director;
  }

  public void setDirector(Director director)
  {
    this.director = director;
  }

  public List<Actor> getActors()
  {
    return actors;
  }

  public void setActors(List<Actor> actors)
  {
    this.actors = actors;
  }

  public List<Comment> getComments()
  {
    return comments;
  }

  public void setComments(List<Comment> comments)
  {
    this.comments = comments;
  }

  @Override
  public String toString()
  {
    return "Movie [actors=" + actors + ", director=" + director + ", genre=" + genre + ", id=" + id + ", movieLength="
        + movieLength + ", rating=" + rating + ", releaseDate=" + releaseDate + ", title=" + title + ", trailerUrl="
        + trailerUrl + "]";
  }
  
}