<template>
  <div @click="isToggle = !isToggle" v-bind:style="{backgroundColor: colorFront,color:colorTextFront}" v-show="!isToggle" class="animated flip">
<!-- class for team to edit-->
<h1>TEST</h1>
    <div class="card-content">
      <p v-bind="card.id">{{ front }}</p>
    </div>

    <div class="card-content">
      <p v-bind="card.id">{{ back }}</p>
    </div>
  </div>
</template>

<script>
export default {
    name: 'card',
    data(){
        return{
            isToggle:false,
        }
    },
    props:{
    colorTextFront:{
        type:String,
        default:'black'
    },
    colorFront:{
        type:String,
        default:'white'
    },
    
    }

};
</script>

<style>
</style>