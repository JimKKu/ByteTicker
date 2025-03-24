import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

// 引入 ElementUI
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
// 使用 ElementUI
Vue.use(ElementUI);
// 引入 iconfont
import '@/assets/icons/iconfont.css'

// 导入并使用基础请求
import {sndGET,sndPUT,sndPST,sndDEL} from "@/api/base";
Vue.prototype.$GET = sndGET;
Vue.prototype.$PUT = sndPUT;
Vue.prototype.$PST = sndPST;
Vue.prototype.$DEL = sndDEL;

Vue.config.productionTip = false
document.onselectstart = new Function("event.returnValue=false");
document.oncontextmenu = new Function("event.returnValue=false");
new Vue({
  router,
  store,
  render: function (h) { return h(App) }
}).$mount('#app')
