<template>
  <div class="movie-details">
    <div class="route">
      <h3><span>Movies</span>&emsp;/&emsp;{{ movie.title }}</h3>
    </div>

    <div class="flex row">
      <h1>{{ movie.title }} <span class="subtitle">({{ moment(movie.releaseDate).format("YYYY") }})</span></h1>
      <Button title="Edit" />
    </div>

    <div class="flex flex-info info">
      <span class="details">{{ movie.ratingId }}</span> |
      <span class="details">{{ movie.movieLength }}</span> |
      <span class="details">{{ movie.genre }}</span> |
      <span class="details">{{ moment(movie.releaseDate).format("D MMMM YYYY") }}</span>
    </div>
    
    <div class="youtube">
      <iframe width="640" height="360" :src="videoEmbed" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
    </div>
  </div>
</template>

<script>
  import moment from "moment";
  import Button from "@/components/Button.vue";

  export default {
    components: {
      Button,
    },
    props: [
      "id"
    ],
    data() {
      return {
        movie: {},
        moment,
        videoEmbed: "https://www.youtube.com/embed/"
      };
    },
    methods: {
      async fetchMovie(id) {
        const res = await fetch(`api/movies/${id}`);
        const data = await res.json();

        return data;
      }
    },
    async created() {
      this.movie = await this.fetchMovie(this.id);  

      //eslint-disable-next-line
      const reg = new RegExp('.*?=\s*(.*)');
      const split = reg.exec(this.movie.trailerUrl);
      this.videoEmbed += split[1];
    }
  }
</script>

<style scoped>
  h1 {
    font-weight: bold;
  }
  
  .route h3 {
    font-weight: 200;
    font-size: 1.1rem;
    text-align: left;
  }

  .route h3 span {
    color: #3366BB;
  }

  .subtitle {
    font-weight: 400;
    font-size: 1rem;
  }

  .info {
    font-weight: 300;
    letter-spacing: 1px;
  }

  .details {
    margin: 0 0.8rem;
  }

  .details:first-child {
    margin-left: 0;
  }

  .details:last-child {
    margin-right: 0;
  }

  .youtube {
    margin: 1.5rem 0;
    position: relative;
  }

  .youtube iframe {
    position: absolute;
    left: 0;
  }
</style>