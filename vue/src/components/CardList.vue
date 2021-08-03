<template>
    <div class="cardbox" >
        <div v-for="card in cards" :key="card.cardId">
            <Card :card="card"/>
        </div>
    </div>
</template>


<script>
import Card from "../components/Card"

export default {
    name:'CardList',
    props: {
        cards: Array
    },
    components: {
        Card
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