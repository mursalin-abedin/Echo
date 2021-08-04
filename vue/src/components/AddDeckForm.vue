<template>
<div class=card>
    Add New Deck
     <form @submit="onSubmit" class="add-deck">
    <div class="form-control">
      <label>Name</label>
      <input type="text" v-model="deckName" name="deckName" placeholder="Name your deck!" />
    </div>
    <div class="form-control">
      <label>Description</label>
      <input
        type="text"
        v-model="deckDescription"
        name="deckDescription"
        placeholder="Describe your deck!"
      />
    </div>
    <input type="submit" value="Add Deck" class="btn btn-block" />
  </form>
    </div>

</template>



<script>
export default {
  name: 'AddCard',
  data() {
    return {
      deckName: '',
      deckDescription: '',
    }
  },
  methods: {
    onSubmit(e) {
      e.preventDefault()
      if (!this.deckName) {
        alert('Please fill the blanks')
        return
      }
      const ndeck = {
        deckName: this.deckName,
        deckDescription: this.deckDescription,
      }
      console.log("Created Ndeck:" + ndeck.deckName)
        this.$emit('add-deck', ndeck)
    },
  },
}
</script>

<style scoped>

.card {
  display:block;
  background-color: transparent;
  width: 300px;
  height: 300px;
  border: 1px solid #f1f1f1;
  margin: 10px;
}

</style>