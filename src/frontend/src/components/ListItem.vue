<template>
  <h2 class="item">
    <slot>

    </slot>
  </h2>
</template>

<script>
  export default {
    name: "ListItem",
  }
</script>

<style scoped>
  .item {
    font-size: 1.125rem;
    padding: 0.75em 0.9em;
    background: #225E70;
    border-radius: 5px;
    color: #fff;
    font-weight: normal;
    text-align: center;
    margin: 0.125em;
    box-shadow: 4px 4px 5px rgba(0, 0, 0, 0.5);
  }

  .item:hover,
  .item:focus {
    transform: scale(0.98);
    filter: brightness(110%);
  }
</style>