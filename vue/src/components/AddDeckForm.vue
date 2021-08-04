<template>
<div class=card>
  <h2 class="title">
    Add New Deck
    <i class="fas fa-plus" style="color: lightgreen"></i>
    </h2>
     <form @submit="onSubmit" class="add-deck">
    <div class="form-control">
      <label>Name:</label>
      <input type="text" v-model="deckName" name="deckName" placeholder="Name your deck!" />
    </div>
    <div class="form-control">
      <label>Description:</label>
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

  display: block;
  background-color: transparent;
  width: 300px;
  height: 300px;
  border: 2px solid lightgray;
  margin: 10px 30px;
  border-radius: 10px;
  font-family: Arial, Helvetica, sans-serif;
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