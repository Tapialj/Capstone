<template>
  <div>
    <h1>Add Movie</h1>

    <MovieForm :edit="editData" @save-movie="saveMovie" />
  </div>
</template>

<script>
  import MovieForm from "@/components/Forms/MovieForm.vue";

  export default {
    components: {
      MovieForm,
    },
    data() {
      return {
        editData: {
          edit: false,
        },
      };
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