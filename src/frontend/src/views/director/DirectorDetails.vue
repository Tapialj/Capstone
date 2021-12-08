<template>
  <div class="director-details">
    <div class="route">
      <h3>
        <router-link to="/directors">
          <span>Directors</span>
        </router-link>
        &emsp;/&emsp;{{ director.lastName }}, {{ director.firstName }}
      </h3>
    </div>

    <div class="flex row">
      <h1>{{ director.firstName }} {{ director.lastName }}</h1>
      <Button title="Edit" @btn-click="editDirector(this.id)" />
    </div>

    <div class="movies-section">
      <h2>Directed:</h2>

      <div class="movies grid">
        <div :key="movie.id" class="movie" v-for="movie in movies">
          <router-link :to="{name: 'MovieDetails', params: {id: movie.id}}">
            <ListItem>
              {{ movie.title }}
            </ListItem>
          </router-link>
        </div>
      </div>
    </div>

  </div>
</template>

<script>
  import Button from "@/components/Button.vue";
  import ListItem from "@/components/ListItem.vue";
  
  export default {
    components: {
      Button,
      ListItem,
    },
    props: [
      "id"
    ],
    data() {
      return {
        director: {},
        movies: [],
      }
    },
    methods: {
      editDirector(id) {
        this.$router.push({name: "EditDirector", params: {id: id}});
      },
      async fetchDirector(id) {
        const res = await fetch(`api/directors/${id}`);
        const data = await res.json();

        return data;
      },
      async fetchMovies(id) {
        const res = await fetch(`api/directors/${id}/movies`);
        const data = await res.json();

        return data;
      }
    },
    async created() {
      this.director = await this.fetchDirector(this.id);
      this.movies = await this.fetchMovies(this.id);
    }
  }
</script>

<style scoped>
  .movies-section {
    text-align: left;
  }

  .movies-section > h2 {
    border-bottom: 2px solid #000;
  }

  .movies.grid {
    grid-template-rows: repeat(6, 1fr);
    grid-template-columns: auto;
    gap: 0.75rem;
    grid-auto-flow: column;
    justify-content: flex-start;
  }
</style>