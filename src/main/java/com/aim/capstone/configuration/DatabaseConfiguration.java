package com.aim.capstone.configuration;

import java.time.*;
import java.util.*;

import com.aim.capstone.model.*;
import com.aim.capstone.repository.*;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfiguration 
{
  
  @Bean
  CommandLineRunner commandLineRunner(MovieRepository movieRepository, DirectorRepository directorRepository, RatingRepository ratingRepository, GenreRepository genreRepository, ActorRepository actorRepository, CommentRepository commentRepository)
  {
    return args -> {
      Rating g = new Rating(
        1L,
        "G"
      );

      Rating pg = new Rating(
        2L,
        "PG"
      );

      Rating pg13 = new Rating(
        3L,
        "PG-13"
      );

      Rating r = new Rating(
        4L,
        "R"
      );

      ratingRepository.saveAll(List.of(g, pg, pg13, r));


      Genre action = new Genre("Action");
      Genre comedy = new Genre("Comedy");
      Genre drama = new Genre("Drama");
      Genre fantasy = new Genre("Fantasy");
      Genre horror = new Genre("Horror");
      Genre thriller = new Genre("Thriller");
      Genre romance = new Genre("Romance");
      Genre adventure = new Genre("Adventure");
      Genre western = new Genre("Western");
      Genre musical = new Genre("Musical");

      genreRepository.saveAll(List.of(action, comedy, drama, fantasy, horror, thriller, romance, adventure, western, musical));


      Director jamesCameron = new Director(
        "Cameron",
        "James"
      );
      
      Director christopherNolan = new Director(
        "Nolan",
        "Christopher"
      );
      
      Director martinScorsese = new Director(
        "Scorsese",
        "Martin"
      );

      directorRepository.saveAll(List.of(jamesCameron, christopherNolan, martinScorsese));


      Actor leonardoDicaprio = new Actor(
        "DiCaprio",
        "Leonardo"
      );

      Actor samWorthington = new Actor(
        "Worthington",
        "Sam"
      );

      Actor zoeSaldana = new Actor(
        "Saldana",
        "Zoe"
      );

      Actor sigourneyWeaver = new Actor(
        "Weaver",
        "Sigourney"
      );

      Actor christianBale = new Actor(
        "Bale",
        "Christian"
      );

      Actor heathLedger = new Actor(
        "Ledger",
        "Heath"
      );

      Actor aaronEckhart = new Actor(
        "Eckhart",
        "Aaron"
      );

      Actor kenWatanabe = new Actor(
        "Watanabe",
        "Ken"
      );

      Actor elliotPage = new Actor(
        "Page",
        "Elliot"
      );

      Actor markRuffalo = new Actor(
        "Ruffalo",
        "Mark"
      );

      Actor benKingsley = new Actor(
        "Kingsley",
        "Ben"
      );

      // leonardoDicaprio = actorRepository.save(leonardoDicaprio);
      // samWorthington  = actorRepository.save(samWorthington);
      // sigourneyWeaver = actorRepository.save(sigourneyWeaver);
      // christianBale = actorRepository.save(christianBale);
      // heathLedger = actorRepository.save(heathLedger);
      // aaronEckhart = actorRepository.save(aaronEckhart);
      // kenWatanabe = actorRepository.save(kenWatanabe);
      // elliotPage = actorRepository.save(elliotPage);
      // markRuffalo = actorRepository.save(markRuffalo);
      // benKingsley = actorRepository.save(benKingsley);

      actorRepository.saveAll(List.of(leonardoDicaprio, samWorthington, sigourneyWeaver, zoeSaldana, christianBale, heathLedger, aaronEckhart, kenWatanabe, elliotPage, markRuffalo, benKingsley));

      List<Actor> avatarActors = Arrays.asList(samWorthington, sigourneyWeaver, zoeSaldana);
      List<Actor> darkKnightActors = Arrays.asList(christianBale, aaronEckhart, heathLedger);
      List<Actor> inceptionActors = Arrays.asList(leonardoDicaprio, kenWatanabe, elliotPage);
      List<Actor> shutterIslandActors = Arrays.asList(leonardoDicaprio, markRuffalo, benKingsley);
      

      Movie avatar = new Movie(
        "Avatar",
        162,
        LocalDate.of(2009, Month.DECEMBER, 18),
        "https://www.youtube.com/watch?v=5PSNL1qE6VY",
        action,
        pg13,
        jamesCameron,
        avatarActors
      );

      Movie theDarkKnight = new Movie(
        "The Dark Knight",
        152,
        LocalDate.of(2008, Month.JUNE, 18),
        "https://www.youtube.com/watch?v=EXeTwQWrcwY",
        action,
        pg13,
        christopherNolan,
        darkKnightActors
      );

      Movie inception = new Movie(
        "Inception",
        148,
        LocalDate.of(2010, Month.JUNE, 16),
        "https://www.youtube.com/watch?v=YoHD9XEInc0",
        action,
        pg13,
        christopherNolan,
        inceptionActors
      );

      Movie shutterIsland = new Movie(
        "Shutter Island",
        139,
        LocalDate.of(2010, Month.FEBRUARY, 19),
        "https://www.youtube.com/watch?v=v8yrZSkKxTA",
        drama,
        r,
        martinScorsese,
        shutterIslandActors
      );

      movieRepository.saveAll(List.of(avatar, theDarkKnight, inception, shutterIsland));
    };
  }

}
