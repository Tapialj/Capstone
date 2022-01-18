<template>
  <Backdrop @onModal="onModal">
    <div class="modal" @click.stop="">
      <slot>

      </slot>
    </div>
  </Backdrop>
</template>

<script>
  import Backdrop from "./Backdrop.vue";
  
  export default {
    name: "Modal",
    components: {
      Backdrop
    },
    props: {
      // open: {
      //   required: true,
      // }
    },
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
  .modal {
    box-shadow: 0 1px 4px rgba(0, 0, 0, 0.2);
    border-radius: 6px;
    background-color: white;
    padding: 1rem;
    width: 75%;
    z-index: 100;
    position: fixed;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
  }
</style>