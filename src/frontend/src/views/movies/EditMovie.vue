<template>
  <div>
    <h1>Edit Movie</h1>

    <div class="error" v-if="areErrors">
      <label>ERROR: </label>
      <h4>{{ error }}</h4>
    </div>

    <MovieForm :edit="editData" @save-movie="saveMovie" />
  </div>
</template>

<script>
  import MovieForm from "@/components/Forms/MovieForm.vue";

  export default {
    components: {
      MovieForm,
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
        error: "",
        areErrors: false,
      };
    },
    methods: {
      async saveMovie(movieData) {
        const res = await fetch(`api/movies/${this.id}`, {
          method: "PUT",
          headers: {
            "Content-type": "application/json"
          },
          body: JSON.stringify(movieData)
        });

        this.areErrors = this.handleErrors(res);

        if(!this.areErrors) {
          this.$router.replace({name: "MovieDetails", params: {id: this.id }});
        }
        else {
          const err = await res.json();
          this.error = err.message;
        }
      },
      handleErrors(response) {
        if(response.ok) {
          return false;
        }
        else {
          return true;
        }
      }
    }
  }
</script>

<style scoped>

</style>