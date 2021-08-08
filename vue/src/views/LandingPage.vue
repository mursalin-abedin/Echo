<template>
<div>

<Nav>
    <div class="logobox">
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
    
    
    
<div class="mainapparea">
    <div class="headerbox">
        <div class="headerboxleft">
            <div><img class="headerimage" src=""></div>
        </div>
        
        <div class="headerboxright">
            <div class="headerboxlarge">Welcome to Echo</div>
            <div class="headerboxsmall">The easiest way to make and study flashcards
           <div class="headerboxsmall2">  
               A better way to study with flashcards is here. Echo makes it simple to create your own flashcards, and study those flashcards.<br>
               Not only is a great way to learn, it's also super fun. 

            </div>
                
              <div class="headerboxsmall2">  
                <br><br>
               Select an option from below: Study Session or Edit Cards & Decks.
              </div>

            </div>
        </div>
    </div>
    
    
    <div class="card" @click="$router.push('StudySession')">
        <div class="cardpicbox">
            <i class="fas fa-lightbulb"></i>
        </div>
        <div class="cardwordsbox">
            <div class="cardwords">
                Study Session
            </div>
        </div>
    </div>

    <div class="card" @click="$router.push('home')">
        <div class="smallericon cardpicbox">
            <i class="fas fa-chalkboard-teacher teacheradjust"></i>
        </div>
        <div class="cardwordsbox">
            <div class="cardwords">
                Edit Cards & Decks
            </div>
        </div>
        <div class="cardwords">
                
        </div>
    </div>
    
    
</div> 
</div>     
</template>

<script scoped>

export default {
  name: "LandingPage",
  components: {}
};
</script>

<style>

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

.mainapparea {
    display: flex;
    flex-direction: row;
    justify-content: space-around;
    flex-wrap: wrap;
    padding: 20px;
}

/* endmain app area*/

/*font page card styles*/

.card {
    display: flex;
    flex-direction: column;
    justify-content: center;
    background: #ffffff;
    width: 40%;
    margin: 20px;
    padding: 0px 20px 0px 20px;
    border-radius: 5px;
    box-shadow: 2px 2px 2px #c0c0c0;
    justify-content: center;
    border-bottom: 4px solid #ffffff;
    transition: all .4s ease;
}

card:hover {
/*    box-shadow: 2px 2px 2px #439B00;*/
    border-bottom: 4px solid #4C0DCC;
    background: #f0f0f0;
    cursor: pointer;
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

.cardpicbox {
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
    text-align: center;
    color: #666666;
}

.headerbox {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    background: #FFFFFF;
    width: 90%;
    margin: 20px;
    padding: 0px 20px 0px 20px;
    border-radius: 5px;
/*    border: 2px dotted #999999;*/
    box-shadow: 2px 2px 2px #c0c0c0;
    transition: all .4s ease;
}

.headerimage {
    display:block;
    width: 300px;
}

.headerboxleft {
    display: block;

}

.headerboxright {
    width: 80%;
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    padding: 0px 0px 0px 10px;
}

.headerboxlarge{
    font-size: 20pt;
    padding: 20px 0px 20px 0px;
}

.headerboxsmall {
    font-size: 16pt;
    padding: 0px 0px 40px 0px;
}

.headerboxsmall2 {
    font-size: 12pt;
}

@media only screen and (max-width: 850px) {
    .headerboxleft {
        display: none !important;
    }
    card {
        width: 100% !important;
    }   
}

@media only screen and (max-width: 550px) {
    .headerboxsmall2 {
        display: none !important;
    } 
}

</style>