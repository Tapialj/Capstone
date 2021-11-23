package com.aim.aimjavaunit6.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;


@Entity
@Table(name = "comments")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Comment implements Comparable<Comment>
{

  @Id
  @SequenceGenerator(name = "comment_sequence", sequenceName = "comment_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "comment_sequence")
  @Column(name = "id")
  private Long id;
  @ManyToOne
  @JoinColumn(name = "movie_id", referencedColumnName = "id", nullable = false)
  @JsonIgnore
  private Movie movie;
  @Column(name = "username")
  private String username;
  @Column(name = "comment")
  private String comment;
  
  
  public Comment()
  {

  }

  public Comment(String username, String comment)
  {
    this.username = username;
    this.comment = comment;
  }

  public Comment(Movie movie, String username, String comment)
  {
    this.movie = movie;
    this.username = username;
    this.comment = comment;
  }

  public Comment(Long id, String username, String comment)
  {
    this.id = id;
    this.username = username;
    this.comment = comment;
  }

  public Comment(Long id, Movie movie, String username, String comment)
  {
    this.id = id;
    this.movie = movie;
    this.username = username;
    this.comment = comment;
  }

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

  @Override
  public String toString()
  {
    return "Comment [comment=" + comment + ", id=" + id + ", movie=" + movie + ", username=" + username + "]";
  }  

}
