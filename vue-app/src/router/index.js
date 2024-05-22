import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import Cheer from '../views/Cheer.vue' // Cheer 컴포넌트를 불러옵니다.

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/cheer',
    name: 'Cheer',
    component: Cheer
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
