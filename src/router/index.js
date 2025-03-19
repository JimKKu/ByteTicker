import Vue from 'vue'
import VueRouter from 'vue-router'
import OrderView from '../views/OrderView.vue'
import SettingView from '../views/SettingView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'order',
    component: OrderView
  },
  {
    path: '/setting',
    name: 'setting',
    component: SettingView
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
