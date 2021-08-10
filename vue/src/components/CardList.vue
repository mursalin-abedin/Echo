<template>
    <div>
        <div class="upperbar">
            <div class="searchbarbox">
                <input class="inputtext" type="text" v-model="searchbox" placeholder="Enter a keyword to search for cards"> 
                <div class="showallbox" @click="$emit('show-all-cards'); toggleShowAllCardsSelected()">
                    <div :class="showAllCardsSelected ? 'showalliconboxselected' : 'showalliconbox'" >
                         <div :class="showAllCardsSelected ? 'mericaiconselected' : 'mericaicon'"><i class="fas fa-globe-americas"></i></div>
                         <div  :class="showAllCardsSelected ? 'searchiconselected': 'searchicon'"><i class="fas fa-search"></i></div>   
                    </div>
                    <div class="showalltext">Show all</div>
                </div>
            </div>
        </div>
        <div class="cardbox" >
            <NewCard @add-card="repeatAddCard" />
            <div v-for="card in filteredList" :key="card.cardId">
                <Card 
                v-bind="$props"
                :card="card" 
                @edit-card="repeatEditCard"
                @add-card-to-deck="repeatAddCardToDeck"
                @remove-card-from-deck="repeatRemoveCardFromDeck"/>
            </div>
        </div>
    </div>
</template>


<script>
import Card from "../components/Card"
import NewCard from "../components/NewCard"

export default {
    name:'CardList',
    data(){
        return{
            searchbox: '',
            showAllCardsSelected: false
        }
    },
    props: {
        cards: Array,
        ncard: Object,
        currentDeckId: Number
    },
    components: {
        Card,
        NewCard
    },
    methods: {
        repeatAddCard(ncard){
            this.$emit('add-card', ncard)
        },
        repeatEditCard(ncard){
            this.$emit('edit-card', ncard)
        },
        repeatAddCardToDeck(card){
            this.$emit('add-card-to-deck', card)
        },
        repeatRemoveCardFromDeck(card){
            console.log(card)
            console.log("REmove Card from Deck!")
            this.$emit('remove-card-from-deck', card)
            },
        toggleShowAllCardsSelected(){
            this.showAllCardsSelected = !this.showAllCardsSelected
        }
    },
    computed: {
        filteredList(){
        console.log("this")
        if (this.showAllCardsSelected){
            return this.cards.filter(card =>{
            return (card.keywords.toLowerCase().includes(this.searchbox.toLowerCase()))
        })
        }
        return this.cards.filter(card =>{
            return (card.keywords.toLowerCase().includes(this.searchbox.toLowerCase()) && card.deckIds.includes(this.currentDeckId))
        })
    }
    }
}
</script>

<style scoped>
.cardbox{
  display: inline-flex;
  flex-direction: row;
  flex-wrap: wrap;
  margin: 10px 0px 0px 10px;
  width: 100%;
}
.upperbar{
    display: block;
    width: 100%;
    height: 80px;
    background-color: #dcdcdc;
    margin: -2px 0px 0px 0px;
    padding: 0px 0px 0px 0px;
    border-bottom: 1px solid #ababab;
}
.searchbarbox {
    display: flex;
}
.inputtext {
  display: block;
  line-height:24px;
  background: #a0a0a0;
  border-width: 0px;
  border: none;
  border-radius: 5px;
  padding: 5px 20px 5px 20px;
  font-size: 14pt;
  color: #efefef;
  margin: 16px 0px 0px 10px;
  transition: all .5s ease;
  min-width: 80%;

}

.inputtext:focus{
    outline: 0;
    background: #3BA1EF;
}



.showallbox {
    display: block;
    width: 42px;
    height: 30px;
    margin: 12px 0px 0px 20px;

}

.showalliconbox {
    background: #bcbcbc;
    border-radius: 50%;
    border: 1px solid #999999;

}

.showalliconboxselected {
    background: lightgreen;
    border-radius: 50%;
    border: 1px solid #999999;

}

.mericaicon{
    font-size: 18pt;
    padding: 2px 0px 0px 6px;
    color: #efefef;

}

.searchicon {
    font-size: 16pt;
    padding: 0px 0px 0px 0px;
    margin: -32px 0px 0px 15px;
    color: #999999;
}

.searchiconselected {
    font-size: 16pt;
    padding: 0px 0px 0px 0px;
    margin: -32px 0px 0px 15px;
    color: black;
}

.mericaiconselected {
    font-size: 18pt;
    padding: 2px 0px 0px 6px;
    color: darkgrey;

}


.showalltext{
    margin: 0px 0px 0px -4px;
    font-size: 10pt;
    width: 60px;
    color: #666666
}


</style>