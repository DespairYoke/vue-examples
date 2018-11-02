import Vue from 'vue'
import Router from 'vue-router'
import Main from '../page/main.vue'
import Upload from '../components/Upload.vue'
import Login from '../components/Login.vue'
import lucky_wheel from '../components/lucky_wheel.vue'


Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'main',
      component: Main,
      children: [
        {
          path: 'uploadimg',
          name: 'upload',
          component: Upload
        },
        {
          path: '/lucky_wheel',
          name: 'lucky_wheel',
          component: lucky_wheel
        }
      ]
    },
   
  ]
})
