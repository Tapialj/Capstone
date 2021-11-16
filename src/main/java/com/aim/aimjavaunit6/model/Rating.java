package com.aim.aimjavaunit6.model;

import javax.persistence.*;

@Entity
@Table(name = "ratings")
public class Rating 
{
  
  @Id 
  @Column(name = "id")
  private Long id;
  @Column(name = "rating")
  private String rating;
  
  
  public Rating()
  {

  }
  
  public Rating(Long id, String rating) 
  {
    this.id = id;
    this.rating = rating;
  }

  public Long getid() 
  {
    return id;
  }

  public void setid(Long id) 
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

  @Override
  public String toString() 
  {
    return "Rating [id=" + id + ", rating=" + rating + "]";
  }
  
}
