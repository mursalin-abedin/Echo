<template>
  <div v-on:click="showCards">
      <div>
          <router-link :to="{
              name: 'decks-cards',
              params: {
                  deckId: deck.deckId
              }
          }">

          </router-link>
      </div>
  </div>
</template>

<script>

export default {
    name: 'deck',
    data() {
        return{

        }
    },
    props:{
        deck: Object
    },
    methods: {
        showCards(){
            this.$router.push({
                name: 'decks-cards',
                params:{
                    deckId: this.deck.deckId
                }
            })
        }
    }
};
</script>

<style>

</style>