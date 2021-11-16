package com.aim.aimjavaunit6.model;

import javax.persistence.*;


@Entity
@Table(name = "directors")
public class Director 
{
  
  @Id 
  @SequenceGenerator(name = "director_sequence", sequenceName = "director_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "director_sequence")
  @Column(name = "director_id")
  private Long id;
  @Column(name = "director_name")
  private String name;
  
  
  public Director() 
  {
  
  }


  public Director(String name) 
  {
    this.name = name;
  }


  public Director(Long id, String name) 
  {
    this.id = id;
    this.name = name;
  }

  public Long getId() 
  {
    return id;
  }


  public void setId(Long id) 
  {
    this.id = id;
  }


  public String getName() 
  {
    return name;
  }


  public void setName(String name) 
  {
    this.name = name;
  }

  @Override
  public String toString() 
  {
    return "Director [id=" + id + ", name=" + name + "]";
  }

}
