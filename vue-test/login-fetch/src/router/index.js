import Vue from 'vue'
import Router from 'vue-router'
import Login from '../page/login/login'
import Home from '../page/home/home'
import msite from '../page/msite/msite'
import shoplist from '../components/common/shoplist'
import rateStar  from '../components/common/ratingStar'
import Food from '../page/food/food'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Login',
      component: msite,
      children: [
        {
          path: '/',
          component: shoplist,
          children: [
            {
              path: '/',
              component: rateStar, 
          }
          ]
        }
      ]
    },
    {
      path: '/home',
      component: Home
    },
    {
      path: '/login',
      component: Login
    },
    {
      path: '/food',
      component: Food
    }
  ]
})
