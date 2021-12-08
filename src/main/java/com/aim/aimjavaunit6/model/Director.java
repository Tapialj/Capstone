package com.aim.aimjavaunit6.model;

import java.util.*;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;


@Entity
@Table(name = "directors")
public class Director 
{
  
  @Id 
  @SequenceGenerator(name = "director_sequence", sequenceName = "director_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "director_sequence")
  @Column(name = "id")
  private Long id;
  @Column(name = "last_name")
  private String lastName;
  @Column(name = "first_name")
  private String firstName;
  @OneToMany(mappedBy = "director")//, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JsonIgnore
  private List<Movie> movies;
  
  
  public Director() 
  {
  
  }

  public Director(String lastName, String firstName)
  {
    this.lastName = lastName;
    this.firstName = firstName;
  }

  public Director(Long id, String lastName, String firstName)
  {
    this.id = id;
    this.lastName = lastName;
    this.firstName = firstName;
  }
  
  public Long getId()
  {
    return id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public String getLastName()
  {
    return lastName;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
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
    return "Director [firstName=" + firstName + ", id=" + id + ", lastName=" + lastName + ", movies=" + movies + "]";
  }

}
