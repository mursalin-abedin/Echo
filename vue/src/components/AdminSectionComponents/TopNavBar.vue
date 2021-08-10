<template>

<Nav>
    <div class="logobox" onclick="forwardTo('./index.html');">
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
    
</template>

<script>
export default {
    name:'TopNavBar'
}
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
</style>