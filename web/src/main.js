import Vue from 'vue'
import App from './app'
import router from "./router";
import axios from 'axios'
import filter from "./filter/filter";

Vue.config.productionTip = false
Vue.prototype.$ajax = axios;

//事件总线EventBus
Vue.prototype.$event = new Vue();

/**
 * axios拦截器
 */
axios.interceptors.request.use(function (config) {
  console.log("请求：", config);
  return config;
}, error => {});
axios.interceptors.response.use(function (response) {
  console.log("返回结果：", response);
  return response;
}, error => {});

Object.keys(filter).forEach(key => {
  Vue.filter(key, filter[key])
})
new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
