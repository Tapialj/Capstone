<template>
  <div>
    <h1>Add Director</h1>

    <div class="error" v-if="areErrors">
      <label>ERROR: </label>
      <h4>{{ error }}</h4>
    </div>

    <DirectorForm @save-director="saveDirector" />
  </div>
</template>

<script>
  import DirectorForm from "@/components/Forms/DirectorForm.vue";

  export default {
    components: {
      DirectorForm,
    },
    data() {
      return {
        error: "",
        areErrors: false,
      };
    },
    methods: {
      async saveDirector(directorData) {

        const res = await fetch("api/directors", {
          method: "POST",
          headers: {
            "Content-type": "application/json"
          },
          body: JSON.stringify(directorData.director)
        });

        this.areErrors = this.handleErrors(res)

        if(!this.areErrors) {
          const director = await res.json();
          await this.updateMovies(director, directorData.movies);

          this.$router.replace({name: "Directors"});  
        }
        else {
          const err = await res.json();
          this.error = err.message;
        }
      },
      async updateMovies(director, movies) {

        movies.forEach(async (movie) => {
          const updatedMovie = { ... movie, director: director };

          const res = await fetch(`api/movies/${movie.id}`, {
            method: "PUT",
            headers: {
              "Content-type": "application/json"
            },
            body: JSON.stringify(updatedMovie)
          });
        });
      },
      handleErrors(response) {
        if(response.ok) {
          return false;
        }
        else {
          return true;
        }
      }
    },
  }
</script>

<style scoped>
  ul {
    list-style: none;
  }

  .error {
    font-weight: bold;
  }
</style>