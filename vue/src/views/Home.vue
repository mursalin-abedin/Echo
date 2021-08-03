<template>
    <div class="mainappbody">
        <Nav />
        <Decklist :decks="decks" 
            @add-new-deck="addNewDeck" 
            @get-deck="getDeck" 
        />
        <Cards :cards="cards" />
    </div>
</template>

<script>
    import Nav from '../components/Nav'
    import Decklist from '../components/Decklist'
    import Cards from '../components/Cards'
    import DeckService from '../services/DeckService'
    import CardService from '../services/CardService'

    export default {
        name: 'Home',
        components: {
            Decklist,
            Cards,
            Nav
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