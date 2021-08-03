

<template>
  <div class="mainpagelayout">
    <Nav />
    <router-view />
  </div>
</template>

<script>
import Nav from './components/Nav'

export default {
    name: 'APP',
    components: {
        Nav
    },
    data() {
      return {
        //any data the whole app needs should go here, then be passed via Param to the componets
      }
    }
}
</script>

<style scoped>
body {
  margin: 0px;
  font-family: Arial, Helvetica, sans-serif;
}

.mainpagelayout {
  display:flex;
}
</style>