<template>
  <div>
    <h1>Edit Actor</h1>

    <div class="error" v-if="areErrors">
      <label>ERROR: </label>
      <h4>{{ error }}</h4>
    </div>

    <ActorForm :edit="editData" @save-actor="saveActor" />
  </div>
</template>

<script>
  import ActorForm from "@/components/Forms/ActorForm.vue";
import { fn } from 'moment';

  export default {
    components: {
      ActorForm,
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
      async saveActor(actorData) {
        
        const res = await fetch(`api/actors/${this.id}`, {
          method: "PUT",
          headers: {
            "Content-type": "application/json"
          },
          body: JSON.stringify(actorData.actor)
        });

        this.areErrors = this.handleErrors(res);

        if(!this.areErrors) {
          const actor = await res.json();
          await this.updateAddMovies(actor, actorData.movies);
          await this.updateRemoveMovies(actor.id, actorData.moviesRemoved);

          this.$router.replace({name: "ActorDetails", params: {id: this.id }});  
        }
        else {
          const err = await res.json();
          this.error = err.message;
        }
      },
      async updateAddMovies(actor, movies) {
        
        movies.forEach(async (movie) => {
          if(!movie.actors.some((a) => a.id === actor.id)) {
            const updatedMovie = { ...movie, actors: [...movie.actors, actor]};

            const res = await fetch(`api/movies/${movie.id}`, {
              method: "PUT",
              headers: {
                "Content-type": "application/json"
              },
              body: JSON.stringify(updatedMovie)
            });
          }
        });
      },
      async updateRemoveMovies(id, movies) {
        
        movies.forEach(async (movie) => {
          const updatedMovie = { ...movie, actors: movie.actors.filter((actor) => actor.id !== id)};

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
    }
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