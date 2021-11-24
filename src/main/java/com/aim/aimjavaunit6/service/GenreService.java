package com.aim.aimjavaunit6.service;

import java.util.*;

import com.aim.aimjavaunit6.model.Genre;
import com.aim.aimjavaunit6.repository.GenreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class GenreService 
{

  private final GenreRepository genreRepository;

  @Autowired
  public GenreService(GenreRepository genreRepository)
  {
    this.genreRepository = genreRepository;
  }

  public List<Genre> getGenres()
  {
    return genreRepository.findAll();
  }

}
