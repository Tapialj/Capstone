<template>
  <div class="container">
    <Nav />
    <router-view />
  </div>
</template>

<script>
  import Nav from "./components/Nav.vue";

  export default {
    components: {
      Nav,
    }
  }
</script>

<style>
  *, *::before, *::after {
    box-sizing: border-box;
    margin: 0;
    padding: 0;
  }

  html,
  body {
    background: #d3d3d3;
  }

  a {
    text-decoration: none;
    color: inherit;
  }

  h1 {
    text-align: left;
  }
  
  .container {
    max-width: 1000px;
    padding: 0 40px;
    margin: 20px auto;
    
  }

  tr:last-child td {
    border-bottom: 0;
  }

  .flex {
    display: flex;
    flex-direction: column;
    align-items: center;
  }

  .row {
    flex-direction: row;
    justify-content: space-between;
    align-items: center;
  }

  .flex-info {
    flex-direction: row;
    justify-content: flex-start;
  }

  .grid {
    display: grid;
    grid-template-columns: repeat(2, 1fr);
    gap: 1.125em;
    justify-content: center;
    align-items: center;
    height: 100%;
  }

  .no-align {
    align-items: stretch;
  }

  button {
    align-self: flex-end;
  }

  table {
    width: 100%;
    border-collapse: separate;
    border-spacing: 0;
  }

  th {
    border-bottom: 1px solid #42b983;/*cecfd5;*/
    text-align: left;
    padding: 10px 15px;
  }

  .movies,
  .movie-details {
    padding: 2.5rem
  }

  .route h3 {
    font-weight: 200;
    font-size: 1.1rem;
    text-align: left;
  }

  .route h3 span {
    color: #007582;
  }

  #app {
    font-family: 'Roboto', sans-serif;/*'Montserrat', sans-serif;*/
    text-align: center;
    color: #2c3e50;
  }

  #nav {
    padding: 30px 0;
    flex-direction: row;
  }

  #nav nav {
    padding: 0 60px;
  }

  #nav a {
    font-weight: bold;
    color: #2c3e50;
  }

  #nav a.router-link-exact-active {
    color: #42b983;
  }
</style>
