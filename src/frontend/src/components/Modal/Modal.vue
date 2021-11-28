<template>
  <div class="modal" v-show="open">
    <slot>

    </slot>
  </div>
</template>

<script>
  
  
  export default {
    name: "Modal",
    components: {

    },
    props: {
      modalForm: String,
      open: {
        required: true,
      }
    },
    emits: [
      "on-modal"
    ],
  }
</script>

<style scoped>
  .modal {
    box-shadow: 0 1px 4px rgba(0, 0, 0, 0.2);
    border-radius: 6px;
    background-color: white;
    padding: 1rem;
    width: 30rem;
    z-index: 10;
    position: fixed;
    top: 20vh;
    left: calc(50% - 15rem);
  }
</style>