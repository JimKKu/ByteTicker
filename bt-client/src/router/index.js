import Vue from 'vue'
import VueRouter from 'vue-router'
import OrderView from '../views/OrderView.vue'
import SettingView from '../views/SettingView.vue'
import HomeView from "@/views/HomeView.vue";
import TestView from "@/views/TestView.vue";

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
  },
  {
    path: '/test',
    name: 'test',
    component: TestView
  },
]


// const router = new VueRouter({
//   mode: 'history',
//   base: process.env.BASE_URL,
//   routes
// })

/* Jim-e: 打包exe用 */
const router =  new VueRouter({
  mode: 'hash',
  routes: routes
})

export default router
