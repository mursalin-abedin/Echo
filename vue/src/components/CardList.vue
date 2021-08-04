<template>
    <div class="cardbox" >
        <NewCard v-if="deckSelected" @add-card="repeatCard" />
        <div v-for="card in cards" :key="card.cardId">
            <Card :card="card"/>
        </div>
    </div>
</template>


<script>
import Card from "../components/Card"
import NewCard from "../components/NewCard"

export default {
    name:'CardList',
    props: {
        cards: Array,
        ncard: Object,
        deckSelected: Boolean
    },
    components: {
        Card,
        NewCard
    },
    methods: {
        repeatCard(ncard){
            this.$emit('add-card', ncard)
        }
    }
}
</script>

<style scoped>
.cardbox{
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  margin: 0px 20px 0px 20px;
}


</style>