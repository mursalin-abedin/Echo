<template>
<div class=card>
    Add New Card
     <form @submit="onSubmit" class="add-card">
    <div class="form-control">
      <label>Question</label>
      <input type="text" v-model="question" name="question" placeholder="Add Question" />
    </div>
    <div class="form-control">
      <label>Answer</label>
      <input
        type="text"
        v-model="answer"
        name="answer"
        placeholder="Add Answer"
      />
    </div>
     <div class="Keywords">
      <label>Keywords</label>
      <input
        type="text"
        v-model="keywords"
        name="keywords"
        placeholder="Add Keywords"
      />
    </div>

    <input type="submit" value="Save Task" class="btn btn-block" />
  </form>
    </div>

</template>



<script>
export default {
  name: 'AddCard',
  data() {
    return {
      question: '',
      answer: '',
      keywords: '',
    }
  },
  methods: {
    onSubmit(e) {
      e.preventDefault()
      if (!this.question) {
        alert('Please fill the blanks')
        return
      }
      const newCard = {
        question: this.question,
        answer: this.answer,
        keywords: this.keywords,
      }
        this.$emit('add-card', newCard)
        this.question = ''
        this.answer = ''
        this.keywords = ''
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