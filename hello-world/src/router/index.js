import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/pages/home'
import About from '@/pages/about'
import HelloWorld from '@/components/HelloWorld'
import Login from '@/components/Login'
import Child from '@/components/Child'
Vue.use(Router)

export default new Router({
    mode: 'history',
    routes: [
        {
            path: '/',
            name: 'Home',
            component: Home
        },
        {
            path: '/about',
            name: About,
            component: About
        },
        {
            path: '/hello',
            name: 'HelloWorld',
            component: HelloWorld,
            children: [
                {
                    path: '/hello/:name',
                    name: 'HelloWorld',
                    component: Child
                },
            ]
        },
       
        {
            path: '/login',
            name: 'Login',
            component: Login
        }
    ]
})