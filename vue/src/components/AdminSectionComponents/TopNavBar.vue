<template>

<Nav>
    <div class="logobox" @click="$router.push('/')">
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
    
</template>

<script>
export default {
    name:'TopNavBar'
}
</script>

<style scoped>

@import url('https://fonts.googleapis.com/css2?family=Warnes&display=swap');

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
    margin: 2px 0px 0px 5px;
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
    color: #F05945;
    margin: 5px 0px 0px 6px;
}

/* END css for the top nav var */
</style>