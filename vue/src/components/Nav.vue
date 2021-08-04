<template>
    <div>
        <div class="mainmenubox">
            <div class="topmenubox">
                <div class="echo icon"><i class="fas fa-user-astronaut echoicon"></i></div>
                <!-- <div class="decks icon"><i class="fas fa-layer-group echoicon"></i></div>
                <div class="search icon">search</div> -->
            </div>

            <!-- We will re add below when we incorporate login -->
            <!-- <div class="topmenubox">
                <div class="user icon">user</div>
            </div> --> 
        </div>
        
    </div>
</template>


<script>

export default {
    name: 'Nav'
    
}
</script>

<style scoped>

.mainmenubox{
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    background: #108EEE;
    min-height: 800px;
    width: 80px;
    padding: 0px 0px 0px 10px;
}

.icon{
    background: #03599B;
    margin: 10px 0px 10px 0px;
    height: 60px;
    width: 60px;
    text-align: center;
    vertical-align: middle;
    color: white;
    border-radius: 10px;
}
.icon:hover{
    background: #3BA1EF;
    border: 1px solid #03599B;
}

.echo{
    font-size: 24pt;
}

.echoicon{
    margin: 15px
}

.decks{

}

.search{

}

.space{
    display: block;
    background: #999999;
    height: 300px;
    width: 10px;
}

.user{

}

</style>