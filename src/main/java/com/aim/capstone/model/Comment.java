package com.aim.capstone.model;

import javax.persistence.*;

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
  private Movie movie;
  @Column(name = "movie_id")
  private Long movieId;
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

  public Long getMovie()
  {
    return movieId;
  }

  public void setMovie(Long movieId)
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

  @Override
  public String toString()
  {
    return "Comment [comment=" + comment + ", id=" + id + ", movie=" + movieId + ", username=" + username + "]";
  }  

}
