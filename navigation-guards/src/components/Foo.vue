<template>
    <div>
        Foo {{m}} <button @click="change">按钮</button>
    </div>
</template>

<script>
export default {
    data() {
        return {
            m: 1
        }
    },
    methods: {
        change() {
            this.m = Math.random()
        }
    },
    beforeRouteEnter (to, from, next) {
        // ...
        console.log('beforeRouteEnter: 组件未渲染，导航准备跳转');
        next(vm => {

        })
    },
    beforeRouteUpdate (to, from, next) {
        // 当路由发生改变时
        console.log('beforeRouteUpdate: 组件被复用，路由发生改变')
        console.log(to.params.id)
        next()
      },
      beforeRouteLeave (to, form, next) {
        // 离开前调用
        console.log('beforeRouteLeave: 路由离开')
        next()
      },
      beforeCreate () {
        console.log("beforeCreate")
      },
      created () {
        console.log("Created")
      },
      beforeMount () {
        console.log("beforeMount")
      },
      mounted () {
        console.log("mounted")        
      },
      beforeUpdate () {
        console.log("beforeUpdate")        
      },
      updated () {
        console.log("updated")        
      },
      beforeDestroy () {
        console.log("beforeDestroy")                
      },
      destroyed () {
        console.log('destroyed')
      }
}
</script>
