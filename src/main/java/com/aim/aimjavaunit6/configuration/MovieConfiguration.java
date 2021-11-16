package com.aim.aimjavaunit6.configuration;

import java.time.*;
import java.util.List;

import com.aim.aimjavaunit6.model.Movie;
import com.aim.aimjavaunit6.repository.MovieRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MovieConfiguration 
{
  
  @Bean
  CommandLineRunner commandLineRunner(MovieRepository repository)
  {
    return args -> {
      Movie avatar = new Movie(
        1L,
        "Avatar",
        "Action",
        162,
        LocalDate.of(2009, Month.DECEMBER, 18),
        "https://www.youtube.com/watch?v=5PSNL1qE6VY",
        3L,
        1L
      );

      Movie theDarkKnight = new Movie(
        2L,
        "The Dark Knight",
        "Action",
        152,
        LocalDate.of(2008, Month.JUNE, 18),
        "https://www.youtube.com/watch?v=EXeTwQWrcwY",
        3L,
        2L
      );

      Movie inception = new Movie(
        3L,
        "Inception",
        "Action",
        148,
        LocalDate.of(2010, Month.JUNE, 16),
        "https://www.youtube.com/watch?v=YoHD9XEInc0",
        3L,
        2L
      );

      Movie shutterIsland = new Movie(
        4L,
        "Shutter Island",
        "Drama",
        139,
        LocalDate.of(2010, Month.FEBRUARY, 19),
        "https://www.youtube.com/watch?v=v8yrZSkKxTA",
        4L,
        3L
      );

      repository.saveAll(List.of(avatar, theDarkKnight, inception, shutterIsland));
    };
  }

}
