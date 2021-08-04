<template>
    <div class="mainappbody">
        <DeckList :decks="decks" 
            @add-new-deck="addNewDeck" 
            @get-deck="getDeck" 
        />
        <CardList :cards="cards" @add-card="addNewCard" :deckSelected="currentDeckId>0" />
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
                cards: [],
                currentDeckId: '',
            }
        },
        methods:{
            getDeck(deckId){
                this.currentDeckId = deckId
                CardService.getCardByDeck(deckId).then(resp => {
                    this.cards = resp.data
                })
            },
            addNewDeck(){
                console.log("Add New Deck!!")
            },
            addNewCard(ncard){
                ncard.deckId = this.currentDeckId
                console.log("NCARD:" + ncard)
                CardService.createCard(ncard).then(resp => {
                    console.log(resp);
           });
            this.getDeck(this.currentDeckId)
            }
        },
        created(){
           DeckService.getAllDecks().then(resp => {
               this.decks = resp.data
           });
        }

        
    }
</script>

<style scoped>
.mainappbody {
  display: flex;
}
</style>