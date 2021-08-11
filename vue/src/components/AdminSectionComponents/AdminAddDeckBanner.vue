<template>
    <div class="selectdeckarea">
    <div class="selectdeckbannertext">Select a Deck, or create a new deck to get started!</div>
    <div>
        
    <!-- <div class="adddeckbox">
        <div class="adddeckogo">
            <i class="fas fa-plus adddeckadjust"></i>
        </div>
        <div class="adddeckwords">
            new deck
        </div>
    </div>         -->
    </div>        
            
</div>
</template>

<script>
export default {
    name: 'AdminAddDeckBanner'
}
</script>

<style scoped>

* {
  margin: 0;
  padding: 0;
}

body {
  font-family: "Poppins", sans-serif;
  background-color: #A3D2CA;
}
.selectdeckarea {
    display: flex;
    flex-direction: row;
    justify-content: center;
    background: #A3D2CA;
    width: 80%;
    margin: 20px;
    padding: 0px 20px 0px 20px;
    border-radius: 5px;
/*    border: 2px dotted #999999;*/
    box-shadow: 2px 2px 2px #c0c0c0;
    border-bottom: 4px solid #5EAAA8;
    transition: all .4s ease;
    
}
.selectdeckbannertext {
    margin: 20px;
    font-size: 20pt;
    color: #333333;
}

.adddeckbox {
    display: block;
    margin: 0px 0px 0px 0px;
}

.adddeckbox:hover {
    cursor: pointer;
}


.adddeckogo {
    display: block;
    width: 30px;
    height: 30px;
    font-size: 16pt;
    background: #efefef;
    border-radius: 50%;
    border: 3px solid #666666;
    margin: 10px 0px 0px 20px;
} 

.adddeckogo:hover {
    border: 3px solid #7B50D3;
    background: #cfcfcf;
}


.adddeckadjust {
    margin: 0px 0px 0px 0px;
    color: #8C4ED2;
    margin: 5px 0px 0px 6px;    
}

</style>