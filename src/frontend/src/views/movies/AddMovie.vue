<template>
  <div>
    <h1>Add Movie</h1>

    <AddMovieForm @save-movie="saveMovie" />
  </div>
</template>

<script>
  import AddMovieForm from "@/components/AddMovieForm.vue";

  export default {
    components: {
      AddMovieForm,
    },
    methods: {
      async saveMovie(movieData) {
        await fetch("api/movies", {
          method: "POST",
          headers: {
            "Content-type": "application/json"
          },
          body: JSON.stringify(movieData)
        });

        this.$router.replace({name: "Movies"});
      }
    }
  }
</script>

<style scoped>

</style>