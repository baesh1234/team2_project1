<template>
    <div class="cheer">
        <h1>Texts</h1>
        <ul>
            <li v-for="text in texts" :key="text">{{ text }}</li>
        </ul>
    </div>
</template>

<script>
    import axios from 'axios';

    export default {
      data() {
        return {
          texts: []
        };
      },
      mounted() {
axios.get('/cheer')  // 백엔드의 /cheer 엔드포인트로 요청 보냄
  .then(response => {
    this.texts = response.data;
  })
  .catch(error => {
    console.error("Error fetching texts:", error);
  });
      },
    };
</script>

<style scoped>
    .cheer {
      padding: 20px;
    }
</style>
