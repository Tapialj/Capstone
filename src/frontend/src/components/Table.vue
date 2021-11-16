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
        <tr :key="movie.id" v-for="movie in movies">
          <Movie :movie="movie" />
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
  import Movie from "@/components/Movie.vue";

  export default {
    name: "Table",
    props: {
      movies: Array,
    },
    components: {
      Movie,
    },
  }
</script>

<style scoped>

</style>