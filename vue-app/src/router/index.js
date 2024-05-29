import { createRouter, createWebHistory } from 'vue-router'
import Section1 from "@/components/Section1.vue";

const routes = [
  {
    path: '/',
    name: 'Section1',
    component: Section1
  },
  {
    path: '/#Section2',
    name: 'Section2',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import('@/components/Section1.vue')
  },
  {
    path: '/#Section3',
    name: 'Section3',

    component: () => import('@/components/Section3.vue')
  },
  {
    path: '/#Section4',
    name: 'Section4',
    component: () => import('@/components/Section4.vue')
  },
  {
    path: '/#Section5',
    name: 'Section5',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import('@/components/Section5.vue')
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
