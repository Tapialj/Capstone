package com.aim.aimjavaunit6.controller;

import java.util.*;

import com.aim.aimjavaunit6.model.Genre;
import com.aim.aimjavaunit6.service.GenreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "api/genres")
public class GenreController 
{
  
  private final GenreService genreService;

  @Autowired
  public GenreController(GenreService genreService)
  {
    this.genreService = genreService;
  }

  @GetMapping
  public List<Genre> getGenres()
  {
    return genreService.getGenres();
  }

}
