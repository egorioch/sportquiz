import { createApp } from 'vue'
import App from './App.vue'
import router from "@/router/router";
import * as cors from "cors";

createApp(App)
  .use(router)
  .use(cors)
  .mount('#app')
