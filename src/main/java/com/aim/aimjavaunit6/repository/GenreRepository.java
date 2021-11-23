package com.aim.aimjavaunit6.repository;

import com.aim.aimjavaunit6.model.Genre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GenreRepository extends JpaRepository <Genre, Long>
{
  
}
