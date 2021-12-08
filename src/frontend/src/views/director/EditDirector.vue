<template>
  <div>
    <h1>Edit Director</h1>

    <DirectorForm :edit="editData" @save-director="saveDirector" />
  </div>
</template>

<script>
  import DirectorForm from "@/components/Forms/DirectorForm.vue";

  export default {
    components: {
      DirectorForm,
    },
    props: [
      "id"
    ],
    data() {
      return {
        editData: {
          edit: true,
          id: this.id
        },
      };
    },
    methods: {
      async saveDirector(directorData) {
        await fetch(`api/directors/${this.id}`, {
          method: "PUT",
          headers: {
            "Content-type": "application/json"
          },
          body: JSON.stringify(directorData)
        });

        this.$router.replace({name: "Director", params: {id: this.id }});
      }
    }
  }
</script>

<style scoped>

</style>