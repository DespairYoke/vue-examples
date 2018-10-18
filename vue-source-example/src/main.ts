import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import iView from 'iview'
import VueResource from 'vue-resource'
import 'iview/dist/styles/iview.css'

import global from './components/Global.vue'

Vue.config.productionTip = false
Vue.use(iView)
Vue.use(VueResource)
Vue.prototype.GLOBAL = global
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
