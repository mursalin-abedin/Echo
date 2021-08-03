<template>
    <div>
        <div class="deck" @click="$emit('add-new-deck')">+ Add New Deck</div>
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

.deck {
    display: block;
    font-size: 16pt;
    padding: 10px

}

.deck:hover{
    background-color: #d8effd;
}

</style>