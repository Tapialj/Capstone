<template>
  <Card>
    <h2 class="user">{{ comment.username }}</h2>
    <p class="comment">{{ comment.comment }}</p>
  </Card>
</template>

<script>
  import Card from "@/components/Card.vue";

  export default {
    name: "Comment",
    components: {
      Card
    },
    props: {
      comment: Object
    },
  }
</script>

<style scoped>
  .user {
    font-size: 1.25rem;
    text-align: left;
    border-bottom: 1px solid #000;
    padding-bottom: 0.5rem;
    margin-bottom: 1.25rem;
  }

  .comment {
    font-size: 1.5rem;
    text-align: left;

  }
</style>