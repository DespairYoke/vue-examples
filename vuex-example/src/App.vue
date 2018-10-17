<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <p>{{count}}</p>
    <p><button @click="increment">+</button>
    <button @click="decrement">-</button>
    </p>
    <p><button @click="add">+100</button></p>
    <div>
      {{$store.getters.doneTodos}}
    </div>
     <div>
      {{$store.getters.doneTodosCount}}
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
  
    }
  },
  computed: {
    count() {
      return this.$store.state.count
    }
  },
  methods: {
    increment () {
      this.$store.commit('increment', 10)
    },
    decrement() {
      this.$store.commit('decrement')
    },
    add() {
      this.$store.dispatch('add')
    }
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
}
#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
