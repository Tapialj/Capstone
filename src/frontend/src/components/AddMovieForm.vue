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
        <input type="text" id="title" name="title" v-model="title" />
      </div>

      <div class="form-control">
        <label for="genre">Genre</label>
        <select id="genre" name="genre" v-model="genre">
          <option disabled selected value="">--Select--</option>
          <option :key="genre.id" v-for="genre in genres" :value="genre.genre">{{ genre.genre }}</option>
          <!--<option value="action">Action</option>
          <option value="comedy">Comedy</option>
          <option value="drama">Drama</option>
          <option value="fantasy">Fantasy</option>
          <option value="horror">Horror</option>
          <option value="thriller">Thriller</option>
          <option value="romance">Romance</option>
          <option value="adventure">Adventure</option>
          <option value="western">Western</option>
          <option value="musical">Musical</option>-->
        </select>
      </div>

      <div class="form-control">
        <label for="movieLength">Movie Length in minutes</label>
        <input type="text" id="movieLength" name="movieLength" v-model="movieLength" />
      </div>

      <div class="form-control">
        <label for="release-date">Movie Release date</label>
        <input type="date" id="release-date" name="release-date" v-model="releaseDate" />
      </div>

      <div class="form-control">
        <label for="trailerUrl">Youtube Trailer URL</label>
        <input type="url" id="trailerUrl" name="trailerUrl" v-model="trailerUrl" />
      </div>

      <div class="form-control">
        <label for="ratingId">MPAA Rating</label>
        <select id="ratingId" name="ratingId" v-model="ratingId">
          <option disabled selected="true" value="">--Select--</option>
          <option :key="rating.id" v-for="rating in ratings" :value="rating">{{ rating }}</option>
          <!--<option value="1">G</option>
          <option value="2">PG</option>
          <option value="3">PG-13</option>
          <option value="4">R</option>-->
        </select>
      </div>

      <Button title="Save Movie" />
    </form>
</template>

<script>
  import Button from "@/components/Button.vue";

  export default {
    name: "AddMovieForm",
    components: {
      Button
    },
    props: {
      editData: Object,
    },
    data() {
      return {
        errors: [],
        genres: [],
        ratings: [],
        movie: {
          title: "",
          genre: "",
          movieLength: "",
          releaseDate: "",
          trailerUrl: "",
          ratingId: "",
          director: "",
          directorId: ""
        },
      };
    },
    methods: {
      checkForm() {
        this.errors = [];

        if(!this.title || this.title === "") {
          this.errors.push("Title is Required")
        }

        if(!this.genre || this.genre === "") {
          this.errors.push("Genre is Required")
        }
        
        if(!this.movieLength || this.movieLength === "") {
          this.errors.push("Movie Length is Required")
        }
        else if(!this.validLength(this.movieLength)) {
          this.errors.push("Movie length should be whole number in minutes")
        }
        
        if(!this.releaseDate || this.releaseDate === "") {
          this.errors.push("Release Date is Required")
        }
        
        if(!this.trailerUrl || this.trailerUrl === "") {
          this.errors.push("Trailer is Required")
        }
        else if(!this.validUrl(this.trailerUrl)) {
          this.errors.push("Please enter a valid Youtube video link (youtube.com/watch?v=****)")
        }
        
        if(!this.ratingId || this.ratingId === "") {
          this.errors.push("Rating is Required")
        }

        if(!this.errors.length) {
          this.submitMovie();
        }
      },
      submitMovie() {
        this.movie = {
          title: this.title,
          genre: this.genre,
          movieLength: this.movieLength,
          releaseDate: this.releaseDate,
          trailerUrl: this.trailerUrl,
          ratingId: this.ratingId,
          directorId: ""
        }

        this.$emit("save-movie", this.movie);
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
      async getMovieDetails(id) {
        const res = await fetch(`api/movies/${id}`);
        const data = await res.json();

        return data;
      }
    },
    emits: [
      "save-movie"
    ],
    async beforeCreate() {
      this.genres = await this.getGenres();
      this.ratings = await this.getRatings();

      if(this.editData.edit === true) {
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
    margin: 1.2rem 0;

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
    font-size: 1rem;
  }

  ul {
    list-style: none;
  }

  .error {
    font-weight: bold;
  }
</style>