<template>
  <div>
    <Nav>
      <div class="logobox" @click="$router.push('/')">
        <div class="logo">
          <i class="fas fa-user-astronaut logoadjust"></i>
        </div>
        <div class="logowords">Echo</div>
      </div>
      <div class="loginbox" @click="$router.push('/AboutUs')">
        <div class="loginlogo">
            <i class="fas fa-sign-in-alt loginadjust"></i>
        </div>
        <div class="loginwords">
            About Us
        </div>
    </div>
    </Nav>
    <mainapparea>
      <div class="decktitle">Studying For: {{ deck.deckName }}</div>
      <div class="deckdescription">{{ deck.deckDescription }}</div>
      <cardboxarea >
        <div class="bigcardoutside"  >
          <div class="flip-card" v-if="!isCompleted" :class=" showAnswer ? 'rotate-card' : ''">
            <div class="flip-card-inner">
              <div class="flip-card-front" >
                <!-- front of card -->
                <div class="bigcard" v-if="!showAnswer">
                  <div class="bigcardbody" @click.stop="toggleShowAnswer">
                    {{currentCard.question}}
                  </div>
                  <div class="bigcardbottombar" @click.stop="toggleShowAnswer" >Click to see answer!</div>
                </div>
                <div class="bigcard" v-if="showAnswer">
                  <div class="bigcardbody" @click.stop="toggleShowAnswer">
                    <div style="transform: rotateY(180deg);">
                    {{currentCard.answer}}
                    </div>
                  </div>
                  <div class="bigcardbottombarback" >
                    <div class="questionwrong" @click.stop="incorrectAnswer(); showAnswer = false;" >
                      <div style="transform: rotateY(180deg);">Wrong</div>
                      </div>
                    <div class="questionright" @click.stop="correctAnswer(); showAnswer = false;" >
                      <div style="transform: rotateY(180deg);">Correct
                        </div>
                      </div>
                  </div>
                </div>
                <!-- end of card -->
              </div>
            </div>
          </div>
          <!-- test area -->
          <div class="flip-card" v-if="isCompleted" >
            <div class="flip-card-inner">
              <div class="flip-card-front" >
                <div class="bigcard" >
                  <div class="bigcardbody" >
                    <img src="https://c.tenor.com/8OJLtN_l5k8AAAAM/wowww-oww.gif" alt="WE DID IT">
                    <div>You got {{correctCounter}}/{{cards.length}} right!</div>
                  </div>
                  <div class="bigcardbottombar" @click="$router.push('/StudySession')" >Click to go back</div>
                </div>
              </div>
            </div>
          </div>
          <!-- test area -->
        </div>
      </cardboxarea>
      <div class="bottomnavbox">
        <div class="bottomnav">
          <div class="left" @click="setCounterToComplete()">
            <i class="fas fa-times leftadjust"></i>End Session 
          </div>
          <div class="precentarea">
            <div clas="progresstext">Progress</div>
            <div class="progressbarbox">
              <div class="w3-border">
                <div class="w3-grey" :style=progress></div>
              </div>
            </div>
            <div class="precenttext">{{progressPercent}}%</div>
          </div>
          <div class="right" @click="incrementCounter()">
            Next Card <i class="fas fa-chevron-right rightadjust"></i>
          </div>
        </div>
      </div>
    </mainapparea>
  </div>
</template>
<script>
import CardService from "@/services/CardService.js";
import DeckService from "@/services/DeckService.js";


