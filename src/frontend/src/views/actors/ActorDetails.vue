<template>
  <div class="actor-details">
    <div class="route">
      <h3>
        <router-link to="/actors">
          <span>Actors</span>
        </router-link>
        &emsp;/&emsp;{{ actor.lastName }}, {{ actor.firstName }}
      </h3>
    </div>

    <div class="flex row">
      <h1>{{ actor.firstName }} {{ actor.lastName }}</h1>
      <Button title="Edit" @btn-click="editActor(this.id)" />
    </div>

    <div class="movies-section">
      <h2>Acted:</h2>

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
        actor: {},
        movies: [],
      }
    },
    methods: {
      editActor(id) {
        this.$router.push({name: "EditActor", params: {id: id}});
      },
      async fetchActor(id) {
        const res = await fetch(`api/actors/${id}`);
        const data = await res.json();

        return data;
      },
      async fetchMovies(id) {
        const res = await fetch(`api/actors/${id}/movies`);
        const data = await res.json();

        return data;
      }
    },
    async created() {
      this.director = await this.fetchActor(this.id);
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