import Vue from 'vue'
import App from './app'
import router from "./router";
import axios from 'axios'
import filter from "./filter/filter";

Vue.config.productionTip = false
Vue.prototype.$ajax = axios;

Object.keys(filter).forEach(key => {
  Vue.filter(key, filter[key])
})
new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
