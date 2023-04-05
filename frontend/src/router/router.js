import {createRouter, createWebHistory} from "vue-router";

import HomePage from "@/components/HomePage.vue";
import PlayComponent from "@/components/bar/PlayComponent.vue";
import LoginComponent from "@/components/LoginComponent.vue";
import ShopComponent from "@/components/ShopComponent.vue";

export default createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: '/',
      name: 'HomePage',
      component: HomePage
    },
    {
      path: '/play',
      name: 'PlayComponent',
      component: PlayComponent
    },
    {
      path: '/login',
      name: 'LoginComponent',
      component: LoginComponent
    },
    {
      path: '/shop',
      name: 'ShopComponent',
      component: ShopComponent
    }
  ]
})