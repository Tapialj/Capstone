package com.aim.aimjavaunit6.controller;

import java.util.*;

import com.aim.aimjavaunit6.model.Director;
import com.aim.aimjavaunit6.model.Movie;
import com.aim.aimjavaunit6.service.DirectorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "api/directors")
public class DirectorController 
{
  
  private final DirectorService directorService;

  @Autowired
  public DirectorController(DirectorService directorService)
  {
    this.directorService = directorService;
  }

  @GetMapping
  public List<Director> getDirectors()
  {
    return directorService.getDirectors();
  }

  @GetMapping(path = "{directorId}")
  public Director getDirector(@PathVariable("directorId") Long directorId)
  {
    return directorService.getDirector(directorId);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void createDirector(@RequestBody Director director)
  {
    directorService.addNewDirector(director);
  }

  @DeleteMapping(path = "{directorId}")
  public void deleteDirector(@PathVariable("directorId") Long directorId)
  {
    directorService.deleteDirector(directorId);
  }

  @PutMapping(path = "{directorId}")
  public void updateDirector(@PathVariable("directorId") Long directorId, @RequestParam(required = false) String lastName, @RequestParam(required = false) String firstName, @RequestParam(required = false) List<Movie> moviesDirected)
  {
    directorService.updateDirector(directorId, lastName, firstName, moviesDirected);
  }

}
