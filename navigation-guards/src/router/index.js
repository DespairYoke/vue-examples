import vue from 'vue'
import Router from 'vue-router'
import Foo from '@/components/Foo.vue'
import Bar from '@/components/Bar.vue'
vue.use(Router)

export default new Router({
    mode: 'history',
    routes: [
        {
            path: '/foo/:id',
            component: Foo,
            beforeEnter: (to, from, next) => {
                console.log('beforeEnter: 局部守卫');
                next()
            }
        },
        {
            path: '/bar',
            component: Bar,
            beforeEnter: (to, from, next) => {
                console.log('BAR beforeEnter')
                next()
            }
        }
    ]
})