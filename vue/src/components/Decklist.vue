<template>

    <div class="decklist">
        <div class="echo"><div class="icon"><i class="fas fa-user-astronaut echoicon"></i></div><div class="echotext">Echo</div></div>
        <NewDeck @add-new-deck="$emit('add-new-deck')" />
        <div v-for="deck in decks" :key="deck.deckId">
            <div class="deckbutton">
                <div class="deckicon"><i class="fas fa-layer-group"></i></div>
                <div class="deck" @click="$emit('get-deck', deck.deckId)">{{deck.deckName}}</div>
            </div>
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
    min-width: 200px;
    min-height: 800px;
    background-color: #108cee
}

.deckbutton {
    display: flex;
    background: #108cee;
    margin: 0px auto 0px auto;
    vertical-align: middle;
    border-bottom: 1px solid white

}

.deckicon {
  padding: 10px;
  color:#9FCCEF;
}

.deck {
    display: block;
    font-size: 12pt;
    padding: 10px;

}

.deckbutton:hover{
    background-color:  #4FA7EB;
}

.echoicon{
    margin: 10px 0px 0px 0px;
}

.icon{
    color: #FF9201;
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

.echo{
    display: flex;
    border-bottom: 1px solid white;
}

.echotext{
    margin: 10px 0px 10px 10px;
    font-size: 30pt;
    font-weight: 700;
    color: #e0e0e0;
}

</style>