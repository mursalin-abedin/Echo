<template>
 <body>
<TopNavBar/>
<div class="mainapparea">   
<AdminAddDeckBanner/>
<DisplayAndEditDecks
    :decks="decks"
    :currentDeckId="currentDeckId"
    @add-deck="addNewDeck"
    @edit-deck="editDeck"
    @get-deck="getDeck"/>
<DisplayAndEditCards 
    :cards="cards"
    :currentDeckName = "currentDeck.deckName"
    :currentDeckId="currentDeckId"
    @add-new-card="addNewCard"
    @edit-card="editCard"
    @add-card-to-deck="addCardToDeck"
    @remove-card-from-deck="removeCardFromDeck"/>
</div>
</body>
</template>

<script>
import TopNavBar from './TopNavBar'
import AdminAddDeckBanner from './AdminAddDeckBanner'
import DisplayAndEditDecks from './DisplayAndEditDecks'
import DisplayAndEditCards from './DisplayAndEditCards'
import DeckService from '@/services/DeckService.js'
import CardService from '@/services/CardService.js'

export default {
    name: 'Admin',
    components: {
        TopNavBar,
        AdminAddDeckBanner,
        DisplayAndEditDecks,
        DisplayAndEditCards,
    },
    data() {
    return {
      decks: [],
      cards: [],
      currentDeckId: 0,
      showAllCardsSelected: false,
      showEditDeckFormSelected: false,
      currentDeck: ''
    };
  },
  methods: {
      addNewDeck(ndeck) {
      DeckService.createNewDeck(ndeck).then((resp) => {
        console.log(resp);
        DeckService.getAllDecks().then((resp) => {
          this.decks = resp.data;
        });
      });
    },
     getDeck(deck) {
      this.currentDeckId = deck.deckId;
      this.currentDeck = deck;
    },
    addNewCard(ncard, deckId) {
      ncard.deckId = deckId
      CardService.createCard(ncard).then((resp) => {
        console.log(resp);
        CardService.getAllCards().then((resp) => {
          this.cards = resp.data;
        });
      });
    },
    addCardToDeck(ncard, deckId){
      DeckService.addCardToDeck(ncard, deckId).then((resp) => {
        console.log(resp);
        CardService.getAllCards().then((resp) => {
          this.cards = resp.data;
        });
      });
    },
    removeCardFromDeck(ncard){
      DeckService.removeCardFromDeck(ncard, this.currentDeckId).then((resp) => {
        console.log(resp);
        CardService.getAllCards().then((resp) => {
          this.cards = resp.data;
        });
      });
    },
    editDeck(editdeck){
      console.log(editdeck)
        DeckService.modifyDeck(this.currentDeckId, editdeck).then((resp) => {
         console.log(resp);
        DeckService.getAllDecks().then((resp) => {
          this.decks = resp.data;
        });
      });
    },
     editCard(ncard) {
       console.log(ncard)
      CardService.editCard(ncard).then((resp) => {
        console.log(resp);
        CardService.getAllCards().then((resp) => {
          this.cards = resp.data;
        });
      });
    },
    onDrop(event){
      console.log(event)
    }
  },
  created() {
    DeckService.getAllDecks().then((resp) => {
      this.decks = resp.data;
    });
    CardService.getAllCards().then((resp) => {
      this.cards = resp.data;
    });
  },
}
</script>

<style scoped>

* {
  margin: 0;
  padding: 0;
}

body {
  font-family: "Poppins", sans-serif;
  background-color: #F7F3E9;
}

.mainapparea {
    display: flex;
    flex-direction: row;
    justify-content: center;
    flex-wrap: wrap;
    padding: 20px;
    
}

</style>