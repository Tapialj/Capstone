package com.aim.aimjavaunit6.repository;

import java.util.*;

import com.aim.aimjavaunit6.model.Actor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ActorRepository extends JpaRepository <Actor, Long>
{
  
  @Query("SELECT a FROM Actor a WHERE UPPER(a.lastName) = UPPER(?1) AND UPPER(a.firstName) = UPPER(?2)")
  Optional<Actor> findActorByName(String lastName, String firstName);

}
