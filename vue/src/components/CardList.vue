<template>
  <div>
  </div>
</template>

<script>
import CardService from '@/services/CardService'
export default {
    components: {

    },
    computed:{
        filteredCards(){
            const filter = this.$store.state.cards;
            return filter;
        }
    },
    methods:{
        getAllCards(){
        CardService.getAllCards();
        }
    },
    created() {
        this.getAllCards();
    }
}
</script>

<style>

</style>