package com.aim.aimjavaunit6.model;

import javax.persistence.*;

@Entity
@Table(name = "movie_cast")
public class MovieCast 
{

  @Id 
  @SequenceGenerator(name = "cast_sequence", sequenceName = "cast_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "cast_sequence")
  @Column(name = "cast_id")
  private Long id;
  @Column(name = "actor_id")
  private Long actorId;
  @Column(name = "movie_id")
  private Long movieId;
  
  
  public MovieCast()
  {

  }

  public MovieCast(Long actorId, Long movieId)
  {
    this.actorId = actorId;
    this.movieId = movieId;
  }
  
  public MovieCast(Long id, Long actorId, Long movieId) 
  {
    this.id = id;
    this.actorId = actorId;
    this.movieId = movieId;
  }

  public Long getid() 
  {
    return id;
  }

  public void setid(Long id) 
  {
  
    this.id = id;
  }

  public Long getActorId() 
  {
    return actorId;
  }

  public void setActorId(Long actorId) 
  {
    this.actorId = actorId;
  }

  public Long getMovieId() 
  {
    return movieId;
  }

  public void setMovieId(Long movieId) 
  {
    this.movieId = movieId;
  }

  @Override
  public String toString() 
  {
    return "MovieCast [actorId=" + actorId + ", id=" + id + ", movieId=" + movieId + "]";
  }
  
}
