<template>
<<<<<<< Updated upstream
  <div class="mainappbody">
    <Nav />
    <DeckList :decks="decks" @add-new-deck="addNewDeck" @get-deck="getDeck" />
    <CardList :cards="cards" />
  </div>
</template>

<script>
import Nav from "../components/Nav";
import DeckList from "../components/DeckList";
import CardList from "../components/CardList";
import DeckService from "../services/DeckService";
import CardService from "../services/CardService";

export default {
  name: "Home",
  components: {
    DeckList,
    CardList,
    Nav,
  },
  data() {
    return {
      decks: [],
      cards: [],
    };
  },
  methods: {
    getDeck(deckId) {
      CardService.getCardByDeck(deckId).then((resp) => {
        this.cards = resp.data;
      });
    },
    addNewDeck() {
      CardService.createCard().then((resp) => {
        console.log(resp);
      });
    },
  },
  created() {
    DeckService.getAllDecks().then((resp) => {
      this.decks = resp.data;
    });
  },
};
=======
    <div class="mainappbody">
        <DeckList :decks="decks" 
            @add-new-deck="addNewDeck" 
            @get-deck="getDeck" 
        />
        <CardList :cards="cards" @add-card="addNewCard" />
    </div>
</template>

<script>
    import DeckList from '../components/DeckList'
    import CardList from '../components/CardList'
    import DeckService from '../services/DeckService'
    import CardService from '../services/CardService'

    export default {
        name: 'Home',
        components: {
            DeckList,
            CardList
        },
        data(){
            return {
                decks: [],
                cards: []
            }
        },
        methods:{
            getDeck(deckId){
                CardService.getCardByDeck(deckId).then(resp => {
                    this.cards = resp.data
                })
            },
            addNewDeck(){
                console.log("Add New Deck!!")
            },
            addNewCard(newCard){
                CardService.createCard(newCard).then(resp => {
                    console.log(resp);
           });
            }
        },
        created(){
           DeckService.getAllDecks().then(resp => {
               this.decks = resp.data
           });
        }

        
    }
>>>>>>> Stashed changes
</script>

<style scoped>
.mainappbody {
  display: flex;
}
</style>