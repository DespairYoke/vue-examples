<template>
    <div>
      Bar {{m}} {{$route.params.id}} 
      <button @click="change">按钮</button>
    </div>
</template>
<<script>
export default {
  data () {
        return {
          m: 1
        }
      },
      methods: {
        change () {
          this.m = Math.random()
        }
      },
      beforeRouteEnter (to, from, next) {
        // 这个被调用时，组件还未被渲染，所以获取不到this
        console.log('BAR beforeRouteEnter: 组件未渲染，导航准备跳转')
        next()
      },
      beforeRouteUpdate (to, from, next) {
        // 当路由发生改变时
        console.log('BAR beforeRouteUpdate: 组件被复用，路由发生改变')
        console.log(to.params.id)
        next()
      },
      beforeRouteLeave (to, form, next) {
        // 离开前调用
        console.log('BAR beforeRouteLeave: 路由离开')
        next()
      },
      beforeCreate () {
        console.log("BAR beforeCreate")
      },
      created () {
        console.log("BAR Created")
      },
      beforeMount () {
        console.log("BAR beforeMount")
      },
      mounted () {
        console.log("BAR mounted")        
      },
      beforeUpdate () {
        console.log("BAR beforeUpdate")        
      },
      updated () {
        console.log("BAR updated")        
      },
      beforeDestroy () {
        console.log("BAR beforeDestroy")                
      },
      destroyed () {
        console.log('BAR destroyed')
      }
}
</script>
