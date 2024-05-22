import { createApp } from 'vue'
import App from './App.vue'
import axios from 'axios'

// axios를 전역에서 사용할 수 있도록 설정
const app = createApp(App)

app.config.globalProperties.$axios = axios

createApp(App).mount('#app')