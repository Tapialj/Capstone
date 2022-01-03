package com.aim.capstone.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import com.fasterxml.jackson.annotation.*;


@Entity
@Table(name = "comments")
public class Comment implements Comparable<Comment>
{

  @Id
  @SequenceGenerator(name = "comment_sequence", sequenceName = "comment_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "comment_sequence")
  @Column(name = "id")
  private Long id;
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "movie_id", referencedColumnName = "id", insertable = false, updatable = false)
  @JsonIgnore
  private Movie movie;
  // @ManyToOne(fetch = FetchType.EAGER)
  // @JoinColumn(name = "director_id", referencedColumnName = "id", insertable = false, updatable = false)
  // private Director director;
  // @ManyToOne(fetch = FetchType.EAGER)
  // @JoinColumn(name = "actor_id", referencedColumnName = "id", insertable = false, updatable = false)
  // private Actor actor;
  // @Column(name = "parent_type")
  // private Long parentType;
  // @Column(name = "parent_id")
  // private Long parentId;
  @Column(name = "movie_id")
  private Long movieId;
  @Column(name = "username")
  private String username;
  @Column(name = "comment", columnDefinition = "TEXT")
  private String comment;
  
  
  public Comment()
  {

  }

  public Comment(String username, String comment)
  {
    this.username = username;
    this.comment = comment;
  }

  public Comment(Long movieId, String username, String comment)
  {
    this.movieId = movieId;
    this.username = username;
    this.comment = comment;
  }

  public Comment(Long id, Long movieId, String username, String comment)
  {
    this.id = id;
    this.movieId = movieId;
    this.username = username;
    this.comment = comment;
  }

  /**
  public Comment(Long parentType, Long parentId, String username, String comment)
  {
    this.parentType = parentType;
    this.parentId = parentId;
    this.username = username;
    this.comment = comment;
  }

  public Comment(Long id, Long parentType, Long parentId, String username, String comment)
  {
    this.id = id;
    this.parentType = parentType;
    this.parentId = parentId;
    this.username = username;
    this.comment = comment;
  }
  */
  @Override
  public int compareTo(Comment c)
  {
    return this.getId().compareTo(c.getId());
  }

  

  public Long getId()
  {
    return id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public Movie getMovie()
  {
    return movie;
  }

  public void setMovie(Movie movie)
  {
    this.movie = movie;
  }
  /*
  public Director getDirector()
  {
    return director;
  }

  public void setDirector(Director director)
  {
    this.director = director;
  }

  public Actor getActor()
  {
    return actor;
  }

  public void setActor(Actor actor)
  {
    this.actor = actor;
  }

  public Long getParentType()
  {
    return parentType;
  }

  public void setParentType(Long parentType)
  {
    this.parentType = parentType;
  }

  public Long getParentId()
  {
    return parentId;
  }

  public void setParentId(Long parentId)
  {
    this.parentId = parentId;
  }
  */

  public Long getMovieId()
  {
    return movieId;
  }

  public void setMovieId(Long movieId)
  {
    this.movieId = movieId;
  }

  public String getUsername()
  {
    return username;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

  public String getComment()
  {
    return comment;
  }

  public void setComment(String comment)
  {
    this.comment = comment;
  }
  /*
  @Override
  public String toString()
  {
    return "Comment [comment=" + comment + ", id=" + id + ", parentId=" + parentId + ", parentType=" + parentType + ", username=" + username + "]";
  }
  */
}
