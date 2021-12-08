<template>
  <td class="id">{{ listNumber }}</td>
  <td class="title">
    <router-link :to="{ name: 'MovieDetails', params: { id: movie.id}}">{{ movie.title }}</router-link>
  </td>
  <td>{{ movie.movieLength }} mins</td>
  <td class="delete">
    <p @click="onDelete(movie)">Delete</p>
  </td>
</template>

<script>
  export default {
    name: "Movie",
    props: {
      movie: Object,
      listNumber: Number,
    },
    methods: {
      onDelete(movie) {
        this.$emit("onDelete", movie);
      }
    },
    emits: [
      "onDelete"
    ],
  }
</script>

<style scoped>
  td {
    border-bottom: 1px solid #00A38B;/*cecfd5;*/
    text-align: left;
    padding: 10px 15px;
  }

  .id {
    width: 5%;
  }

  .title {
    width: 55%;
    color: #007582;
    font-weight: bold;
  }

  .delete {
    color: #3366BB;
    text-align: right;
  }

  .delete p {
    display: inline-block;
    margin: 0;
    cursor: pointer;
  }
</style>