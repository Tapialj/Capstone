package com.aim.aimjavaunit6.repository;

import com.aim.aimjavaunit6.model.Director;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DirectorRepository extends JpaRepository <Director, Long>
{
  
}
