<template>
　　<div>
　　　　<p> father</p>
   　　 <hello :mes="loginJson.animal"  @sendiptVal='showChildMsg'></hello>
        <p>{{this.message}}</p>
　　</div>

</template>

<script>
import hello from '@/components/hello'
    
export default {
    name: 'app',
  data() {
    return {

      message:'',
      loginJson:{
          "animal":"dog"
      },

    }
  },
  components:{
    hello
      
  },
  methods: {
      showChildMsg(e) {
          console.log(e)
        this.message = e
      }
  }
}
</script>

<style>

</style>