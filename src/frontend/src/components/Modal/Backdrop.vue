<template>
  <div class="backdrop" @click="onModal">
    <slot>

    </slot>
  </div>
</template>

<script>
  export default {
    name: "Backdrop",
    methods: {
      onModal() {
        this.$emit("onModal");
      }
    },
    emits: [
      "onModal"
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
    z-index: 10;
  }
</style>