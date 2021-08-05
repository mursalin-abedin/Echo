<template>
  <div class="decklist">
    <div class="echo">
      <div class="icon"><i class="fas fa-user-astronaut echoicon"></i></div>
      <div class="echotext">Echo</div>
    </div>

    <div>
      <div :class="selectedDeck == 0 ? 'deckbuttonselected' : 'deckbutton'"
      @click="$emit('show-new-deck-form'); clearSelectedDeck();">
        <div class="deckicon"><i class="fas fa-plus-circle"></i></div>
        <div class="deck">Add New Deck</div>
      </div>
    </div>
    <div v-for="deck in decks" :key="deck.deckId">
      <div
        :class="selectedDeck == deck.deckId ? 'deckbuttonselected' : 'deckbutton'"
        @click="$emit('get-deck', deck.deckId); setSelectedDeck(deck.deckId);"
      >
        <div class="deckicon"><i class="fas fa-layer-group"></i></div>
        <div class="deck">{{ deck.deckName }}</div>
      </div>
    </div>
  </div>
</template>


<script>
export default {
  data() {
    return {
      selectedDeck: 0,
    };
  },
  name: "DeckList",
  props: {
    decks: Array,
  },
  components: {},
  methods: {
    setSelectedDeck(deckId) {
      this.selectedDeck = deckId;
    },
    clearSelectedDeck() {
      this.selectedDeck = 0;
    },
  },
};
</script>

<style scoped>
.decklist {
  display: flex;
  flex-direction: column;
  min-width: 300px;
  background-color: #108cee;
  height: 100vh;
}

.deckbutton {
  display: flex;
  background: #108cee;
  margin: 0px auto 0px auto;
  vertical-align: middle;
  border-bottom: 1px solid white;
}

.deckbuttonselected {
  display: flex;
  background: lightgreen;
  margin: 0px auto 0px auto;
  vertical-align: middle;
  border-bottom: 1px solid white;
}

.deckicon {
  padding: 10px;
  color: #9fccef;
}

.deck {
  display: block;
  font-size: 12pt;
  padding: 10px;
}

.deckbutton:hover {
  background-color: #4fa7eb;
}

.echoicon {
  margin: 10px 0px 0px 0px;
}

.fa-plus-circle {
    color: lightgreen;
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

.echo {
  display: flex;
  border-bottom: 1px solid white;
}

.echotext {
  margin: 10px 0px 10px 10px;
  font-size: 30pt;
  font-weight: 700;
  color: #e0e0e0;
}
</style>