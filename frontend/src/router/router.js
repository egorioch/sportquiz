import {createRouter, createWebHistory} from "vue-router";

import HomePage from "@/components/HomePage.vue";
import PlayComponent from "@/components/bar/PlayComponent.vue";

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
    }
  ]
})