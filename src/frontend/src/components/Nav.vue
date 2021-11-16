<template>
  <div class="flex" id="nav">
    <h1>Our Movie DB</h1>

    <nav>
      <router-link to="/">Home</router-link> |
      <router-link to="/movies">Movies</router-link> |
      <router-link to="/actors">Actors</router-link>
    </nav>
  </div>
</template>

<script>
  export default {
    name: "Nav"
  }
</script>

<style scoped>
  h1 {
    color: #42b983;
    font: 24px;
  }
</style>