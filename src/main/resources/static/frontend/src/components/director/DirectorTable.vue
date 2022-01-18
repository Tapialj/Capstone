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
        <tr :key="director.id" v-for="(director, index) in directors">
          <Director :director="director" :listNumber="++index" @onDelete="onDelete" />
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
  import Director from "@/components/director/Director.vue";

  export default {
    name: "DirectorTable",
    components: {
      Director,
    },
    props: {
      directors: Array,
    },
    methods: {
      onDelete(director) {
        this.$emit("onDelete", director);
      },
    },
    emits: [
      "onDelete"
    ]
  }
</script>

<style scoped>

</style>