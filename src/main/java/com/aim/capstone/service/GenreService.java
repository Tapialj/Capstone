package com.aim.capstone.service;

import java.util.*;

import com.aim.capstone.model.Genre;
import com.aim.capstone.repository.GenreRepository;

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
