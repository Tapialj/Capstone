package com.aim.capstone.model;

import java.util.*;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;


@Entity
@Table(name = "actors")
public class Actor implements Comparable<Actor>
{
  
  @Id 
  @SequenceGenerator(name = "actor_sequence", sequenceName = "actor_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "actor_sequence")
  @Column(name = "id")
  private Long id;
  @Column(name = "last_name")
  private String lastName;
  @Column(name = "first_name")
  private String firstName;
  @ManyToMany(mappedBy = "actors")//, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
  @JsonIgnore
  private List<Movie> movies;


  public Actor()
  {

  }

  public Actor(String lastName, String firstName)
  {
    this.lastName = lastName;
    this.firstName = firstName;
  }

  public Actor(Long id, String lastName, String firstName)
  {
    this.id = id;
    this.lastName = lastName;
    this.firstName = firstName;
  }

  @Override
  public int compareTo(Actor a)
  {
    return this.getId().compareTo(a.getId());
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
    return "Actor [firstName=" + firstName + ", id=" + id + ", lastName=" + lastName + ", movies=" + movies + "]";
  }

}
