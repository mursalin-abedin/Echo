<template>
  <div class="card">
    <div>
      <h2 class="title">
        Add New Card
        <i class="fas fa-plus" style="color: lightgreen"></i>
      </h2>
    </div>

    <form @submit="onSubmit" class="add-card">
      <div class="form-control">
        <label>Question:</label>
        <input
          type="text"
          v-model="question"
          name="question"
          placeholder="Add Question"
        />
      </div>
      <div class="form-control">
        <label>Answer: </label>
        <input
          type="text"
          v-model="answer"
          name="answer"
          placeholder="Add Answer"
        />
      </div>
      <div class="Keywords">
        <label>Keywords: </label>
        <input
          type="text"
          v-model="keywords"
          name="keywords"
          placeholder="Add Keywords"
        />
      </div>

      <input type="submit" value="Save Card" class="btn btn-block" />
    </form>
  </div>
</template>



<script>
export default {
  name: "AddCard",
  data() {
    return {
      question: "",
      answer: "",
      keywords: "",
    };
  },
  methods: {
    onSubmit(e) {
      e.preventDefault();
      if (!this.question) {
        alert("Please fill the blanks");
        return;
      }
      const ncard = {
        question: this.question,
        answer: this.answer,
        keywords: this.keywords,
      };
      console.log("Created Ncard:" + ncard.question);
      this.$emit("add-card", ncard);
      //this.question = ''
      //this.answer = ''
      //this.keywords = ''
    },
  },
};
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
</style>