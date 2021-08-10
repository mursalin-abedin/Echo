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
    
    <div class="loginbox" @click="$router.push('/AboutUs')">
        <div class="loginlogo">
            <i class="fas fa-sign-in-alt loginadjust"></i>
        </div>
        <div class="loginwords">
            About Us
        </div>
    </div>
</Nav>
    
    
    
<div class="mainapparea">
    <div class="headerbox">
        <div class="headerboxleft">
            <div><img class="headerimage" src="../img/Logo.png"></div>
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

    <div class="card" @click="$router.push('Admin')">
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

@import url('https://fonts.googleapis.com/css2?family=Warnes&display=swap');

* {
  margin: 0;
  padding: 0;
}

body {
  font-family: "Poppins", sans-serif;
  background-color: #F7F3E9;
}


/* css for the top nav var */

nav {
    background-color: #5EAAA8;
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
    background: #F7F3E9;
    border-radius: 50%;
    border: 3px solid #A3D2CA;
}

.logowords {
    display: block;
    font-family: 'Warnes', cursive;
    font-size: 27pt;
    font-weight: bold;
    margin: 2px 0px 0px 5px;
    color: #F7F3E9;
}

.loginbox {
    display: block;
    margin: 10px 20px 0px 0px;
}

.logoadjust
{
    margin: 0px 0px 0px 0px;
    color: #F05945;
    margin: 6px 0px 0px 8px;
}

.loginlogo {
    display: block;
    width: 30px;
    height: 30px;
    font-size: 14pt;
    background: #F7F3E9;
    border-radius: 50%;
    border: 3px solid #A3D2CA;
    margin: 5px 0px 0px 25px;
}

.loginwords {
    display: block;
    font-family: Montserrat;
    font-size: 10pt;
    margin: 0px 2px 0px 25px;
    
}

.loginbox {
    display: block;
    margin: 3px 20px 0px 0px;
}

.loginadjust
{
    margin: 0px 0px 0px 0px;
    color: #F05945;
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
    background: #F7F3E9;
}

/* endmain app area*/

/*font page card styles*/

.card {
    display: flex;
    flex-direction: column;
    justify-content: center;
    background: #A3D2CA;
    width: 40%;
    margin: 20px;
    padding: 0px 20px 0px 20px;
    border-radius: 5px;
    box-shadow: 2px 2px 2px #c0c0c0;
    justify-content: center;
    border-bottom: 4px solid #5EAAA8;
    transition: all .4s ease;
}

.card:hover {
    border-bottom: 4px solid #F05945;
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
    color: #F05945;
    height: 120px;
    width: 120px;
    border-radius: 50%;
    text-align: center;
    background-color: #F7F3E9;
    margin: 10px auto 10px auto;
    border: 3px solid #5EAAA8;
    
}

.cardwords {
    text-align: center;
    color: #666666;
}

.headerbox {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    background: #A3D2CA;
    width: 90%;
    margin: 20px;
    padding: 0px 20px 0px 20px;
    border-radius: 5px;
/*    border: 2px dotted #999999;*/
    box-shadow: 2px 2px 2px #c0c0c0;
    transition: all .4s ease;
    border-bottom: 4px solid #5EAAA8;
}

.headerimage {
    padding-top: 30px;
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