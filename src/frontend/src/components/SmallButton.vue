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
    align-self: flex-start;
    padding: 0.4em 1.25em;
    margin: 1rem 0;
    background-color: #009F99;
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