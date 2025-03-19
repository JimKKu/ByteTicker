import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

// 导入 ElementUI
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
// 使用 ElementUI
Vue.use(ElementUI);


// 导入并使用基础请求
import {getRequest,putRequest,pstRequest,delRequest} from "@/api/base";
Vue.prototype.$GET = getRequest;
Vue.prototype.$PUT = putRequest;
Vue.prototype.$PST = pstRequest;
Vue.prototype.$DEL = delRequest;

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: function (h) { return h(App) }
}).$mount('#app')
