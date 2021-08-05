<template>
  <div class="card">
        <div class="flip-card" v-if="!edit">
          <div class="flip-card-inner" v-bind:class="(card.deckId == currentDeckId) ? 'existsindeck' : ''">
            <div class="flip-card-front">
                <div class="cardtext cardtextfront ">{{card.question}}</div>
            </div>
            <div class="flip-card-back">
              <div class="edit" @click="showEditCardForm">
                  <i class="fas fa-pencil-alt"></i>
                  </div>
              <div class="cardtext cardtextback">{{card.answer}}</div>
            </div>
          </div> 
        </div>

        <div v-if="edit">
          <EditCardForm :card="card" @edit-card="repeatEditCard"/>
          </div>

    </div>

</template>

<script>

import EditCardForm from './EditCardForm'
export default {
    name: 'card',
    data(){
        return{
            edit: false,
            existsInCurrentDeck: false
        }
    },
    components: {
      EditCardForm
    },
    props:{
      card: Object,
      currentDeckId: Number

    },
    methods: {
      showEditCardForm(){
        this.edit = !this.edit
      },
      repeatEditCard(ncard){
            this.$emit('edit-card', ncard)
            this.showEditCardForm();
        }

    }
}
</script>

<style scoped>
.card {
  display: block;
}
.edit {
    float: right;
    padding: 5pt;
    text-align: right;
    color:lightgreen;
}

.flip-card {
  display:block;
  background-color: transparent;
  width: 300px;
  height: 300px;
  perspective: 1000px; /* Remove this if you don't want the 3D effect */
  margin: 10px;
}

/* This container is needed to position the front and back side */
.flip-card-inner {
  position: relative;
  width: 100%;
  height: 100%;
  text-align: center;
  transition: transform 0.8s;
  transform-style: preserve-3d;
}

/* Do an horizontal flip when you move the mouse over the flip box container */
.flip-card:hover .flip-card-inner {
  transform: rotateY(180deg);
}

/* Position the front and back side */
.flip-card-front, .flip-card-back {
  position: absolute;
  width: 100%;
  height: 100%;
  -webkit-backface-visibility: hidden; /* Safari */
  backface-visibility: hidden;
}

/* Style the front side (fallback if image is missing) */
.flip-card-front {
  background-color: #bbb;
  color: black;
  border-radius: 10px;
}

/* Style the back side */
.flip-card-back {
  background-color: dodgerblue;
  color: white;
  transform: rotateY(180deg);
    border-radius: 10px;
}

.existsindeck{
    border-style: solid;
    border-width: medium;
    border-color: lightgreen;
    border-radius: 14px;
}

.cardtext {
  padding: 10px;
}

.cardtextfront {
  font-size: 18pt
}

.cardtextback {
  font-size: 14pt;
}

.edit:hover {
  background-color: #0e77c7;
  border-radius: 30%;
}

</style>