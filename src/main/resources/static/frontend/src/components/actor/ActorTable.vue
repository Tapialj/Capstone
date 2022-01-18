<template>
  <div>    
    <table>
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">Name</th>
          <th scope="col"></th>
        </tr>
      </thead>

      <tbody>
        <tr :key="actor.id" v-for="(actor, index) in actors">
          <Actor :actor="actor" :listNumber="++index" @onDelete="onDelete" />
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
  import Actor from "@/components/actor/Actor.vue";

  export default {
    name: "ActorTable",
    components: {
      Actor,
    },
    props: {
      actors: Array,
    },
    methods: {
      onDelete(actor) {
        this.$emit("onDelete", actor);
      },
    },
    emits: [
      "onDelete"
    ]
  }
</script>

<style scoped>

</style>