<template>
  <div class="movie-details">
    <div class="route">
      <h3>
        <router-link to="/movies">
          <span>Movies</span>
        </router-link>
        &emsp;/&emsp;{{ movie.title }}
      </h3>
    </div>

    <div class="flex row">
      <h1>{{ movie.title }} <span class="subtitle">({{ moment(movie.releaseDate).format("YYYY") }})</span></h1>
      <Button title="Edit" @btn-click="editMovie(this.id)" />
    </div>

    <div class="flex flex-info info">
      <span class="details">{{ movie.rating.rating }}</span> |
      <span class="details">{{ movie.movieLength }}</span> |
      <span class="details">{{ movie.genre.genre }}</span> |
      <span class="details">{{ moment(movie.releaseDate).format("D MMMM YYYY") }}</span>
    </div>
    
    <div class="youtube">
      <iframe width="640" height="360" :src="videoEmbed" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
    </div>

    <div class="cast-crew grid">
      <div class="director">
        <h2>Directed By:</h2>
        
        <router-link :to="{name: 'DirectorDetails', params: {id: movie.director.id }}">
          <ListItem>
            {{ movie.director.firstName }} {{ movie.director.lastName }}
          </ListItem>
        </router-link>
      </div>
      <aside class="cast">
        <h2>Actors:</h2>
        <div class="actors grid">
          <div :key="actor.id" class="actor" v-for="actor in movie.actors">
            <router-link :to="{name: 'ActorDetails', params: {id: actor.id}}">
              <ListItem>
                {{ actor.firstName }} {{ actor.lastName }}
              </ListItem>
            </router-link>
          </div>
        </div>
      </aside>
    </div>
  </div>
  <div class="comments">
    <h1>Comments</h1>
    
    <div class="error" v-if="areErrors">
      <label>ERROR: </label>
      <h4>{{ error }}</h4>
    </div>

    <CommentSection :comments="movie.comments" :parentId="movie.id" @addComment="updateComments" />
  </div>
</template>

<script>
  import moment from "moment";
  import Button from "@/components/Button.vue";
  import ListItem from "@/components/ListItem.vue";
  import CommentSection from "@/components/comments/CommentSection.vue";

  export default {
    components: {
      Button,
      ListItem,
      CommentSection,
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
      async updateComments(comment) {
        comment.movieId = this.movie.id;

        const res = await fetch("api/comments/movies", {
          method: "POST",
          headers: {
            "Content-type": "application/json"
          },
          body: JSON.stringify(comment)
        });

        this.areErrors = this.handleErrors(res);

        if(!this.areErrors) {
          const comment = await res.json();
          this.movie.comments = [comment, ...this.movie.comments];
        }
        else {
          const err = res.json();
          this.error = err.message;
        }
      },
      editMovie(id) {
        this.$router.push({name: "EditMovie", params: { id: id }});
      },
      async fetchMovie(id) {
        const res = await fetch(`api/movies/${id}`);
        const data = await res.json();

        return data;
      },
      handleErrors(response) {
        if(response.ok) {
          return false;
        }
        else {
          return true;
        }
      },
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
    display: flex;
  }

  .youtube iframe {
    justify-self: flex-start;
    border-radius: 8px;
  }

  .cast-crew {
    height: 110%;
  }

  .cast-crew.grid {
    grid-template-columns: auto 75%;
  }

  .cast-crew a {
    font-weight: bold;
    font-size: 1.125rem;
  }

  .director {
    align-self: flex-start;
    text-align: left;
  }

  .cast {
    padding-left: 1.5rem;
    text-align: left;
    border-left: 2px solid #000;
    align-self: flex-start;
  }

  .actors.grid {
    grid-template-rows: repeat(4, 1fr);
    grid-template-columns: auto;
    gap: 0.75rem;
    grid-auto-flow: column;
    justify-content: flex-start;
  }
</style>