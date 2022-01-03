<template>
  <div>
    Hi
    <CommentSection :comments="comments" @addComment="updateComments" />
  </div>
</template>

<script>
  import CommentSection from "@/components/comments/CommentSection.vue";

  export default {
    components: {
      CommentSection,
    },
    data() {
      return {
        counter: 1,
        comments: []
      };
    },
    methods: {
      async updateComments(comment) {
        comment.id = this.counter++;
        this.comments = [comment, ...this.comments];
      },
    },
    created() {
      this.comments = [
        {
          id: 1,
          movieId: 1,
          username: "Test1",
          comment: "I love this movie"
        },
        {
          id: 2,
          movieId: 1,
          username: "Test2",
          comment: "Yes!"
        },
        {
          id: 3,
          movieId: 1,
          username: "Test3",
          comment: "I'm writing a bunch of words to have a very long comment so that I can format this comment section into something that looks decent even if it really isn't and stuff and things and stuff and things and more stuff about things and woah!"
        },
        {
          id: 4,
          movieId: 1,
          username: "Test4",
          comment: "Uh oh, I'm in trouble"
        },
        {
          id: 5,
          movieId: 1,
          username: "Test5",
          comment: "I love to goat the goat"
        },
        {
          id: 6,
          movieId: 1,
          username: "Test6",
          comment: "PJ Masks save the day"
        },
      ]
    }
  }
</script>

<style scoped>

</style>