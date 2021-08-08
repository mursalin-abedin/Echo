<template>
<body>
 
<Nav>
    <div class="logobox"  @click="$router.push('/')">
        <div class="logo">
            <i class="fas fa-user-astronaut logoadjust"></i>
        </div>
        <div class="logowords">
            Echo
        </div>
    </div>
    
    <div class="loginbox">
        <div class="loginlogo">
            <i class="fas fa-sign-in-alt loginadjust"></i>
        </div>
        <div class="loginwords">
            Log in
        </div>
    </div>
</Nav>
    
<main>   
<mainapparea>
    <div class="banner" >
        <div class="bannericonbox">
            <i class="fas fa-star"></i>
        </div>
        <div class="bannertext">
            
            <div class="bannertextsmall">Are you ready to get started on your learning adventure? </div>
            <div class="bannertextbig">Select a Study Deck and get started!</div>
        </div>
    </div>

      <div v-for="deck in decks" :key="deck.deckId" v-on:click={} class="deck" @click="$router.push('studysession/deck/' + deck.deckId)">
        <div class="smallericon deckpicbox">
            <i class="fas fa-layer-group teacheradjust"></i>
        </div>
        <div class="cardwordsbox">
            <div class="cardwords">
                <!-- {{ deck.deckName }} -->
            </div>
        </div>
        <div class="cardwords">
                {{ deck.deckDescription }}
        </div>
      </div>  
    
</mainapparea>    
</main>    

</body>
</template>

<script>
import DeckService from "@/services/DeckService";

export default {
  data() {
    return {
      decks: Array,
    };
  },
  methods: {},
  created() {
    DeckService.getAllDecks().then((resp) => {
      this.decks = resp.data;
    });
  },
};
</script>

<style scoped>

* {
  margin: 0;
  padding: 0;
}

body {
  font-family: "Poppins", sans-serif;
  background-color: #E7EAF7;
}


/* css for the top nav var */

nav {
    background-color: #650acb;
    color: #fff;
    display: flex;
    justify-content: space-between;
    height: 64px;;
    padding: 0px 0px 0px 0px;
    box-shadow: 0 0.3125rem 1rem 0 rgb(0 0 0 / 8%);
    z-index: 300;
}

.logobox {
    display: flex;
    margin: 8px 0px 0px 20px;
}

.logo {
    display: block;
    width: 40px;
    height: 40px;
    font-size: 20pt;
    background: #efefef;
    border-radius: 50%;
    border: 3px solid #666666;
}

.logowords {
    display: block;
    font-family: Montserrat;
    font-size: 27pt;
    margin: 2px 0px 0px 5px;
}

.loginbox {
    display: block;
    margin: 10px 20px 0px 0px;
}

.logoadjust
{
    margin: 0px 0px 0px 0px;
    color: #8C4ED2;
    margin: 6px 0px 0px 8px;
}

.loginlogo {
    display: block;
    width: 30px;
    height: 30px;
    font-size: 14pt;
    background: #efefef;
    border-radius: 50%;
    border: 3px solid #666666;
    margin: 5px 0px 0px 3px;
}

.loginwords {
    display: block;
    font-family: Montserrat;
    font-size: 10pt;
    margin: 0px 0px 0px 0px;
}

.loginbox {
    display: block;
    margin: 3px 20px 0px 0px;
}

.loginadjust
{
    margin: 0px 0px 0px 0px;
    color: #8C4ED2;
    margin: 5px 0px 0px 6px;
}

/* END css for the top nav var */

/*main app area*/

main {
    display: flex;
    flex-direction: row;
    width: 100%;
    margin: 0px auto 0xp auto;
}

mainapparea {
    display: flex;
    flex-direction: row;
    justify-content: center;
    flex-wrap: wrap;
    width: 100%;
}

/* endmain app area*/

/*font page card styles*/

.banner {
    display: flex;
    flex-direction: row;
    background: #ffffff;
    width: 100%;
    margin: 20px;
    padding: 0px 20px 0px 20px;
    border-radius: 5px;
    box-shadow: 2px 2px 2px #c0c0c0;
/*    justify-content: center;*/
    
}

.bannericonbox {
    display: block;
    font-size: 60pt;
    color: #FFDD00;
    height: 120px;
    width: 120px;
    border-radius: 50%;
    text-align: center;
    background-color: #f8f8f9;
    margin: 10px auto 10px auto;
/*    border: 3px solid #999999;*/
}

.bannertext {
    width: 80%;
    padding: 50px 0px 0px 0px;
}

.bannertextsmall {
    font-size: 14pt;
    padding: 0px 0px 10px 0px;
    color: #999999;
}

.bannertextbig {
    font-size: 20pt;
    color: #333333;
}


.deck {
    display: flex;
    flex-direction: column;
    background: #ffffff;
    min-width: 18%;
    margin: 20px;
    padding: 0px 20px 0px 20px;
    border-radius: 5px;
    box-shadow: 2px 2px 2px #c0c0c0;
    justify-content: center;
    border-bottom: 4px solid #ffffff;
    transition: all .4s ease;
}

.deck:hover {
    border-bottom: 4px solid #4C0DCC;
    background: #fafafa;
/*    box-shadow: 2px 2px 2px red;*/
}


.cardwordsbox{
    text-align: center;
    margin: 0px 0px 10px 0px
}

.smallericon {
    font-size: 50pt !important;
}

.teacheradjust {
    margin: 25px 5px 0px 0px;
}

.deckpicbox {
    display: block;
    font-size: 60pt;
    color: #FFDD00;
    height: 120px;
    width: 120px;
    border-radius: 50%;
    text-align: center;
    background-color: #c0c0c0;
    margin: 10px auto 10px auto;
    border: 3px solid #999999;
}

.cardwords {
    color: #666666;
}

@media only screen and (max-width: 850px) {
    .bannericonbox {
        display: none !important;
    }
    .bannertextsmall {
        display: none !important;
    }
    mainapparea {
        width: 100% !important;
    }   
}

@media only screen and (max-width: 550px) {
    .headerboxsmall2 {
        display: none !important;
    } 
}

</style>