<template>
  <div>    
    <table>
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">Title</th>
          <th scope="col">Length</th>
          <th scope="col"></th>
        </tr>
      </thead>

      <tbody>
        <tr :key="movie.id" v-for="(movie, index) in movies">
          <Movie :movie="movie" :listNumber="++index" @onDelete="onDelete" />
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
  import Movie from "@/components/movie/Movie.vue";

  export default {
    name: "MovieTable",
    components: {
      Movie,
    },
    props: {
      movies: Array,
    },
    methods: {
      onDelete(movie) {
        this.$emit("onDelete", movie);
      },
    },
    emits: [
      "onDelete"
    ]
  }
</script>

<style scoped>

</style>