<template>
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
        <label for="title">Movie Title</label>
        <input type="text" id="title" name="title" v-model="movie.title" />
      </div>

      <div class="form-control">
        <label for="genre">Genre</label>
        <select id="genre" name="genre" v-model="selectedGenre" @change="selectGenre">
          <option disabled selected value="">--Select--</option>
          <option :key="genre.id" v-for="genre in genres" :value="genre.genre">{{ genre.genre }}</option>
        </select>
      </div>

      <div class="form-control">
        <label for="movieLength">Movie Length in minutes</label>
        <input type="text" id="movieLength" name="movieLength" v-model="movie.movieLength" />
      </div>

      <div class="form-control">
        <label for="release-date">Movie Release date</label>
        <input type="date" id="release-date" name="release-date" v-model="movie.releaseDate" />
      </div>

      <div class="form-control">
        <label for="trailerUrl">Youtube Trailer URL</label>
        <input type="url" id="trailerUrl" name="trailerUrl" v-model="movie.trailerUrl" />
      </div>

      <div class="form-control">
        <label for="rating">MPAA Rating</label>
        <select id="rating" name="rating" v-model="selectedRating" @change="selectRating">
          <option disabled selected value="">--Select--</option>
          <option :key="rating.id" v-for="rating in ratings" :value="rating.rating">{{ rating.rating }}</option>
        </select>
      </div>

      <div class="form-control flex">
        <label for="director">Director</label>
        <div class="grid check-container">
          <div :key="director.id" class="checkbox" v-for="director in directors">
            <input :key="director.id" type="radio" name="director" :id="[director.lastName, director.firstName]" :value="[director.lastName, director.firstName]" v-model="selectedDirector" @change="selectDirector" />
            <label :for="[director.lastName, director.firstName]">{{ director.lastName }}, {{ director.firstName }}</label>
          </div>
        </div>

        <div class="btn-container">
          <Button title="Add New Director" type="button" />
        </div>
      </div>

      <div class="form-control flex">
        <label for="actor">Actors</label>
        <div class="grid check-container">
          <div :key="actor.id" class="checkbox" v-for="actor in actors">
            <input :key="actor.id" type="checkbox" name="actor" :id="[actor.lastName, actor.firstName]" :value="[actor.lastName, actor.firstName]" v-model="selectedActors" @change="selectActors" />
            <label :for="[actor.lastName, actor.firstName]">{{ actor.lastName }}, {{ actor.firstName }}</label>
          </div>
        </div>

        <span>Actors {{ selectedActors }}</span>

        <div class="btn-container">
          <Button title="Add New Actor" type="button" />
        </div>
      </div>

      <Button title="Save Movie" />

      <!--<Modal v-model="modalOpen">
        <DirectorForm />
        </Modal>-->
    </form>
</template>

<script>
  import Button from "@/components/Button.vue";
  //import Modal from "@/components/Modal/Modal.vue";

  export default {
    name: "AddMovieForm",
    components: {
      Button,
      //Modal,
    },
    props: {
      edit: {
        default: function() {
          return { edit: false };
        },
        type: Object,
      },

    },
    data() {
      return {
        errors: [],
        genres: [],
        ratings: [],
        directors: [],
        actors: [],
        movie: {
          title: "",
          movieLength: "",
          releaseDate: "",
          trailerUrl: "",
          selectedGenreObject: {},
          selectedRatingObject: {},
          selectedDirectorObject: {},
          selectedActorObjects: [],
        },
        selectedGenre: "",
        selectedRating: "",
        selectedDirector: "",
        selectedActors: [],
        modalOpen: false,
      };
    },
    methods: {
      openModal() {
        this.modalOpen = !this.modalOpen;
      },
      checkForm() {
        this.errors = [];

        if(!this.movie.title || this.movie.title === "") {
          this.errors.push("Title is Required")
        }
        
        if(!this.movie.movieLength || this.movie.movieLength === "") {
          this.errors.push("Movie Length is Required")
        }
        else if(!this.validLength(this.movie.movieLength)) {
          this.errors.push("Movie length should be whole number in minutes")
        }
        
        if(!this.movie.releaseDate || this.movie.releaseDate === "") {
          this.errors.push("Release Date is Required")
        }
        
        if(!this.movie.trailerUrl || this.movie.trailerUrl === "") {
          this.errors.push("Trailer is Required")
        }
        else if(!this.validUrl(this.movie.trailerUrl)) {
          this.errors.push("Please enter a valid Youtube video link (youtube.com/watch?v=****)")
        }
        
        if(!this.selectedGenre || this.selectedGenre === "") {
          this.errors.push("Genre is Required")
        }

        if(!this.selectedRating || this.selectedRating === "") {
          this.errors.push("Rating is Required")
        }

        if(!this.selectedDirector || this.selectedDirector === "") {
          this.errors.push("Director is Required");
        }

        if(!this.errors.length) {
          this.submitMovie();
        }
      },
      submitMovie() {
        //this.$emit("save-movie", this.movie);
        console.log(this.movie);
      },
      validLength (movieDuration) {
        const test = +movieDuration;

        if(!isNaN(test)) {
          return true;
        }

        return false;
      },
      validUrl(url) {
        if(url.includes("youtube.com/watch?v=")) {
          return true;
        }

        return false;
      },
      selectGenre() {
        this.genres.map((genre) => {
          if(genre.genre === this.selectedGenre) {
            this.movie.selectedGenreObject = genre;
          }
        });
      },
      selectRating() {
        this.ratings.map((rating) => {

          if(rating.rating === this.selectedRating) {
            this.movie.selectedRatingObject = rating;
          }
        });
      },
      selectActors() {
        this.actors.map((actor) => {
            if(actor.lastName === this.selectedActors[0] && actor.firstName === this.selectedActors[1]) {
              this.movie.selectedActorObjects.push(actor);
              console.log(actor);
            }
        });
      },
      selectDirector() {
        this.directors.map((director) => {
          if(director.lastName === this.selectedDirector[0] && director.firstName === this.selectedDirector[1]) {
            this.movie.selectedDirectorObject = director;
          }
        });
      },
      async getGenres() {
        const res = await fetch("api/genres");
        const data = await res.json();

        return data;
      },
      async getRatings() {
        const res = await fetch("api/ratings");
        const data = await res.json();

        return data;
      },
      async getActors() {
        const res = await fetch("api/actors");
        const data = await res.json();

        return data;
      },
      async getDirectors() {
        const res = await fetch("api/directors");
        const data = await res.json();

        return data;
      },
      async getMovieDetails(id) {
        const res = await fetch(`api/movies/${id}`);
        const data = await res.json();

        return data;
      }
    },
    emits: [
      "save-movie"
    ],
    async created() {
      this.genres = await this.getGenres();
      this.ratings = await this.getRatings();
      this.directors = await this.getDirectors();
      this.actors = await this.getActors();

      if(this.edit.edit === true) {
        this.movie = await this.getMovieDetails(this.editData.id);
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

  .form-control input,
  .form-control select {
    flex: 2;
    width: 40%;
    height: 30px;
    margin: 7px;
    padding: 3px 7px;
    font-size: 1.2rem;
  }

  .form-control select {
    height: 40px;
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

  .form-control input[type="radio"] {
    height: 1.2rem;
    width: 100%;
    margin: auto;
    flex: 1;
    padding: 0;
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