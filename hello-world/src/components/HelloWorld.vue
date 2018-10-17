
import func from './vue-temp/vue-editor-bridge';

<template>
<div>
  <!-- <div v-if="loginType === 'username'">
      <label>Username</label>
  <input placeholder="Enter your username">
  </div>
    <div v-else>
      <label>Email</label>
  <input placeholder="Enter your username">
  </div>
<button v-on:click="print">Toggle login type</button> -->
<div>
<h3>你好！{{$route.query.username}},你的密码是：{{$route.query.password}}</h3>
</div>
<div>
  <router-view></router-view>
</div>
</div>

</template>
<script>
export default {
  name: "HelloWorld",
  props: {
    msg: String
  },
  data() {
    return {
      loginType: "username"
    };
  },
  methods: {
    print: function() {
      console.log('zzzz'),
      this.loginType = "zwd"
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
