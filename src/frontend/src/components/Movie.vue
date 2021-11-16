<template>
  <td class="id">{{ movie.id }}</td>
  <td class="title">
    <router-link :to="{ name: 'MovieDetails', params: { id: movie.id}}">{{ movie.title }}</router-link>
  </td>
  <td>{{ movie.movieLength }} mins</td>
  <td class="delete">Delete</td>
</template>

<script>
  export default {
    name: "Movie",
    props: {
      movie: Object,
    },

  }
</script>

<style scoped>
  td {
    border-bottom: 1px solid #42b983;/*cecfd5;*/
    text-align: left;
    padding: 10px 15px;
  }

  .id {
    width: 5%;
  }

  .title {
    width: 55%;
  }

  .delete {
    color: #3366BB;
    text-align: right;
  }
</style>