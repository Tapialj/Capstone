<template>
  <main class="home">
    <h1>Welcome to the AIM Movie Database!</h1>

    <article class="random-movies">
      <h2>Movies</h2>
      <section class="grid">
        <div :key="movie.id" class="movie" v-for="movie in randMovies">
          <router-link :to="{name: 'MovieDetails', params: {id: movie.id}}">
            <ListItem>
              {{ movie.title }}
            </ListItem>
          </router-link>
        </div>
      </section>
      <SmallButton title="Random Movie" @btn-click="goToRandom('Movie', movies)" />
    </article>

    <article class="random-actors">
      <h2>Actors</h2>
      <section class="grid">
        <div :key="actor.id" class="actor" v-for="actor in randActors">
          <router-link :to="{name: 'ActorDetails', params: {id: actor.id}}">
            <ListItem>
              {{ actor.firstName }} {{ actor.lastName }}
            </ListItem>
          </router-link>
        </div>
      </section>
      <SmallButton title="Random Actor" @btn-click="goToRandom('Actor', actors)" />
    </article>

    <article class="random-directors">
      <h2>Directors</h2>
      <section class="grid">
        <div :key="director.id" class="director" v-for="director in randDirectors">
          <router-link :to="{name: 'DirectorDetails', params: {id: director.id}}">
            <ListItem>
              {{ director.firstName }} {{ director.lastName }}
            </ListItem>
          </router-link>
        </div>
      </section>
      <SmallButton title="Random Director" @btn-click="goToRandom('Director', directors)" />
    </article>
  </main>
</template>

<script>
  import ListItem from "@/components/ListItem.vue";
  import SmallButton from "@/components/SmallButton.vue";

  export default {
    name: 'Home',
    components: {
      ListItem,
      SmallButton
    },
    data() {
      return {
        movies: [],
        randMovies: [],
        actors: [],
        randActors: [],
        directors: [],
        randDirectors: []
      };
    },
    methods: {
      generateRandomOptions(list) {
        let random;
        //let randomCheck = [];
        let randomList = [];

        do {
          random = list[Math.floor(Math.random() * list.length)];
          console.log("Random obj ", random);
          if(!randomList.includes(random)) {
            randomList.push(random);
            //randomCheck.push(random);
            console.log("Random list ", randomList);
          }
        } while(randomList.length < 4);

        return randomList;
      },
      goToRandom(routeName, list) {
        let id = Math.floor(Math.random() * list.length);
        this.$router.push({name: routeName + "Details", params: {id: id}});
      },
      async getMovies() {
        const res = await fetch("api/movies");
        const data = await res.json();

        return data;
      },
      async getActors() {
        const res = await fetch("api/actors");
        const data = await res.json();

        return data;
      },
      async getDirectors() {
        const res = await fetch("api/directors");
        const data = await res.json();

        return data;
      },
    },
    async created() {
      this.movies = await this.getMovies();
      this.actors = await this.getActors();
      this.directors = await this.getDirectors();

      this.randMovies = this.generateRandomOptions(this.movies);
      this.randActors = this.generateRandomOptions(this.actors);
      this.randDirectors = this.generateRandomOptions(this.directors);
    }
  }
</script>

<style scoped>
  h1 {
    margin: 2rem 0;
    text-align: center;
    font-size: 3rem;
  }

  h2 {
    text-align: left;
    border-bottom: 1px solid #000;
    margin-bottom: 1rem;
  }
</style>
