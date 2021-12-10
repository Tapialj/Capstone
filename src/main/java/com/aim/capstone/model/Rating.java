package com.aim.capstone.model;

import java.util.*;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;


@Entity
@Table(name = "ratings")
public class Rating 
{
  
  @Id 
  @Column(name = "id")
  private Long id;
  @Column(name = "rating")
  private String rating;
  @OneToMany(mappedBy = "rating")//, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JsonIgnore
  private List<Movie> movies;
  
  
  public Rating()
  {

  }

  public Rating(String rating)
  {
    this.rating = rating;
  }

  public Rating(Long id, String rating)
  {
    this.id = id;
    this.rating = rating;
  }

  public Long getId()
  {
    return id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public String getRating()
  {
    return rating;
  }

  public void setRating(String rating)
  {
    this.rating = rating;
  }

  public List<Movie> getMovies()
  {
    return movies;
  }

  public void setMovies(List<Movie> movies)
  {
    this.movies = movies;
  }

  @Override
  public String toString()
  {
    return "Rating [id=" + id + ", movies=" + movies + ", rating=" + rating + "]";
  }
  
}
