<template>
  <div>
    <h1>Add Actor</h1>

    <div class="error" v-if="areErrors">
      <label>ERROR: </label>
      <h4>{{ error }}</h4>
    </div>

    <ActorForm @save-actor="saveActor" />
  </div>
</template>

<script>
  import ActorForm from "@/components/Forms/ActorForm.vue";

  export default {
    components: {
      ActorForm,
    },
    data() {
      return {
        error: "",
        areErrors: false,
      };
    },
    methods: {
      async saveActor(actorData) {

        const res = await fetch("api/actors", {
          method: "POST",
          headers: {
            "Content-type": "application/json"
          },
          body: JSON.stringify(actorData.actor)
        });

        this.areErrors = this.handleErrors(res)

        if(!this.areErrors) {
          const actor = await res.json();
          await this.updateMovies(actor, actorData.movies);

          this.$router.replace({name: "Actors"});  
        }
        else {
          const err = await res.json();
          this.error = err.message;
        }
      },
      async updateMovies(actor, movies) {

        movies.forEach(async (movie) => {
          const updatedMovie = { ... movie, actors: [... actor] };

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