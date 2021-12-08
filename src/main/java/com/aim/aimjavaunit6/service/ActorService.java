package com.aim.aimjavaunit6.service;

import java.util.*;

import com.aim.aimjavaunit6.model.Actor;
import com.aim.aimjavaunit6.model.response.AlreadyExistsException;
import com.aim.aimjavaunit6.model.response.DoesNotExistException;
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
    return actorRepository.findById(id).orElseThrow(() -> new DoesNotExistException("Actor Does not exist."));
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
