import { createRouter, createWebHistory } from 'vue-router';
import Home from '../views/Home.vue';
import innoWrite from '../views/write-form.vue';

const routes = [
  { path: '/', name: 'Home', component: Home },
  { path: '/innoWrite', name: 'innoWrite', component: innoWrite },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
});

export default router;
