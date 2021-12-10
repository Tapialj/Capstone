package com.aim.capstone.service;

import java.util.*;

import com.aim.capstone.model.Actor;
import com.aim.capstone.model.Movie;
import com.aim.capstone.model.response.AlreadyExistsException;
import com.aim.capstone.model.response.DoesNotExistException;
import com.aim.capstone.repository.ActorRepository;

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
    return actorRepository.findById(id).orElseThrow(() -> new DoesNotExistException("Actor Does not exist."));
  }

  public List<Movie> getActorMovies(Long id)
  {
    return actorRepository.findMovieByMovieCast(id);
  }

  public Actor addNewActor(Actor actor)
  {
    Optional<Actor> actorOptional = actorRepository.findActorByName(actor.getLastName(), actor.getFirstName());

    if(actorOptional.isPresent())
    {
      throw new AlreadyExistsException("Actor already exists.");
    }

    actorRepository.save(actor);

    return actor;
  }

  public void deleteActor(Long actorId)
  {
    boolean exists = actorRepository.existsById(actorId);

    if(!exists)
    {
      throw new DoesNotExistException("Actor with ID " + actorId + " does not exist.");
    }

    actorRepository.deleteById(actorId);
  }

  @Transactional
  public Actor updateActor(Actor actor)
  {
    actorRepository.save(actor);

    return actor;
  }

}
