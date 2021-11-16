<template>
  <div class="flex movies no-align">
    <div class="flex row">
      <h1>Movies</h1>
      <Button title="Add Movie" @btn-click="addMovie()" />
    </div>

    <Table :movies="movies" />
  </div>
</template>

<script>
  import Table from "@/components/Table.vue";
  import Button from "@/components/Button.vue";

  export default {
    components: {
      Table,
      Button,
    },
    data() {
      return {
        movies: [],
      }
    },
    methods: {
      async fetchMovies() {
        const res = await fetch("api/movies");
        const data = await res.json();

        return data;
      },
      addMovie() {
        this.$router.push({name: "AddMovie"});
        //with params use this.$router.push({name: 'name on router index', params: {id: '[paramdata]'}});
      }
    },
    async created() {
      this.movies = await this.fetchMovies();
    }
  }
</script>

<style scoped>

</style>