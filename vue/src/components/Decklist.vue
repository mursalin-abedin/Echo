<template>
    <div class="decklist">
        <Newdeck @add-new-deck="$emit('add-new-deck')" />
        <div v-for="deck in decks" :key="deck.deckId">
            <div class="deck" @click="$emit('get-deck', deck.deckId)">{{deck.deckName}}</div>
        </div>
    </div>
</template>


<script>
import Newdeck from '../components/Newdeck'

export default {
    name:'Decklist',
    props: {
        decks: Array
    },
    components: {
        Newdeck
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