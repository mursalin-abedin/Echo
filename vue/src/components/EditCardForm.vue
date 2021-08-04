<template>
<div class=card>
    Add New Card
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
import CardService from '../services/CardService'
export default {
  name: 'AddCard',
  data() {
    return {
        editcard: {
            question: '',
            answer: '',
            keywords: '',
    }
    }
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
      }
      console.log("Created Ncard:" + ncard.question)
        this.$emit('add-card', ncard)
        //this.question = ''
        //this.answer = ''
        //this.keywords = ''
    },
 },
  created(){
           CardService.getCardById(1).then(resp => {
               this.editcard = resp.data
           });
        }
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