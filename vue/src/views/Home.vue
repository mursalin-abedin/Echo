<template>
    <div class="mainappbody">
        <DeckList :decks="decks" 
            @show-new-deck-form="showAddNewDeckForm" 
            @get-deck="getDeck" 
        />
        <AddDeckForm v-if="!currentDeckId"
            @add-deck="addNewDeck" />
        <CardList v-if="currentDeckId" :cards="cards" @add-card="addNewCard" />
    </div>
</template>

<script>
    import DeckList from '../components/DeckList'
    import CardList from '../components/CardList'
    import DeckService from '../services/DeckService'
    import CardService from '../services/CardService'
    import AddDeckForm from '../components/AddDeckForm'

    export default {
        name: 'Home',
        components: {
            DeckList,
            CardList,
            AddDeckForm
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
            showAddNewDeckForm(){
                this.currentDeckId = ''
            },
            addNewDeck(ndeck){
                console.log("Add New Deck!!")
                DeckService.createNewDeck(ndeck).then(resp => {
                    console.log(resp)
                      DeckService.getAllDecks().then(resp => {
                     this.decks = resp.data
           });
                })
              
            },
            addNewCard(ncard){
                ncard.deckId = this.currentDeckId
                console.log("NCARD:" + ncard)
                CardService.createCard(ncard).then(resp => {
                    console.log(resp)
                    this.getDeck(this.currentDeckId)
           });
           
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