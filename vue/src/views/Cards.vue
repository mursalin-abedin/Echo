<template>
  <div class="cards"> 
    <card-list class="card"/>
  </div>
</template>

<script>
import CardList from '../components/CardList.vue'
export default {
  components: { CardList },
  return(){

  }
}
</script>

<style>
  .card{
    border: 2px solid black;
    height: 150px;
    width: 120px;
    text-align: center;
    border-radius: 5px;
  }
</style>