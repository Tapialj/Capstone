<template>
  <div>
    <h1>Edit Movie</h1>

    <AddMovieForm :edit="editData" @save-movie="saveMovie" />
  </div>
</template>

<script>
  import AddMovieForm from "@/components/AddMovieForm.vue";

  export default {
    components: {
      AddMovieForm,
    },
    props: [
      "id"
    ],
    data() {
      return {
        editData: {
          edit: true,
          id: this.id
        },
      };
    },
    methods: {
      async saveMovie(movieData) {
        await fetch(`api/movies/${this.id}`, {
          method: "PUT",
          headers: {
            "Content-type": "application/json"
          },
          body: JSON.stringify(movieData)
        });

        this.$router.replace({name: "Movie", params: {id: this.id }});
      }
    }
  }
</script>

<style scoped>

</style>