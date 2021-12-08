package com.aim.aimjavaunit6.controller;

import java.util.*;

import com.aim.aimjavaunit6.model.Actor;
import com.aim.aimjavaunit6.service.ActorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "api/actors")
public class ActorController 
{
  
  private final ActorService actorService;

  @Autowired
  public ActorController(ActorService actorService)
  {
    this.actorService = actorService;
  }

  @GetMapping
  public List<Actor> getActors()
  {
    return actorService.getActors();
  }

  @GetMapping(path = "{actorId}")
  public Actor getActor(@PathVariable("actorId") Long actorId)
  {
    return actorService.getActor(actorId);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Actor createActor(@RequestBody Actor actor)
  {
    return actorService.addNewActor(actor);
  }

  @DeleteMapping(path = "{actorId}")
  public void deleteActor(@PathVariable("actorId") Long actorId)
  {
    actorService.deleteActor(actorId);
  }

  @PutMapping(path = "{actorId}")
  public Actor updateActor(@RequestBody Actor actor)
  {
    return actorService.updateActor(actor);
  }

}
