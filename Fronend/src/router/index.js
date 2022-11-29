import { createRouter, createWebHistory } from 'vue-router';
import HomeView from '../views/HomeView.vue'
const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            name: 'home',
            component: HomeView
        },
        {
            path: '/estudiantes',
            name: 'registro',
            component: ()=> import('../views/RegistroView.vue')
        },
        {
            path: '/consulta',
            name: 'consulta',
            component: ()=> import('../views/ConsultaView.vue')
        }
    ]
})

export default router