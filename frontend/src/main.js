import { createApp } from 'vue';
import App from './App.vue';
import router from '../src/script/router';
import store from '@/store';

  const storedUser = JSON.parse(localStorage.getItem('user'));
  
  const app = createApp(App);
  
  app.use(router);
  app.use(store);
  
  // Vuex에서 사용자 정보를 설정
  if (storedUser) {
    store.dispatch('login', storedUser); // 사용자 로그인 상태로 설정
  }
  
  app.mount('#app');
  