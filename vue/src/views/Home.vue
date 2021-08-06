<template>
  <div class="mainappbody">
    <DeckList
      :decks="decks"
      @show-new-deck-form="showAddNewDeckForm"
      @get-deck="getDeck"
      @show-edit-deck="showEditDeckForm"
    />

    <div class="rightside">
      <Header />
      <div class="centerpage">
        <EditDeckForm 
        v-if="showEditDeckFormSelected && currentDeckId" 
        :deck="currentDeck"
        @submit-edit-deck="editDeck"/> 
        <AddDeckForm v-if="!currentDeckId" @add-deck="addNewDeck" />
        <CardList
          class="cardlistbox"
          v-if="currentDeckId && !showEditDeckFormSelected"
          :cards="cards"
          :currentDeckId="this.currentDeckId"
          @add-card="addNewCard"
          @edit-card="editCard"
          @show-all-cards="toggleShowAllCardsSelected()"
          @add-card-to-deck="addCardToDeck"
          @remove-card-from-deck="removeCardFromDeck"
        />
      </div>
    </div>
  </div>
</template>

<script>
import DeckList from "../components/DeckList";
import CardList from "../components/CardList";
import DeckService from "../services/DeckService";
import CardService from "../services/CardService";
import AddDeckForm from "../components/AddDeckForm";
import EditDeckForm from "../components/EditDeckForm"
import Header from "../components/Header";

export default {
  name: "Home",
  components: {
    DeckList,
    CardList,
    AddDeckForm,
    EditDeckForm,
    Header,
  },
  data() {
    return {
      decks: [],
      cards: [],
      currentDeckId: "",
      showAllCardsSelected: false,
      showEditDeckFormSelected: false,
      currentDeck: ""
    };
  },
  methods: {
    getDeck(deck) {
      this.currentDeckId = deck.deckId;
      this.currentDeck = deck;
    },
    showAddNewDeckForm() {
      this.currentDeckId = "";
    },
    showEditDeckForm(){
        this.showEditDeckFormSelected = !this.showEditDeckFormSelected
    },
    editDeck(editdeck){
        DeckService.modifyDeck(this.currentDeckId, editdeck).then((resp) => {
         console.log(resp);
        DeckService.getAllDecks().then((resp) => {
          this.decks = resp.data;
        });
      });
    },
    addNewDeck(ndeck) {
      DeckService.createNewDeck(ndeck).then((resp) => {
        console.log(resp);
        DeckService.getAllDecks().then((resp) => {
          this.decks = resp.data;
        });
      });
    },
    addNewCard(ncard) {
      ncard.deckId = this.currentDeckId;
      CardService.createCard(ncard).then((resp) => {
        console.log(resp);
        this.getDeck(this.currentDeckId);
        CardService.getAllCards().then((resp) => {
          this.cards = resp.data;
        });
      });
    },
    editCard(ncard) {
      CardService.editCard(ncard).then((resp) => {
        console.log(resp);
        CardService.getAllCards().then((resp) => {
          this.cards = resp.data;
        });
      });
    },
    // showAllCards() {
    //   CardService.getAllCards().then((resp) => {
    //     this.cards = resp.data;
    //   });
    // },
    toggleShowAllCardsSelected() {
      this.showAllCardsSelected = !this.showAllCardsSelected;
    },
    addCardToDeck(card) {
      console.log("created", card);
      DeckService.addCardToDeck(card, this.currentDeckId).then((resp) => {
        console.log(resp);
        CardService.getAllCards().then((resp) => {
          this.cards = resp.data;
        });
      });
    },
    removeCardFromDeck(card) {
      console.log(card);
      DeckService.removeCardFromDeck(card, this.currentDeckId).then((resp) => {
        console.log(resp);
        CardService.getAllCards().then((resp) => {
          this.cards = resp.data;
        });
      });
    },
  },
  created() {
    DeckService.getAllDecks().then((resp) => {
      this.decks = resp.data;
    });
    CardService.getAllCards().then((resp) => {
      this.cards = resp.data;
    });
  },
};
</script>

<style scoped>
.mainappbody {
  display: flex;
  width: 100%;
}
.rightside {
  display: block;
  width: 100%;
}
.centerpage {
  width: 100%;
  margin-top: 82px;
}

.cardlistbox {
  display: block;
  width: 100%;
}
</style>