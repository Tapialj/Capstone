<template>
  <div class="flex actors no-align">
    <div class="flex row">
      <h1>Actors</h1>
      <Button title="Add Actor" @btn-click="addActor" />
    </div>

    <ActorTable :actors="actors" @onDelete="onDelete" />

    <Modal v-if="deleteModalOpen" @onModal="onDeleteModal">
      <p>
        Are you sure you want to delete {{ actorDelete.firstName }} {{ actorDelete.lastName }}?
      </p>

      <Button title="Delete" @btn-click="deleteActor(actorDelete.id)" />
    </Modal>
  </div>
</template>

<script>
  import ActorTable from "@/components/actor/ActorTable.vue";
  import Button from "@/components/Button.vue";
  import Modal from "@/components/Modal/Modal.vue";

  export default {
    components: {
      ActorTable,
      Button,
      Modal,
    },
    data() {
      return {
        actors: [],
        deleteModalOpen: false,
        actorDelete: {},
      }
    },
    methods: {
      onDelete(actor) {
        this.actorDelete = actor;
        this.deleteModalOpen = !this.deleteModalOpen;
      },
      onDeleteModal() {
        this.deleteModalOpen = !this.deleteModalOpen;
      },
      async deleteActor(id) {
        await fetch(`api/actors/${id}`, {
          method: "DELETE",
          headers: {
            "Content-type": "application/json"
          },
        });

        this.actors = this.actors.filter((actor) => actor.id !== id);

        this.actorDelete = null;
        this.deleteModalOpen = !this.deleteModalOpen;
      },
      async fetchActors() {
        const res = await fetch("api/actors");
        const data = await res.json();

        return data;
      },
      addActor() {
        this.$router.push({name: "AddActor"});
      }
    },
    async created() {
      this.actors = await this.fetchActors();
    }
  }
</script>

<style scoped>

</style>