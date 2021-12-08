<template>
  <h1 v-if="isModal">Add Director</h1>

  <form class="form" @submit.prevent="checkForm" novalidate>
      <div class="error" v-if="errors.length">
        <label>Please correct the following error(s):</label>

        <ul>
          <li :key="error" v-for="error in errors">
            {{ error }}
          </li>
        </ul>
      </div>

      <div class="form-control">
        <label for="firstName">First Name</label>
        <input type="text" id="firstName" name="firstName" v-model="director.firstName" />
      </div>

      <div class="form-control">
        <label for="lastName">Last Name</label>
        <input type="text" id="lastName" name="lastName" v-model="director.lastName" />
      </div>

      <div v-if="!isModal">
      <div class="form-control flex">
        <label for="movie">Movies</label>
        <div class="grid check-container">
          <div :key="movie.id" class="checkbox" v-for="movie in movies">
            <input :key="movie.id" type="checkbox" name="movie" :id="[movie.lastName, movie.firstName]" :checked="directedBy(movie.director.id)" :value="movie.id" v-model="selectedMovies" @change="selectMovies" />
            <label :for="movie.id">{{ movie.title }}</label>
          </div>
        </div>
      </div>
      </div>

      <Button title="Save Director" />
    </form>
</template>

<script>
  import Button from "@/components/Button.vue";

  export default {
    name: "DirectorForm",
    components: {
      Button,
    },
    props: {
      edit: {
        default: function() {
          return { 
            edit: false 
          };
        },
        type: Object,
      },
      isModal: {
        default: false,
      }
    },
    data() {
      return {
        errors: [],
        movies: [],
        director: {
          lastName: "",
          firstName: "",
        },
        selectedMovies: [],
        selectedMovieObjects: [],
      };
    },
    methods: {
      checkForm() {
        this.errors = [];

        if(!this.director.firstName || this.director.firstName === "") {
          this.errors.push("First Name is Required")
        }
        
        if(!this.director.lastName || this.director.lastName === "") {
          this.errors.push("Last Name is Required")
        }

        if(!this.errors.length) {
          this.submitDirector();
        }
      },
      directedBy(id) {
        if(id === this.director.id) {
          return true;
        }

        return false;
      },
      submitDirector() {
        this.$emit("save-director", { director: this.director, movies: this.selectedMovieObjects });
      },
      selectMovies() {
        this.selectedMovieObjects = [];

        this.selectedMovieObjects = this.movies.filter((movie) => !this.selectedMovies.indexOf(movie.id));
      },
      async getMovies() {
        const res = await fetch("api/movies");
        const data = await res.json();

        return data;
      },
      async getDirectorDetails(id) {
        const res = await fetch(`api/directors/${id}`);
        const data = await res.json();

        return data;
      }
    },
    emits: [
      "save-director"
    ],
    async created() {
      this.movies = await this.getMovies();

      if(this.edit.edit === true) {
        this.director = await this.getDirectorDetails(this.editData.id);
      }
    }
  }
</script>

<style scoped>
  form {
    font-size: 1.2rem;
    padding: 0 2rem;
  }

  .form-control {
    display: flex;
    justify-content: space-between;
    margin: 1.4rem 0;

  }

  .form-control label {
    text-align: left;
    align-self: center;
    flex: 1;
  }

  .form-control input {
    flex: 2;
    width: 40%;
    height: 30px;
    margin: 7px;
    padding: 3px 7px;
    font-size: 1.2rem;
  }

  .form-control.flex {
    justify-content: space-between;
    margin-bottom: 2rem;
  }

  .form-control.flex > label {
    width: 100%;
    border-bottom: 2px solid #000;
    margin-bottom: 1rem;
  }

  .check-container {
    margin-bottom: 1rem;
  }

  .check-container.grid {
    grid-template-columns: repeat(5, 1fr);
  }
  
  .form-control .checkbox {
    display: flex;
    margin-right: 1rem;
  }

  .form-control input[type="checkbox"] {
    height: 1.2rem;
    width: 100%;
    margin: auto;
    flex: 1;
    padding: 0;
  }

  .form-control .checkbox label {
    flex: 2;
  }

  .btn-container {
    align-self: flex-start;
  }

  ul {
    list-style: none;
  }

  .error {
    font-weight: bold;
  }
</style>