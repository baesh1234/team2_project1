<template>
    <div>
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
        axios.get('http://localhost:8080/cheer')
          .then(response => {
            this.texts = response.data;
          })
          .catch(error => {
            console.error("Error fetching texts:", error);
          });
      }
    };
</script>