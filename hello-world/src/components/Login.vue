<template>
    <div>
       <div> <label>姓名</label><input type="text" v-model="username">
       </div>
       <div>
        <label>密码</label><input type="password" v-model="password">
       </div>
        <button @click="login">登录</button>
    </div>
</template>
<script>
export default {
  data() {
    return {
      username: '',
      password: ''
    }
  },
  methods: {
    login: function() {
      console.log(this.username, this.password);
      this.$router.push({path: '/hello',
      query: {username: this.username,
          password: this.password}
      }
      )
    }
  }
};
</script>

