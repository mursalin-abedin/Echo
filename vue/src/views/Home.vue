<template>
    <div class="mainappbody">
        <Decklist :decks="decks" 
            @add-new-deck="addNewDeck" 
            @get-deck="getDeck" 
        />
        <Cards :cards="cards" />
    </div>
</template>

<script>
    import Decklist from '../components/Decklist'
    import Cards from '../components/Cards'
    import DeckService from '../services/DeckService'
    import CardService from '../services/CardService'

    export default {
        name: 'Home',
        components: {
            Decklist,
            Cards
        },
        data(){
            return {
                decks: [],
                cards: []
            }
        },
        created(){
           DeckService.getAllDecks().then(resp => {
               this.decks = resp.data
           });
           CardService.getAllCards().then(resp => {
               this.cards = resp.data
           });
        
        }

        
    }
</script>

<style scoped>
.mainappbody{
    display: flex;
}
</style>