
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

<style scoped>
body {
  margin: 0px;
  font-family: Arial, Helvetica, sans-serif;
}

.mainpagelayout {
  display:flex;
}
</style>