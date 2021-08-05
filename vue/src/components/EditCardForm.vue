<template>
<div class=card>
    <h2 class="title">
    Edit Card <i class="fas fa-pencil-alt"></i>
    </h2>
     <form @submit="onSubmit" class="add-card">
    <div class="form-control">
      <label>Question</label>
      <input 
        type="text" 
        v-model="editcard.question" 
        name="question" 
        >
    </div>
    <div class="form-control">
      <label>Answer</label>
      <input
        type="text"
        v-model="editcard.answer"
        name="answer"
      />
     </div>
     <div class="Keywords">
      <label>Keywords</label>
      <input
        type="text"
        v-model="editcard.keywords"
        name="keywords"
      />
    </div>

    <input type="submit" value="Save Card" class="btn btn-block" />
  </form>
    </div>

</template>

<script>
export default {
  name: 'AddCard',
  data() {
    return {
        editcard: {
            question: this.card.question,
            answer: this.card.answer,
            keywords: this.card.keywords,
            cardId: this.card.cardId,
    }
    }
  },
     props:{
      card: Object
    },
  methods: {

    onSubmit(e) {
      e.preventDefault()
      if (!this.editcard.question) {
        alert('Please fill the blanks')
        return
      }
      const ncard = {
        question: this.editcard.question,
        answer: this.editcard.answer,
        keywords: this.editcard.keywords,
        cardId: this.editcard.cardId
      }
      console.log("Created Ncard:" + ncard.cardId)
        this.$emit('edit-card', ncard)
        //this.question = ''
        //this.answer = ''
        //this.keywords = ''
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
  margin: 10px;
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
.fa-pencil-alt{
    color:lightgreen;
}

</style>