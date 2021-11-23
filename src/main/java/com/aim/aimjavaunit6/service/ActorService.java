package com.aim.aimjavaunit6.service;

import java.util.*;

import com.aim.aimjavaunit6.model.Actor;
import com.aim.aimjavaunit6.model.Movie;
import com.aim.aimjavaunit6.repository.ActorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ActorService
{
  
  private final ActorRepository actorRepository;

  @Autowired
  public ActorService(ActorRepository actorRepository)
  {
    this.actorRepository = actorRepository;
  }

  public List<Actor> getActors()
  {
    return actorRepository.findAll();
  }

  public Actor getActor(Long id) 
  {
    return actorRepository.findById(id).orElseThrow(() -> new IllegalStateException("Actor Does not exist."));
  }

  public void addNewActor(Actor actor)
  {
    Optional<Actor> actorOptional = actorRepository.findActorByName(actor.getLastName(), actor.getFirstName());

    if(actorOptional.isPresent())
    {
      throw new IllegalStateException("Actor already exists.");
    }

    actorRepository.save(actor);
  }

  public void deleteActor(Long actorId)
  {
    boolean exists = actorRepository.existsById(actorId);

    if(!exists)
    {
      throw new IllegalStateException("Actor with ID " + actorId + " does not exist.");
    }

    actorRepository.deleteById(actorId);
  }

  @Transactional
  public void updateActor(Long actorId, String lastName, String firstName, List<Movie> moviesActed)
  {
    Actor actor = actorRepository.findById(actorId).orElseThrow(() -> new IllegalStateException("Actor with ID " + actorId + " does not exist."));

    if(lastName != null && lastName.length() > 0 && Objects.equals(actor.getLastName(), lastName))
    {
      actor.setLastName(lastName);
    }
    
    if(firstName != null && firstName.length() > 0 && Objects.equals(actor.getFirstName(), firstName))
    {
      actor.setFirstName(firstName);
    }

    if(moviesActed != null && moviesActed.size() > 0)
    {
      List<Movie> moviesCheck = actor.getMovies();
      Collections.sort(moviesActed);
      Collections.sort(moviesCheck);

      if(moviesActed.equals(moviesCheck))
      {
        actor.setMovies(moviesActed);
      }
    }
  }

}
