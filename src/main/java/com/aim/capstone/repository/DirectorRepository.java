package com.aim.capstone.repository;

import java.util.*;

import com.aim.capstone.model.Director;
import com.aim.capstone.model.Movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface DirectorRepository extends JpaRepository <Director, Long>
{
  
  @Query("SELECT d FROM Director d WHERE UPPER(d.lastName) = UPPER(?1) AND UPPER(d.firstName) = UPPER(?2)")
  Optional<Director> findDirectorByName(String lastName, String firstName);

  @Query("SELECT m FROM Movie m JOIN m.director d WHERE d.id = ?1")
  List<Movie> findMovieByDirectorId(Long id);

}
