<template>
  <div class="backdrop" @click="on-modal" />

  </div>
</template>

<script>
  export default {
    name: "Backdrop",
    emits: [
      "on-modal"
    ],
  }
</script>

<style scoped>
  .backdrop {
    position: fixed;
    top: 0;
    left: 0;
    height: 100%;
    width: 100%;
    background-color: rgba(0, 0, 0, 0.75);
    z-index: 1;
  }
</style>