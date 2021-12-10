package com.aim.capstone.controller;

import java.util.*;

import com.aim.capstone.model.Genre;
import com.aim.capstone.service.GenreService;

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
