<template>
  <div>
    <h1>Add Movie</h1>

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
    data() {
      return {
        editData: {
          edit: false,
        },
        error: "",
        areErrors: false,
      };
    },
    methods: {
      async saveMovie(movieData) {
        const res = await fetch("api/movies", {
          method: "POST",
          headers: {
            "Content-type": "application/json"
          },
          body: JSON.stringify(movieData)
        });

        this.areErrors = this.handleErrors(res);

        if(!this.areErrors) {
          this.$router.replace({name: "Movies"}); 
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
    },
  }
</script>

<style scoped>

</style>