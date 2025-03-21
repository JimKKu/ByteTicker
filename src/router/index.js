import Vue from 'vue'
import VueRouter from 'vue-router'
import OrderView from '../views/OrderView.vue'
import SettingView from '../views/SettingView.vue'
import HomeView from "@/views/HomeView.vue";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'order',
    component: HomeView
  },
  {
    path: '/order',
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
