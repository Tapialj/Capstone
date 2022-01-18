<template>
  <div>
    <NewComment @submit="submit" />
    <Comments :comments="comments" />
  </div>
</template>

<script>
  import NewComment from "@/components/comments/NewComment.vue";
  import Comments from "@/components/comments/Comments.vue";
  //import Card from "@/components/Card.vue";

  export default {
    name: "CommentSection",
    components: {
      NewComment,
      Comments,
      //Card,
    },
    props: {
      comments: Array,
      parentId: Number,
    },
    data () {
      return {
        error: "",
        areErrors: false,
      };
    },
    methods: {
      submit(commentData) {
        commentData.parentId = this.parentId;
        this.$emit("addComment", commentData);
      }
    },
    emits: [
      "addComment",
    ],
    async created() {

    }
  }
</script>

<style scoped>

</style>