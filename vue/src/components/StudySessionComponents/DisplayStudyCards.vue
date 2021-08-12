<template>
  <div>
      <div class="header" >
          <div class="icon"><i class="fas fa-user-astronaut echoicon"></i></div>
             <div class="echotext"> Echo</div>
               <div class="CardTitle">
                 <h5>Lets Practice</h5>
                  <div class="StudySession">
                    </div>
                    <div class="page">
                      <h1>Title goes Here</h1>
      </div>
    </div>
  </div>
  </div>
</template>

<script>
//import DeckService from "@/services/DeckService";
export default {};

</script>
<style scoped>
.header {
  display: flex;
  flex-direction: row;
  width: 100%;
  height: 80px;
  position: absolute;
  margin-bottom: 20pt;
  background-color: #108cee;
}
.icon {
  color: #ff9201;
  text-align: center;

  display: block;

  font-size: 20pt;

  padding: 0px 0px 0px 0px;
  margin: 15px 0px 0px 10px;

  width: 50px;
  height: 50px;

  background-color: #e0e0e0;
  border: 1px solid #666666;
  border-radius: 50%;
}
.echotext {
  margin: 10px 0px 10px 10px;
  font-size: 30pt;
  font-weight: 700;
  color: #e0e0e0;
}
.cardTitle{
margin: 10px 0px 10px 10px;
  font-size: 30pt;
  font-weight: 700;
  color: #e0e0e0;
border-radius: 57px;
}
</style>