<template>
    <div class="hello"  v-if="showContent">
        <div>
            <h1>Data from Database</h1>
            <ul>
                <li v-for="data in dataList" :key="data.id">{{ data.commentContent }} - {{ data.email }}</li>
            </ul>
        </div>
    </div>
</template>

<script>
    import axios from 'axios';

    export default {
      data() {
        return {
         showContent: false,  // 이 값을 false로 설정하여 내용을 숨깁니다.
          dataList: [],
        };
      },
      mounted() {
        axios.get('/api/cheer')
          .then(response => {
            this.dataList = response.data;
          })
          .catch(error => {
            console.error('Error fetching data:', error);
          });
      },
    };
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
    .hello {
       margin: 0;  /* .hello 클래스에 대해 여백을 제거합니다 */
     }
     h1 {
       margin: 0;  /* h1 요소에 대해 여백을 제거합니다 */
     }
     ul {
       list-style-type: none;
       padding: 0;
     }
     li {
       display: inline-block;
       margin: 0 10px;
     }
     a {
       color: #42b983;
     }
</style>
