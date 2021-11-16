<template>
  <button class="btn" @click="onClick()">{{ title }}</button>
</template>

<script>
  export default {
    name: "Button",
    props: {
      title: String,
      
    },
    methods: {
      onClick() {
        this.$emit("btn-click");
      }
    },
    emits: [
      "btn-click"
    ],
  }
</script>

<style scoped>
  .btn {
    display: inline-block;
    padding: 1rem 1.5rem;
    background-color: #42b983;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-size: 1rem;
  }
</style>