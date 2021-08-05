<template>
  <div class="mainappbody">
    <DeckList
      :decks="decks"
      @show-new-deck-form="showAddNewDeckForm"
      @get-deck="getDeck"
    />

    <div class="rightside">
      <Header />
      <div class="centerpage">
        <AddDeckForm v-if="!currentDeckId" @add-deck="addNewDeck" />
        <CardList
          class="cardlistbox"
          v-if="currentDeckId"
          :cards="cards"
          :currentDeckId="this.currentDeckId"
          @add-card="addNewCard"
          @edit-card="editCard"
          @show-all-cards="
            toggleShowAllCardsSelected();
            toggleShowAllCards();
          "
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
import Header from "../components/Header";

export default {
  name: "Home",
  components: {
    DeckList,
    CardList,
    AddDeckForm,
    Header,
  },
  data() {
    return {
      decks: [],
      cards: [],
      currentDeckId: "",
      showAllCardsSelected: false,
    };
  },
  methods: {
    getDeck(deckId) {
      this.currentDeckId = deckId;
      CardService.getCardByDeck(deckId).then((resp) => {
        this.cards = resp.data;
      });
    },
    showAddNewDeckForm() {
      this.currentDeckId = "";
    },
    addNewDeck(ndeck) {
      console.log("Add New Deck!!");
      DeckService.createNewDeck(ndeck).then((resp) => {
        console.log(resp);
        DeckService.getAllDecks().then((resp) => {
          this.decks = resp.data;
        });
      });
    },
    addNewCard(ncard) {
      ncard.deckId = this.currentDeckId;
      console.log("NCARD:" + ncard);
      CardService.createCard(ncard).then((resp) => {
        console.log(resp);
        this.getDeck(this.currentDeckId);
      });
    },
    editCard(ncard) {
      console.log("NCARD:" + ncard);
      CardService.editCard(ncard).then((resp) => {
        console.log(resp);
        this.getDeck(this.currentDeckId);
      });
    },
    showAllCards() {
      CardService.getAllCards().then((resp) => {
        this.cards = resp.data;
      });
    },
    toggleShowAllCards() {
      if (this.showAllCardsSelected) {
        CardService.getCardsNotInCurrentDeck(this.currentDeckId).then((resp) => {

          this.cards = this.cards.concat(resp.data);
        });
        console.log("This is firing!! Show All Cards!");
      } else {
        CardService.getCardByDeck(this.currentDeckId).then((resp) => {
          this.cards = resp.data;
        });
        console.log("ShowSelectedDeck!");
      }
    },
    toggleShowAllCardsSelected() {
      this.showAllCardsSelected = !this.showAllCardsSelected;
    },
  },
  created() {
    DeckService.getAllDecks().then((resp) => {
      this.decks = resp.data;
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