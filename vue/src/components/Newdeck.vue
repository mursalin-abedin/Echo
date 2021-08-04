<template>
    <div>
        <div class="deckbutton" @click="$emit('show-new-deck-form')">
        <i class="fas fa-plus-circle"></i>
        <div class="deck" > Add New Deck</div>
        </div>
    </div>
</template>


<script>


export default {
    name:'Newdeck',
    props: {

    },
    components: {

    }
}
</script>

<style scoped>

.deckbutton {
    display: flex;
    background: #108cee;
    margin: 0px auto 0px auto;
    vertical-align: middle;
    border-bottom: 1px solid white

}


.decklist {
    display: flex;
    flex-direction: column;
    min-width: 200px;
    min-height: 800px;
    background-color: #108cee
}

.deck {
    display: block;
    font-size: 12pt;
    padding: 10px;
}


.deckbutton:hover{
    background-color:  #4FA7EB;
}


.fa-plus-circle{
    padding: 10px;
    color: #00E100;
}

</style>