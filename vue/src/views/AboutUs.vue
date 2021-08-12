<template>
  <div>
    <Nav>
      <div class="logobox" @click="$router.push('/')">
        <div class="logo">
          <i class="fas fa-user-astronaut logoadjust"></i>
        </div>
        <div class="logowords">Echo</div>
      </div>

      <div class="loginbox" @click="$router.push('/')">
        <div class="loginlogo">
          <i class="fas fa-sign-in-alt loginadjust"></i>
        </div>
        <div class="loginwords">Go Back</div>
      </div>
    </Nav>

    <div class="mainapparea">
      <div class="headerbox">
        <div class="headerboxleft">
          <div><img class="headerimage" src="../img/LuisAvellana.jpg" /></div>
        </div>

        <div class="headerboxright">
          <div class="headerboxlargetwo">Luis Avellana</div>
          <div class="headerboxsmall">
            Hi I'm Luis, and I’m a recovering sales person transitioning into
            the technology field. For years I would always be excited to sell
            new products, but one day I started daydreaming about how cool it
            would be to make these products instead. Technology is constantly
            changing the world around us and is capable of making a positive
            impact in all our lives! Those daydreams and my love for problem
            solving, team building, and making connections have me now looking
            to make a career change into being a developer. After I graduate I’m
            looking to use my analytical skills and desire to learn as a
            foundation for a junior developer role that allows me to collaborate
            with a team and continue to grow my skills.
          </div>
        </div>
      </div>
    </div>

    <div class="mainapparea">
      <div class="headerbox">
        <div class="headerboxleft">
          <div class="headerboxlarge">Andrew Ball</div>
          <div class="headerboxsmall">
            Cool fullstack web dev guy with a passion for learning how things
            work. Will talk your ear off about anything animation or video
            games. (Not actually a dog)
          </div>
        </div>

        <div class="headerboxrighttwo">
          <img class="headerimage" src="../img/AndrewBall.jpg" />
        </div>
      </div>
    </div>

    <div class="mainapparea">
      <div class="headerbox">
        <div class="headerboxleft">
          <div><img class="headerimage" src="../img/StephanieEaton.jpg" /></div>
        </div>

        <div class="headerboxright">
          <div class="headerboxlarge">Stephanie Eaton</div>
          <div class="headerboxsmall">
            I am a Java Bootcamp student with a history of IT Support and
            customer service. I am well acquainted with paired programming with
            4 legged critters, although compatibility with the two legged
            feathered kind is to be determined. I am looking for job roles that
            allow me to express my creativity through problem solving and
            commitment, and embraces my positivity and enthusiasm for
            technology.
          </div>
        </div>
      </div>
    </div>

    <div class="mainapparea">
      <div class="headerbox">
        <div class="headerboxleft">
          <div class="headerboxlarge">Mursalin Abedin</div>
          <div class="headerboxsmall">
            I am an aspiring full stack developer and currently a Java Student
            at Tech Elevator. I am a person who enjoys constant learning and
            facing challenges. I have ten years’ experience in Accounting and
            Finance where I cultivated my strong analytical and problem-solving
            skills. As I was always interested in IT field and learning new
            coding languages, I decided to take my new career path as a software
            developer. After graduating, I am hoping to join a company where I
            will have the opportunity to grow my skill set and get more
            responsibilities as a senior developer with time.
          </div>
        </div>

        <div class="headerboxright">
          <div><img class="headerimage" src="../img/MursalinAbedin.jpg" /></div>
        </div>
      </div>
    </div>
  </div>
</template>

<script scoped>
export default {
  name: "LandingPage",
  components: {},
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Warnes&display=swap");

* {
  margin: 0;
  padding: 0;
}

body {
  font-family: "Poppins", sans-serif;
  background-color: #f7f3e9;
}

/* css for the top nav var */

nav {
  background-color: #5eaaa8;
  color: #fff;
  display: flex;
  justify-content: space-between;
  height: 64px;
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
  background: #f7f3e9;
  border-radius: 50%;
  border: 3px solid #a3d2ca;
}

.logowords {
  display: block;
  font-family: "Warnes", cursive;
  font-size: 27pt;
  font-weight: bold;
  margin: 2px 0px 0px 5px;
  color: #f7f3e9;
}

.loginbox {
  display: block;
  margin: 10px 20px 0px 0px;
}

.logoadjust {
  margin: 0px 0px 0px 0px;
  color: #f05945;
  margin: 6px 0px 0px 8px;
}

.loginlogo {
  display: block;
  width: 30px;
  height: 30px;
  font-size: 14pt;
  background: #f7f3e9;
  border-radius: 50%;
  border: 3px solid #a3d2ca;
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

.loginadjust {
  margin: 0px 0px 0px 0px;
  color: #f05945;
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
  background: #f7f3e9;
}

.headerbox:hover {
  border-bottom: 4px solid #f05945;
}

/* endmain app area*/

/*font page card styles*/

.card {
  display: flex;
  flex-direction: column;
  justify-content: center;
  background: #a3d2ca;
  width: 40%;
  margin: 20px;
  padding: 0px 20px 0px 20px;
  border-radius: 5px;
  box-shadow: 2px 2px 2px #c0c0c0;
  justify-content: center;
  border-bottom: 4px solid #5eaaa8;
  transition: all 0.4s ease;
}

.card:hover {
  border-bottom: 4px solid #f05945;
}

.cardwordsbox {
  text-align: center;
  margin: 0px 0px 10px 0px;
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
  color: #f05945;
  height: 120px;
  width: 120px;
  border-radius: 50%;
  text-align: center;
  background-color: #f7f3e9;
  margin: 10px auto 10px auto;
  border: 3px solid #5eaaa8;
}

.cardwords {
  text-align: center;
  color: #666666;
}

.headerbox {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  background: #a3d2ca;
  width: 90%;
  margin: 20px;
  padding: 0px 20px 0px 20px;
  border-radius: 5px;
  /*    border: 2px dotted #999999;*/
  box-shadow: 2px 2px 2px #c0c0c0;
  transition: all 0.4s ease;
  border-bottom: 4px solid #5eaaa8;
}

.headerimage {
  border-radius: 15px 50px 30px;
  display: block;
  width: 270px;
  max-height: 270px;
  margin-top: 8px;
  margin-bottom: 8px;
}

.headerimagetwo {
  border-radius: 15px 50px 30px;
  display: block;
  width: 270px;
  max-height: 270px;
  margin-left: 500px;
  margin-top: 8px;
  margin-bottom: 8px;
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
  text-align: right;
}

.headerboxlefttwo {
  width: 80%;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  padding: 0px 0px 0px 10px;
}

.headerboxrighttwo {
  display: block;
}

.headerboxlarge {
  font-size: 20pt;
  padding: 20px 0px 20px 0px;
}

.headerboxlargetwo {
  font-size: 20pt;
  padding: 20px 0px 20px 0px;
  text-align: right;
}

.headerboxsmall {
  font-size: 16pt;
  padding: 0px 0px 40px 0px;
}

.headerboxsmall2 {
  font-size: 12pt;
}

</style>