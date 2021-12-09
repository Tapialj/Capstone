<template>
  <div class="flex directors no-align">
    <div class="flex row">
      <h1>Directors</h1>
      <Button title="Add Director" @btn-click="addDirector" />
    </div>

    <DirectorTable :directors="directors" @onDelete="onDelete" />

    <Modal v-if="deleteModalOpen" @onModal="onDeleteModal">
      <p>
        Are you sure you want to delete {{ directorDelete.firstName }} {{ directorDelete.lastName }}?
      </p>

      <Button title="Delete" @btn-click="deleteDirector(directorDelete.id)" />
    </Modal>
  </div>
</template>

<script>
  import DirectorTable from "@/components/director/DirectorTable.vue";
  import Button from "@/components/Button.vue";
  import Modal from "@/components/Modal/Modal.vue";

  export default {
    components: {
      DirectorTable,
      Button,
      Modal,
    },
    data() {
      return {
        directors: [],
        deleteModalOpen: false,
        directorDelete: {},
      }
    },
    methods: {
      onDelete(director) {
        this.directorDelete = director;
        this.deleteModalOpen = !this.deleteModalOpen;
      },
      onDeleteModal() {
        this.deleteModalOpen = !this.deleteModalOpen;
      },
      async deleteDirector(id) {
        await fetch(`api/directors/${id}`, {
          method: "DELETE",
          headers: {
            "Content-type": "application/json"
          },
        });

        this.directors = this.directors.filter((director) => director.id !== id);

        this.directorDelete = null;
        this.deleteModalOpen = !this.deleteModalOpen;
      },
      async fetchDirectors() {
        const res = await fetch("api/directors");
        const data = await res.json();

        return data;
      },
      addDirector() {
        this.$router.push({name: "AddDirector"});
      }
    },
    async created() {
      this.directors = await this.fetchDirectors();
    }
  }
</script>

<style scoped>

</style>