<template>
  <div class="card">

    <!-- <div @click="isToggle = !isToggle" :class="[isToggle ? 'colorFront' : 'colorBack']" class="animated flip"> -->
      <!-- class for team to edit-->
      <!-- <h1>{{card.question}}</h1> -->
      <!-- <div class="card-content">
        <p v-bind="card.id">{{ front }}</p>
      </div>

      <div class="card-content">
        <p v-bind="card.id">{{ back }}</p>
      </div> -->

        <div class="flip-card">
          <div class="flip-card-inner">
            <div class="flip-card-front">
                <div class="cardtext cardtextfront">{{card.question}}</div>
            </div>
            <div class="flip-card-back">
              <div class="cardtext cardtextback">{{card.answer}}</div>
            </div>
          </div> 
        </div>

    </div>

</template>

<script>
export default {
    name: 'card',
    data(){
        return{
            //isToggle:false,
        }
    },
    props:{
      card: Object
    }

};
</script>

<style scoped>
.card {
  display: block;
}

/* .colorFront {
  background-color: white;
}

.colorFront {
  background-color: black;
} */

.flip-card {
  display:block;
  background-color: transparent;
  width: 300px;
  height: 300px;
  border: 1px solid #f1f1f1;
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
}

/* Style the back side */
.flip-card-back {
  background-color: dodgerblue;
  color: white;
  transform: rotateY(180deg);
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

</style>