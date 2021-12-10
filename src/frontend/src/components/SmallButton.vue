<template>
  <button class="btn" :type="type" @click="onClick()">{{ title }}</button>
</template>

<script>
  export default {
    name: "SmallButton",
    props: {
      title: String,
      type: {
        default: "submit",
        type: String,
      },
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
    padding: 0.6em 1.5em;
    background-color: #00A38B;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-size: 1rem;
    box-shadow: 4px 4px 5px rgba(0, 0, 0, 0.5);
  }

  .btn:hover,
  .btn:focus {
    transform: scale(0.98);
    filter: brightness(90%);
  }
</style>