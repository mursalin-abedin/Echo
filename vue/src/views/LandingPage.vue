<template>
  <div>
    <div class="header">
      <div class="icon" ><i class="fas fa-user-astronaut echoicon"></i></div>
      <div class="echotext">Echo</div>
    </div>

    <main class="page">
      <div class="welcome">
          
        <h1>Welcome To Echo Cards</h1>
      </div>
      <div>
        <button @click="$router.push('home')">Edit Decks</button>
        <button @click="$router.push('StudySession')">Start Study Session</button>
      </div>
    </main>
  </div>
</template>

<script>
export default {};
</script>

<style>
button {
  background-color: #6ad0f8; /* Green */
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 5px;
  border-radius: 10px;
}
.page {
  position: absolute;
  margin-top: 200px;
  display: flex;
  justify-content: center;
}
.editdeck{
    width: 100px;
    height: 100px;
    background: lightblue;
}
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
</style>