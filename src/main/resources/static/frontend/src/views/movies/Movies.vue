<template>
  <div class="flex movies no-align">
    <div class="flex row">
      <h1>Movies</h1>
      <Button title="Add Movie" @btn-click="addMovie" />
    </div>

    <MovieTable :movies="movies" @onDelete="onDelete" />

    <Modal v-if="deleteModalOpen" @onModal="onDeleteModal">
      <p>
        Are you sure you want to delete {{ movieDelete.title }}?
      </p>

      <Button title="Delete" @btn-click="deleteMovie(movieDelete.id)" />
    </Modal>
  </div>
</template>

<script>
  import MovieTable from "@/components/movie/MovieTable.vue";
  import Button from "@/components/Button.vue";
  import Modal from "@/components/Modal/Modal.vue";

  export default {
    components: {
      MovieTable,
      Button,
      Modal,
    },
    data() {
      return {
        movies: [],
        deleteModalOpen: false,
        movieDelete: {},
      }
    },
    methods: {
      onDelete(movie) {
        this.movieDelete = movie;
        this.deleteModalOpen = !this.deleteModalOpen;
      },
      onDeleteModal() {
        this.deleteModalOpen = !this.deleteModalOpen;
      },
      async deleteMovie(id) {
        await fetch(`api/movies/${id}`, {
          method: "DELETE",
          headers: {
            "Content-type": "application/json"
          },
        });

        this.movies = this.movies.filter((movie) => movie.id !== id);

        this.movieDelete = null;
        this.deleteModalOpen = !this.deleteModalOpen;
      },
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