export default {
  name: "StudySession",
  data() {
    return {
      cards: Array,
      deckId: this.$route.params.id,
      deck: {
        deckId: "",
        deckName: "",
        deckDescription: "",
        userId: "",
      },
      counter: 0,
      correctCounter: 0,
      incorrectCounter: 0,
      showAnswer: false,
      completedCounter: 0
    };
  },
  components: {
  },
  methods: {
     incrementCounter() {
       if (this.counter == this.cards.length) {
         this.counter = this.cards.length
       } else {
         this.counter++,
       this.showAnswer = false
       }
     },
     incrementCorrectCounter() {
       this.correctCounter++,
       this.showAnswer = false
     },
     incrementIncorrectCounter() {
       this.incorrectCounter++,
       this.showAnswer = false
     },
     toggleShowAnswer() {
       this.showAnswer = !this.showAnswer
     },
     correctAnswer() {
       this.incrementCorrectCounter();
       this.incrementCounter();
       this.toggleShowAnswer();
     },
     incorrectAnswer() {
      this.incrementIncorrectCounter();
      this.incrementCounter();
      this.toggleShowAnswer()
     },
     setCounterToComplete() {
       this.counter = this.cards.length
     },
  },
  computed: {
    currentCard() {
      return this.cards[this.counter]
    },
    progress(){
      return "width: " + this.counter*100/this.cards.length + "%;"
    },
    progressPercent(){
      return Math.round(this.counter*100/this.cards.length)
    },
    isCompleted() {
      return this.cards.length <= this.counter
    }
  },
  created() {
    CardService.getCardByDeck(this.deckId).then((resp) => {
      this.cards = resp.data;
    }),
    DeckService.getDeck(this.deckId).then((resp) => {
      this.deck = resp.data;
    });
  },
};
</script>
<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Warnes&display=swap");
@import url("https://fonts.googleapis.com/css2?family=Faster+One&display=swap");
.decktitle {
  text-align: center;
  color: #333333;
}
.deckdescription {
  text-align: center;
  color: #333333;
}
* {
  margin: 0;
  padding: 0;
}
body {
  font-family: "Poppins", sans-serif;
  background-color: #F7F3E9;
}
/* css for the top nav var */
nav {
  background-color: #5EAAA8;
  color: #fff;
  display: flex;
  justify-content: space-between;
  height: 64px;
  padding: 0px 0px 0px 0px;
  box-shadow: 0 0.3125rem 1rem 0 rgb(0 0 0 / 8%);
  z-index: 300;
}
.logobox {
  display: flex;
  margin: 8px 0px 0px 20px;
}
.logo {
  display: block;
  width: 40px;
  height: 40px;
  font-size: 20pt;
  background: #F7F3E9;
  border-radius: 50%;
  border: 3px solid #A3D2CA;
}
.logowords {
  display: block;
  font-family: "Warnes", cursive;
  font-size: 27pt;
  margin: 2px 0px 0px 5px;
}
.loginbox {
  display: block;
  margin: 10px 20px 0px 0px;
}
.logoadjust {
  margin: 0px 0px 0px 0px;
  color: #F05945;
  margin: 6px 0px 0px 8px;
}
.loginlogo {
  display: block;
  width: 30px;
  height: 30px;
  font-size: 14pt;
  background: #F7F3E9;
  border-radius: 50%;
  border: 3px solid #A3D2CA;
  margin: 5px 0px 0px 3px;
}
.loginwords {
  display: block;
  font-family: Montserrat;
  font-size: 10pt;
  margin: 0px 0px 0px 0px;
  text-align: center;
}
.loginbox {
  display: block;
  margin: 3px 20px 0px 0px;
}
.loginadjust {
  margin: 0px 0px 0px 0px;
  color: #F05945;
  margin: 5px 0px 0px 6px;
}
/* END css for the top nav var */
/*main app area*/
mainapparea {
  display: flex;
  flex-direction: column;
  justify-content: center;
  padding: 0px auto 0px auto;
  background: #F7F3E9;
  /*    padding: 20px;*/
}
/* endmain app area*/
/*font page card styles*/
/*Flash card study styles*/
.leftnav {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  width: 180px;
  min-height: 90vh;
  background: #FFFFFF;
  padding: 10px 0px 40px 0px;
}
.topbox {
  /*    background-color: #ABABAB;*/
  padding: 0px 0px 0px 0px;
}
.buttonlook1 {
  display: flex;
  padding: 10px 0px 15px 20px;
  width: 90%;
  border-bottom: 1px solid #E7EAF7;
}
.buttonlook1:hover {
  color: #FFDD00;
}
.buttonlook2 {
  display: flex;
  margin: 10px 0px 10px 20px;
  padding: 10px;
  width: 70%;
  border: 1px solid #999999;
  border-radius: 5px;
  background-color: #FFDD00;
  color: #333333;
  /*    border-bottom: 1px solid #E7EAF7; */
}
.progressbox {
  padding: 30% 0px 10px 36px;
  background-color: #FFDD00;
}
.progresspercent {
  text-align: center;
  display: block;
  font-size: 20pt;
  padding: 30px 0px 0px 10px;
  margin: 0px 0px 0px 10px;
}
.progresstext {
  display: block;
  font-size: 16pt;
  padding: 36px 0px 0px 0px;
  margin: 0px 0px 0px 4px;
}
.navicon {
  color: #4C0DCC;
}
.navtext {
  padding: 0px 0px 0px 10px;
  color: #4C0DCC;
}
.navtext2 {
  padding: 0px 0px 0px 10px;
  color: #333333;
}
.bottombox {
  padding: 0px 0px 10% 0px;
}
cardboxarea {
  display: flex;
  flex-direction: row;
  justify-content: center;
  padding: 50px 0px 0px 0px;
  width: 100%;
}
.bigcardoutside {
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-content: center;
  margin: 0px auto 0px 20%;
  width: 100%;
  height: 70vh;
}
.bigcard {
  display: flex;
  flex-direction: column;
  justify-content: center;
  height: 50vh;
  background: #A3D2CA;
}
.bigcardbody {
  display: block;
  text-align: center;
  padding: 50px 50px 50px 50px;
  height: 100%;
  color: #333333;
}
.bigcardbottombar {
  background-color: #F05945;
  width: 100%;
  padding: 10px 0px 10px 0px;
  text-align: center;
  color: #FFFFFF;
}
.bigcardbottombar:hover {
  background-color: #f36654;
}
.bigcardbottombarback {
  display: flex;
  flex-direction: row;
}
.questionright {
  width: 50%;
  padding: 10px 0px 10px 0px;
  text-align: center;
  background-color: #5EAAA8;
}
.questionwrong {
  width: 50%;
  padding: 10px 0px 10px 0px;
  text-align: center;
  background-color: #F05945;
}
.questionright:hover{
  background-color: #85bebd;
}
.questionwrong:hover{
  background-color:#f36654; 
}
.bottomnavbox {
  display: flex;
  flex-direction: row;
  margin: 0px auto 0px auto;
  width: 90%;
  justify-content: center;
}
.bottomnav {
  display: flex;
  flex-direction: row;
  flex-wrap: nowrap;
  width: 100%;
  background: #5EAAA8;
  padding: 10px 10px 10px 10px;
  box-shadow: 5px 5px 5px #C0C0C0;
  justify-content: space-between;
  transition: all 0.4s ease;
}
.allbuttons {
  width: 100%;
  display: flex;
  flex-direction: row;
}
.precentarea {
  display: flex;
  justify-content: center;
  width: 70%;
}
.progressitem {
  display: block;
  width: 100px;
}
.progressbar {
  display: block;
  width: 140px;
  height: 20px;
  background-color: #F5F1FC;
  margin: 0px 0px 0px 0px;
  padding: 0px 0px 0px 10px;
  border-left: 60px solid #4C0DCC;
}
.progressbarbox {
  width: 30%;
  margin: 8px 0px 0px 10px;
}
.progresstext {
  margin: 20px 0px 0px 0px;
  color: #333333;
}
.precenttext {
  margin: 0px 0px 0px 20px;
  font-family: "Faster One", cursive;
  color: #333333;
}
.left {
  display: block;
  width: 10%;
  padding: 0px 0px 0px 10px;
  color: #333333;
}
.left:hover {
  color: #F05945 !important;
}
.right {
  display: block;
  padding: 0px 10px 0px 0px;
  color: #333333;
}
.right:hover {
  color: #F05945 !important;
}
.leftadjust {
  margin: 0px 10px 0px 0px;
}
.rightadjust {
  margin: 0px 0px 0px 10px;
}
.w3-border {
  /*    border:1px solid #ccc!important*/
  background: #F5F1FC;
}
.w3-grey {
  color: #000 !important;
  height: 10px;
  background-color: #F05945 !important;
}
/* The flip card container - set the width and height to whatever you want. We have added the border property to demonstrate that the flip itself goes out of the box on hover (remove perspective if you don't want the 3D effect */
.flip-card {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  max-width: 80%;
  height: 50vh;
  background: #F7F3E9;
  padding: 0px 0px 0px 0px;
  box-shadow: 0px 0px 0px #C0C0C0;
  justify-content: center;
  transition: all 0.4s ease;
  perspective: 1000px; /* Remove this if you don't want the 3D effect */
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
/* .flip-card:focus .flip-card-inner {
  transform: rotateY(180deg);
} */
/* Position the front and back side */
.flip-card-front,
.flip-card-back {
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
  /* transform: rotateY(180deg); */
}
.rotate-card{
   transform: rotateY(180deg);
}
</style>