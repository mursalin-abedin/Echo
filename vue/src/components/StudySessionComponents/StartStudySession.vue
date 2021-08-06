<template>
  <div>
    <div class="header">
      <div class="icon"><i class="fas fa-user-astronaut echoicon"></i></div>
      <div class="echotext">Echo</div>
    </div>
    <div class="page">
      <div class="pleasework">
        <h1>Select a deck to study from!</h1>
      </div>
      <div class="decks">
        <div v-for="deck in decks" :key="deck.deckId" v-on:click={}>
          <div class="deck">
            <div class="deckname">{{ deck.deckName }}</div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import DeckService from "@/services/DeckService";
export default {
  data() {
    return {
      decks: Array,
    };
  },
  methods: {},
  created() {
    DeckService.getAllDecks().then((resp) => {
      this.decks = resp.data;
    });
  },
};
</script>

<style scoped>

.decks {
  margin-top: 190px;
  display: inline-flex;
  justify-content: center;
  width: 100%;
  flex-direction: row;
  flex-wrap: wrap;
}

.deck {
  display: block;
  background-color: lightgray;
  width: 300px;
  height: 300px;
  border: 2px solid darkgray;
  margin: 15px 30px;
  border-radius: 10px;

  display: flex;
  justify-content: center;

  box-shadow: 10px 5px 5px darkgray;
}

.deckname {
  margin-top: 15px;
  font-family: Arial, Helvetica, sans-serif;
  font-size: 30pt;
  text-align: center;
}

.pleasework {
  margin-top: 81px;
  text-align: center;
  width: auto;
  display: flex;
  width: 100%;
  display: flex;
  justify-content: center;
  position: absolute;
  font-size: 14pt;
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