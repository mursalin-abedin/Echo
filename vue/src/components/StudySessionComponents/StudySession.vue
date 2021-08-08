<template>

<div>

<Nav>
    <div class="logobox"  @click="$router.push('/')">
        <div class="logo">
            <i class="fas fa-user-astronaut logoadjust"></i>
        </div>
        <div class="logowords">
            Echo
        </div>
    </div>
    
    <div class="loginbox">
        <div class="loginlogo">
            <i class="fas fa-sign-in-alt loginadjust"></i>
        </div>
        <div class="loginwords">
            Log in
        </div>
    </div>
</Nav>
    
    
<mainapparea>

  <div class="decktitle">Studying For: {{deck.deckName}} </div>
  <div class="deckdescription">{{deck.deckDescription}}</div>
    
<cardboxarea>
   <div class="bigcardoutside">
      
    
   <div class="flip-card">
  <div class="flip-card-inner">
    <div class="flip-card-front">
<!-- front of card -->
          <div class="bigcard">
            <div class="bigcardbody">
                This is a allot of text that is a question about something, and the anser will be on the other side this card.
            </div>
            <div class="bigcardbottombar">
                click here to see answer
            </div>
        </div>   
        
<!-- end of card -->        
    </div>
    <div class="flip-card-back">
<!-- back of card -->
       
        <div class="bigcard">
            <div class="bigcardbody">
                This is the answeer to all of lifes questions.
            </div>
            <div class="bigcardbottombarback">
                <div class="questionwrong"> Wrong Answer</div>
                <div class="questionright"> Correct Answer</div>
            </div>
        </div>
        
        
<!-- back of card -->  
    </div>
  </div>
</div>  
  </div>
</cardboxarea>
    
    <div class="bottomnavbox">
            <div class="bottomnav">
            
            <div class="left"><i class="fas fa-chevron-left leftadjust"></i>Back</div>
            <div class="precentarea">
                <div clas="progresstext">Progress</div>
                <div class="progressbarbox"> 
                <div class="w3-border">
                  <div class="w3-grey" style="width:50%"></div>
                </div>
                </div>
                <div class="precenttext">50%</div>
            </div>
            
            <div class="right">Next Card <i class="fas fa-chevron-right rightadjust"></i></div>
        </div>  
    </div>
</mainapparea>    
    
    
    
</div>
</template>

<script>
import CardService from "@/services/CardService.js";
import DeckService from "@/services/DeckService.js"
export default {
  name: "StudySession",
  data() {
    return {
      cards: Array,
      deckId: this.$route.params.id,
      deck: {
        deckId: '',
        deckName: '',
        deckDescription: '',
        userId: '',
      },
    };
  },
  components:{
      // currentDeck(){
      //   this.deck = this.decks[this.deckId - 1];
      // }
  },
  methods: {},
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

.decktitle{
  text-align: center;
}
.deckdescription{
  text-align: center;
}


* {
  margin: 0;
  padding: 0;
}

body {
  font-family: "Poppins", sans-serif;
  background-color: #E7EAF7;
}


/* css for the top nav var */

nav {
    background-color: #650acb;
    color: #fff;
    display: flex;
    justify-content: space-between;
    height: 64px;;
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
    background: #efefef;
    border-radius: 50%;
    border: 3px solid #666666;
}

.logowords {
    display: block;
    font-family: Montserrat;
    font-size: 27pt;
    margin: 2px 0px 0px 5px;
}

.loginbox {
    display: block;
    margin: 10px 20px 0px 0px;
}

.logoadjust
{
    margin: 0px 0px 0px 0px;
    color: #8C4ED2;
    margin: 6px 0px 0px 8px;
}

.loginlogo {
    display: block;
    width: 30px;
    height: 30px;
    font-size: 14pt;
    background: #efefef;
    border-radius: 50%;
    border: 3px solid #666666;
    margin: 5px 0px 0px 3px;
}

.loginwords {
    display: block;
    font-family: Montserrat;
    font-size: 10pt;
    margin: 0px 0px 0px 0px;
}

.loginbox {
    display: block;
    margin: 3px 20px 0px 0px;
}

.loginadjust
{
    margin: 0px 0px 0px 0px;
    color: #8C4ED2;
    margin: 5px 0px 0px 6px;
}

/* END css for the top nav var */

/*main app area*/

mainapparea {
    display: flex;
    flex-direction: column;
    justify-content: center;
    padding: 0px auto 0px auto;
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
    background: #ffffff;
    padding: 10px 0px 40px 0px;
    
}

.topbox{
/*    background-color: #ababab;*/
    padding: 0px 0px 0px 0px;
        
}

.buttonlook1 {
    display: flex;
    padding: 10px 0px 15px 20px;
    width: 90%;
    border-bottom: 1px solid #E7EAF7; 
}

.buttonlook1:hover {
    color: #FFDD00
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


.bottombox{
    padding: 0px 0px 10% 0px;
}

cardboxarea {
    display: flex;
    flex-direction: row;
    justify-content: center;
    
    padding: 50px 0px 0px 0px;
    width: 100%%;    
}


.bigcardoutside {
    display: flex;
    flex-direction: column;
    justify-content:flex-start;
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
    background: #ffffff;
    

}

.bigcardbody {
    display: block;
    text-align: center;
    padding: 50px 50px 50px 50px;
    height: 100%;
    color: #333333;
}

.bigcardbottombar {
    background-color: #4C0DCC;
    width: 100%;
    padding: 10px 0px 10px 0px;
    text-align: center;
    color: #ffffff;
}

.bigcardbottombar:hover {
    background-color: #7B50D3;
}

.bigcardbottombarback {
    display: flex;
    flex-direction: row;
}

.questionright {
    width: 50%;
    padding: 10px 0px 10px 0px;
    text-align: center;
    background-color: #439B00;
}

.questionwrong {
    width: 50%;
    padding: 10px 0px 10px 0px;
    text-align: center;
    background-color: #EF0044; 
}

.bottomnavbox{
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
    
    
    background: #ffffff;
    
    padding: 10px 10px 10px 10px;
    box-shadow: 5px 5px 5px #c0c0c0;
    justify-content: space-between;
    transition: all .4s ease;
}

.allbuttons {
    width: 100%;
    display: flex;
    flex-direction: row
}

.precentarea {
    display: flex;
    justify-content: center;
    width: 70%
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
    color: #666666;
}

.precenttext{
    margin: 0px 0px 0px 20px;
    color: #666666;
}

.left{
    display: block;
    width: 10%;
    padding: 0px 0px 0px 10px;
}

.left:hover {
    color:#4C0DCC!important
}

.right {
    display: block;
    padding: 0px 10px 0px 0px;
}

.right:hover {
    color:#4C0DCC!important
}

.leftadjust{
    margin: 0px 10px 0px 0px;
}

.rightadjust{
    margin: 0px 0px 0px 10px;
}

.w3-border{
/*    border:1px solid #ccc!important*/
    background: #F5F1FC;
        
}

.w3-grey
{ 
    
    color:#000!important;
        height: 10px;
    background-color:#4C0DCC!important;
}



/* The flip card container - set the width and height to whatever you want. We have added the border property to demonstrate that the flip itself goes out of the box on hover (remove perspective if you don't want the 3D effect */
.flip-card {
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    max-width: 80%;
    height: 50vh;
    background: #e7eaf7;
    
    padding: 0px 0px 0px 0px;
    box-shadow: 0px 0px 0px #c0c0c0;
    justify-content: center;
    transition: all .4s ease;
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

</style>