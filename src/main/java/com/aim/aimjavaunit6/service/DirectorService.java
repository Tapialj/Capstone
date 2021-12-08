package com.aim.aimjavaunit6.service;

import java.util.*;

import com.aim.aimjavaunit6.model.Director;
import com.aim.aimjavaunit6.model.Movie;
import com.aim.aimjavaunit6.model.response.AlreadyExistsException;
import com.aim.aimjavaunit6.model.response.DoesNotExistException;
import com.aim.aimjavaunit6.repository.DirectorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class DirectorService 
{
  
  private final DirectorRepository directorRepository;

  @Autowired
  public DirectorService(DirectorRepository directorRepository)
  {
    this.directorRepository = directorRepository;
  }

  public List<Director> getDirectors()
  {
    return directorRepository.findAll();
  }

  public Director getDirector(Long id) 
  {
    return directorRepository.findById(id).orElseThrow(() -> new DoesNotExistException("Director Does not exist."));
  }

  public List<Movie> getDirectorMovies(Long id)
  {
    return directorRepository.findMovieByDirectorId(id);
  }

  public Director addNewDirector(Director director)
  {
    Optional<Director> directorOptional = directorRepository.findDirectorByName(director.getLastName(), director.getFirstName());

    if(directorOptional.isPresent())
    {
      throw new AlreadyExistsException("Director already exists.");
    }

    directorRepository.save(director);

    return director;
  }

  public void deleteDirector(Long directorId)
  {
    boolean exists = directorRepository.existsById(directorId);

    if(!exists)
    {
      throw new DoesNotExistException("Director with ID " + directorId + " does not exist.");
    }

    directorRepository.deleteById(directorId);
  }

  @Transactional
  public void updateDirector(Long directorId, String lastName, String firstName)//, List<Movie> moviesDirected)
  {
    Director director = directorRepository.findById(directorId).orElseThrow(() -> new DoesNotExistException("Director with ID " + directorId + " does not exist."));

    if(lastName != null && lastName.length() > 0 && Objects.equals(director.getLastName(), lastName))
    {
      director.setLastName(lastName);
    }
    
    if(firstName != null && firstName.length() > 0 && Objects.equals(director.getFirstName(), firstName))
    {
      director.setFirstName(firstName);
    }

    // if(moviesDirected != null && moviesDirected.size() > 0)
    // {
    //   List<Movie> moviesCheck = director.getMovies();
    //   Collections.sort(moviesDirected);
    //   Collections.sort(moviesCheck);

    //   if(moviesDirected.equals(moviesCheck))
    //   {
    //     director.setMovies(moviesDirected);
    //   }
    // }
  }

}
