<template>
  <div>
    <p>{{name}}</p>
    <div>
      <p>{{sex}}</p>
      <p>{{age}}</p>
      <input name="sexes" type="radio" checked @click="changeSex"/>男
      <input name="sexes" type="radio" @click="changeSex"/>女
      <div>
      <input type="text" v-model="ages" placeholder="请输入年龄" @keyup.enter="test_Action_age"/>
      </div>
      <div>
      <input type="text" v-model="ages2" placeholder="请输入年龄" @keyup.enter="test_Mutation_age"/>
      </div>
    </div>
  </div>
</template>
<script>

import {mapState,mapMutations,mapActions} from 'vuex'
export default {
  data() {
    return {
      ages:'',
      ages2:'',
    }
  },
  computed: {
    ...mapState(['name','sex','age']),
    
  },
  created() {
    this.initData()
  },
  methods: {
    ...mapMutations(['UPDATE_SEX','ADD_AGE']),
    initData() {
      this.UPDATE_SEX("男")
    },
    ...mapActions({'UPDATE_AGE':'ADD_AGE'}),
    changeSex() {
      console.log(this.sex)
      if(this.sex==='男'){
      this.UPDATE_SEX("女")
      }else{
      this.UPDATE_SEX("男")
      }
    },
    test_Action_age() {
      this.UPDATE_AGE(this.ages)
    },
    test_Mutation_age() {
      this.ADD_AGE(this.ages2)
    }
  }
  
}
</script>

