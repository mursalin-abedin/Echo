<template>
    <div class="mainappbody">
        <Nav />
        <DeckList :decks="decks" 
            @add-new-deck="addNewDeck" 
            @get-deck="getDeck" 
        />
        <CardList :cards="cards" />
    </div>
</template>

<script>
    import Nav from '../components/Nav'
    import DeckList from '../components/DeckList'
    import CardList from '../components/CardList'
    import DeckService from '../services/DeckService'
    import CardService from '../services/CardService'

    export default {
        name: 'Home',
        components: {
            DeckList,
            CardList,
            Nav
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
                CardService.getAllCards().then(resp => {
               this.cards = resp.data
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
.mainappbody{
    display: flex;
}
</style>