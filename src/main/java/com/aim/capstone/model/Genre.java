package com.aim.capstone.model;

import java.util.*;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;


@Entity
@Table(name = "genres")
public class Genre 
{
  
  @Id
  @SequenceGenerator(name = "genre_sequence", sequenceName = "genre_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "genre_sequence")
  @Column(name = "id")
  private Long id;
  @Column(name = "genre")
  private String genre;
  @OneToMany(mappedBy = "genre")//, fetch = FetchType.LAZY)
  @JsonIgnore
  private List<Movie> movies;
  
  
  public Genre()
  {
  
  }

  public Genre(String genre)
  {
    this.genre = genre;
  }

  public Genre(Long id, String genre)
  {
    this.id = id;
    this.genre = genre;
  }

  public Long getId()
  {
    return id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public String getGenre()
  {
    return genre;
  }

  public void setGenre(String genre)
  {
    this.genre = genre;
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
    return "Genre [genre=" + genre + ", id=" + id + ", movies=" + movies + "]";
  }

}
