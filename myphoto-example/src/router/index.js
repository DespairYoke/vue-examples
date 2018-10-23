import Vue from 'vue'
import Router from 'vue-router'
import Main from '../page/main.vue'
import Upload from '../components/Upload.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'main',
      component: Main,
      children: [
        {
          path: '/',
          name: 'upload',
          component: Upload
        }
      ]
    }
  ]
})