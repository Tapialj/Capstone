<template>
  <Card>
    <div class="error" v-if="errors.length">
      <label>Please correct the error:</label>

      <ul>
        <li :key="error" v-for="error in errors">
          {{ error }}
        </li>
      </ul>
    </div>

    <SmallButton :title="!showNewComment ? 'Add Comment' : 'Cancel'" @btn-click="toggleNewComment" />

    <div class="new-comment" v-if="showNewComment">
      <input type="text" class="username" placeholder="Name" v-model="username">
      <textarea name="comment" class="textarea" id="comment" rows="1" placeholder="Comment" @input="autoResize" v-model="comment"></textarea>
      <SmallButton title="Submit" @btn-click="submit" />
    </div>
  </Card>
</template>

<script>
  import SmallButton from "@/components/SmallButton.vue";
  import Card from "@/components/Card.vue";

  export default {
    name: "NewComment",
    components: {
      SmallButton,
      Card
    },
    data () {
      return {
        errors: [],
        comment: "",
        username: "",
        showNewComment: false,
      };
    },
    methods: {
      toggleNewComment() {
        this.showNewComment = !this.showNewComment;
      },
      autoResize(e) {
        e.target.style.height = "auto";
        e.target.style.height = `${e.target.scrollHeight}px`;
      },
      submit() {
        this.errors = [];

        if(!!this.username.trim() && !!this.comment.trim()) {
          this.$emit("submit", { username: this.username, comment: this.comment });
          this.comment = "";
          this.username = "";
          this.showNewComment = !this.showNewComment;
        }
        else {
          this.errors.push("Name and Comment are required to submit");
        }
      }
    },
    emits: [
      "submit",
    ],
  }
</script>

<style scoped>
  .new-comment {
    font-size: 1.25rem;
  }

  .username {
    display: block;
    margin-bottom: 1rem;
    font-size: inherit;
    border: none;
    width: 15%;
    border-bottom: 1px solid #000;
  }

  .textarea {
    display: block;
    border: none;
    border-bottom: 1px solid #000;
    width: 100%;
    overflow: hidden;
    resize: none;
    font-size: inherit;
    font-family: inherit;
    max-height: 15rem;
  }

  .username:focus,
  .textarea:focus {
    outline: none;
  }

  ul {
    list-style: none;
  }

  .error {
    font-weight: bold;
  }
</style>