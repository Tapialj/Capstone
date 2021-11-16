package com.aim.aimjavaunit6.model;

import javax.persistence.*;


@Entity
@Table(name = "actors")
public class Actor 
{
  
  @Id 
  @SequenceGenerator(name = "actor_sequence", sequenceName = "actor_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "actor_sequence")
  @Column(name = "actor_id")
  private Long id;
  @Column(name = "actor_name")
  private String name;


  public Actor()
  {

  }
 
  public Actor(String name)
  {
    this.name = name;
  }

  public Actor(Long id, String name) 
  {
    this.id = id;
    this.name = name;
  }

  public Long getId() {
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
    return "Actor [id=" + id + ", name=" + name + "]";
  }

}
