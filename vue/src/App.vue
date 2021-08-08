
<template>
  <div class="mainpagelayout">
    <router-view />
  </div>
</template>

<script>

export default {
    name: 'APP',
    components: {
    },
    data() {
      return {
      }
    }
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400&display=swap');
body {
  margin: 0px;
  font-family: Poppins, Arial, Helvetica, sans-serif;
}

.mainpagelayout {
}
</style>