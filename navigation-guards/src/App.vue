<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <li><router-link to= "/foo">Foo</router-link></li>
    <li><router-link to = "/bar">Bar</router-link></li>
    <router-view></router-view>

  </div>
</template>

<script>

export default {
  name: 'app',
  components: {
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
