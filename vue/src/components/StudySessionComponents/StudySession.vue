<template>
  
</template>

<script>
import CardService from '@/services/CardService.js'
export default {
    data(){
        return{
            cards: Array
        }
    },
    created(){
        CardService.getCardByDeck().then((resp) => {
      this.cards = resp.data;
    });
    }
}
</script>

<style>

</style>