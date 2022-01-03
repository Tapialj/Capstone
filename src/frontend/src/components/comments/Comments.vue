<template>
  <div>
    <Comment :key="comment.id" :comment="comment" v-for="comment in comments" />
  </div>
</template>

<script>
  import Comment from "@/components/comments/Comment.vue";

  export default {
    name: "Comments",
    components: {
      Comment
    },
    props: {
      comments: Array
    }
  }
</script>

<style scoped>

</style>