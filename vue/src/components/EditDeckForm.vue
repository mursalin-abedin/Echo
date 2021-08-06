<template>
<div class=card>
  <h2 class="title">
    Edit Deck
    <i class="fas fa-plus" style="color: lightgreen"></i>
    </h2>
     <form @submit="onSubmit" class="edit-deck">
    <div class="form-control">
      <label>Name:</label>
      <input type="text" v-model="editdeck.deckName" name="deckName" placeholder="Name your deck!" />
    </div>
    <div class="form-control">
      <label>Description:</label>
      <input
        type="text"
        v-model="editdeck.deckDescription"
        name="deckDescription"
        placeholder="Describe your deck!"
      />
    </div>
    <input type="submit" value="Edit Deck" class="btn btn-block" />
  </form>
    </div>
</template>



<script>
export default {
  name: 'EditDeck',
  data() {
    return {
        editdeck: {
            deckName: this.deck.deckName,
            deckDescription: this.deck.deckDescription
    }
    }
  },
  props: {
    deck: Object
  },
  methods: {
    onSubmit(e) {
      e.preventDefault()
      if (!this.editdeck.deckName) {
        alert('Please fill the blanks')
        return
      }
        this.$emit('submit-edit-deck', this.editdeck)
    },
  },
}
</script>

<style scoped>

.card {

  display: block;
  background-color: transparent;
  width: 300px;
  height: 300px;
  border: 2px solid lightgray;
  margin: 10px 30px;
  border-radius: 10px;
  font-family: Arial, Helvetica, sans-serif;
  margin: 180px 10px 10px 20px;
}
.spacer{
  height: 81px;
  display: block;
}
.title {
  font-size: 25px;
  text-align: center;
  border-bottom: solid 2px lightgray;
}
form{
  margin-left: 15px;
  font-size: 20px;
}
input{
  justify-content: left;
  border: solid 2px lightgrey;
  border-radius: 2px;
  float: right;
  margin-right: 10px;
}
.btn-block{
 background-color: rgb(174, 226, 174);
 border-radius: 2px;
 justify-content: right;
 margin-top: 5px;
}

</style>