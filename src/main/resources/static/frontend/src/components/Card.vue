<template>
  <div class="card">
    <slot>

    </slot>
  </div>
</template>

<script>
  export default {
    
  }
</script>

<style scoped>
  .card {
    border-radius: 8px;
    box-shadow: 0 2px 8px rgba(0, 0, 0, 0.2);
    padding: 1.125rem;
    margin: 0.75rem;
    background: #fff;
  }
</style>