<template>
    <div class="decklist">
        <NewDeck @add-new-deck="$emit('add-new-deck')" />
        <div v-for="deck in decks" :key="deck.deckId">
            <div class="deck" @click="$emit('get-deck', deck.deckId)">{{deck.deckName}}</div>
        </div>
    </div>
</template>


<script>
import NewDeck from '../components/NewDeck'

export default {
    name:'DeckList',
    props: {
        decks: Array
    },
    components: {
        NewDeck
    }
}
</script>

<style scoped>

.decklist {
    display: flex;
    flex-direction: column;
    width: 200px;
    min-height: 800px;
    background-color: #dce3ed;
}

.deck {
    display: block;
    font-size: 16pt;
    padding: 10px

}

.deck:hover{
    background-color: #d8effd;
}

</style>