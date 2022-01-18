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

      Director parkChanwook = new Director(
        "Chan-Wook",
        "Park"
      );

      Director dannyBoyle = new Director(
        "Boyle",
        "Danny"
      );
      
      Director tomShadyac = new Director(
        "Shadyac",
        "Tom"
      );

      Director jonathanDemme = new Director(
        "Demme",
        "Jonathan"
      );

      directorRepository.saveAll(List.of(jamesCameron, christopherNolan, martinScorsese, parkChanwook, dannyBoyle, tomShadyac, jonathanDemme));


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

      Actor michelleRodriguez = new Actor(
        "Rodriguez",
        "Michelle"
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

      Actor michaelCaine = new Actor(
        "Caine",
        "Michael"
      );

      Actor kenWatanabe = new Actor(
        "Watanabe",
        "Ken"
      );

      Actor elliotPage = new Actor(
        "Page",
        "Elliot"
      );

      Actor josephGordonLevitt = new Actor(
        "Gordon-Levitt",
        "Joseph"
      );

      Actor markRuffalo = new Actor(
        "Ruffalo",
        "Mark"
      );

      Actor benKingsley = new Actor(
        "Kingsley",
        "Ben"
      );

      Actor emilyMortimer = new Actor(
        "Mortimer",
        "Emily"
      );

      Actor choiMinsik = new Actor( 
        "Min-sik",
        "Choi"
      );

      Actor yooJitae = new Actor( 
        "Ji-Tae",
        "Yoo"
      );

      Actor kangHyejeong = new Actor( 
        "Hye-jeong",
        "Kang"
      );

      Actor kimByeongok = new Actor(
        "Byeong-Ok",
        "Kim"
      );

      Actor mattDamon = new Actor( 
        "Damon",
        "Matt"
      );

      Actor jackNicholson = new Actor( 
        "Nicholson",
        "Jack"
      );

      Actor markWahlberg = new Actor(
        "Wahlberg",
        "Mark"
      );

      Actor cillianMurphy = new Actor( 
        "Murphy",
        "Cillian"
      );

      Actor roseByrne = new Actor( 
        "Byrne",
        "Rose"
      );

      Actor chrisEvans = new Actor( 
        "Evans",
        "Chris"
      );

      Actor cliffCurtis = new Actor(
        "Curtis",
        "Cliff"
      );

      Actor jimCarrey = new Actor( 
        "Carrey",
        "Jim"
      );

      Actor courtneyCox = new Actor( 
        "Cox",
        "Courtney"
      );

      Actor seanYoung = new Actor( 
        "Young",
        "Sean"
      );

      Actor toneLoc = new Actor( 
        "Loc",
        "Tone"
      );

      Actor mauraTierney = new Actor( 
        "Tierney",
        "Maura"
      );

      Actor amandaDonohoe = new Actor( 
        "Donohoe",
        "Amanda"
      );

      Actor jenniferTilly = new Actor( 
        "Tilly",
        "Jennifer"
      );

      Actor jodieFoster = new Actor( 
        "Foster",
        "Jodie"
      );

      Actor anthonyHopkins = new Actor( 
        "Hopkins",
        "Anthony"
      );

      Actor kasiLemmons = new Actor( 
        "Lemmons",
        "Kasi"
      );

      Actor scottGlenn = new Actor( 
        "Glenn",
        "Scott"
      );

      actorRepository.saveAll(List.of(leonardoDicaprio, samWorthington, sigourneyWeaver, zoeSaldana, michelleRodriguez, christianBale, heathLedger, aaronEckhart, michaelCaine, kenWatanabe, elliotPage, markRuffalo, benKingsley, josephGordonLevitt, cillianMurphy, emilyMortimer, choiMinsik, yooJitae, kangHyejeong, kimByeongok, mattDamon, jackNicholson, markWahlberg, roseByrne, chrisEvans, cliffCurtis, jimCarrey, courtneyCox, seanYoung, toneLoc, mauraTierney, amandaDonohoe, jenniferTilly, jodieFoster, anthonyHopkins, kasiLemmons, scottGlenn));

      List<Actor> avatarActors = Arrays.asList(samWorthington, sigourneyWeaver, zoeSaldana, michelleRodriguez);
      List<Actor> darkKnightActors = Arrays.asList(christianBale, aaronEckhart, heathLedger, michaelCaine);
      List<Actor> inceptionActors = Arrays.asList(leonardoDicaprio, kenWatanabe, elliotPage, josephGordonLevitt, cillianMurphy);
      List<Actor> shutterIslandActors = Arrays.asList(leonardoDicaprio, markRuffalo, benKingsley, emilyMortimer);
      List<Actor> oldboyActors = Arrays.asList(choiMinsik, yooJitae, kangHyejeong, kimByeongok);
      List<Actor> departedActors = Arrays.asList(leonardoDicaprio, mattDamon, jackNicholson, markWahlberg);
      List<Actor> sunshineActors = Arrays.asList(cillianMurphy, roseByrne, chrisEvans, cliffCurtis);
      List<Actor> aceVenturaActors = Arrays.asList(jimCarrey, courtneyCox, seanYoung, toneLoc);
      List<Actor> liarLiarActors = Arrays.asList(jimCarrey, mauraTierney, amandaDonohoe, jenniferTilly);
      List<Actor> silenceOfTheLambsActors = Arrays.asList(jodieFoster, anthonyHopkins, kasiLemmons, scottGlenn);
      

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
        thriller,
        r,
        martinScorsese,
        shutterIslandActors
      );

      Movie oldBoy = new Movie(
        "Oldboy",
        120,
        LocalDate.of(2003, Month.NOVEMBER, 21),
        "https://www.youtube.com/watch?v=2HkjrJ6IK5E",
        drama,
        r,
        parkChanwook,
        oldboyActors
      );

      Movie departed = new Movie(
        "The Departed",
        151,
        LocalDate.of(2006, Month.SEPTEMBER, 6),
        "https://www.youtube.com/watch?v=n4O3x5BH18E",
        drama,
        r,
        martinScorsese,
        departedActors
      );

      Movie sunshine = new Movie(
        "Sunshine",
        107,
        LocalDate.of(2007, Month.JULY, 20),
        "https://www.youtube.com/watch?v=r8BSlqHAhuY",
        drama,
        r,
        dannyBoyle,
        sunshineActors
      );

      Movie aceVentura = new Movie(
        "Ace Ventura: Pet Detective",
        86,
        LocalDate.of(1994, Month.FEBRUARY, 4),
        "https://www.youtube.com/watch?v=cXcH0f2B2vA",
        comedy,
        pg13,
        tomShadyac,
        aceVenturaActors
      );

      Movie liarLiar = new Movie(
        "Liar Liar",
        86,
        LocalDate.of(1997, Month.MARCH, 21),
        "https://www.youtube.com/watch?v=C1no75lpOiw",
        comedy,
        pg13,
        tomShadyac,
        liarLiarActors
      );

      Movie silenceOfTheLambs = new Movie(
        "Silence of the Lambs",
        118,
        LocalDate.of(1991, Month.FEBRUARY, 14),
        "https://www.youtube.com/watch?v=W6Mm8Sbe__o",
        thriller,
        r,
        jonathanDemme,
        silenceOfTheLambsActors
      );

      movieRepository.saveAll(List.of(avatar, theDarkKnight, inception, shutterIsland, oldBoy, departed, sunshine, aceVentura, liarLiar, silenceOfTheLambs));
    };
  }

}
