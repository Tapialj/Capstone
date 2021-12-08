<template>
  <td class="id">{{ listNumber }}</td>
  <td class="name">
    <router-link :to="{ name: 'DirectorDetails', params: { id: director.id}}">
      {{ director.firstName }} {{ director.lastName }}
    </router-link>
  </td>
  <td class="delete">
    <p @click="onDelete(director)">Delete</p>
  </td>
</template>

<script>
  export default {
    name: "Director",
    props: {
      director: Object,
      listNumber: Number,
    },
    methods: {
      onDelete(director) {
        this.$emit("onDelete", director);
      }
    },
    emits: [
      "onDelete"
    ],
  }
</script>

<style scoped>
  td {
    border-bottom: 1px solid #00A38B;/*cecfd5;*/
    text-align: left;
    padding: 10px 15px;
  }

  .id {
    width: 5%;
  }

  .name {
    width: 55%;
    color: #007582;
    font-weight: bold;
  }

  .delete {
    color: #3366BB;
    text-align: right;
  }

  .delete p {
    display: inline-block;
    margin: 0;
    cursor: pointer;
  }
</style>