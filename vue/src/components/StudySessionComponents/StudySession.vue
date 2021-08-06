<template>
  <div>
    <div class="header">
      <div class="icon" @click="$router.push('/')"><i class="fas fa-user-astronaut echoicon"></i></div>
      <div class="echotext">Echo</div>
      <div class="CardTitle">
        <div class="studySession">
            <div class="decktitle" :v-for="decks.slice(this.deckId)">Studying For: ~Current Deck~ </div>
            <div class="studycard">Current Study Card! </div>
        </div>
      </div>
    </div>
    
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
      decks: Array,
    };
  },
  components:{
      
  },
  created() {
    CardService.getCardByDeck(this.deckId).then((resp) => {
      this.cards = resp.data;
    }),
    DeckService.getAllDecks().then((resp) => {
      this.decks = resp.data
    });
  },
};
</script>

<style>
.studySession{
    margin-top: 120px;
    display:flex;
    justify-content: center;
    flex-direction: column;
}
.studycard{
    height: 400px;
    width: 600px;
    background: lightgray;
    display: flex;
    justify-content: center;
    align-items: center;
    border-radius: 10px;

}
.header {
  display: flex;
  flex-direction: row;
  width: 100%;
  height: 80px;
  position: absolute;
  margin-bottom: 20pt;
  background-color: #108cee;
}
.icon {
  color: #ff9201;
  text-align: center;

  display: block;

  font-size: 20pt;

  padding: 0px 0px 0px 0px;
  margin: 15px 0px 0px 10px;

  width: 50px;
  height: 50px;

  background-color: #e0e0e0;
  border: 1px solid #666666;
  border-radius: 50%;
}
.echotext {
  margin: 10px 0px 10px 10px;
  font-size: 30pt;
  font-weight: 700;
  color: #e0e0e0;
}
</style>