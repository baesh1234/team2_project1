<template>
  <div class="section s3">
    <div class="s3board">
      <img src="../assets/images/section3board.png" alt="게시판"  width="1100px">
    </div>
    <div class="s3notepad">
      <img src="../assets/images/section3notepad.png" alt="메모장" width="650px">
    </div>
    <div class="s3text">
      <div id="text1">1단계 10만명
        <div class="s3blue10">
          <img src="../assets/images/section3blue10.png" width="220px">
          <div id="text01">청휘석x100000</div>
        </div>
      </div>
      <div id="text2">2단계 20만명
        <div class="s3blue20">
          <img src="../assets/images/section3blue20.png" width="220px">
          <div id="text02">청휘석x200000</div>
        </div>
      </div>
      <div id="text3">3단계 30만명
        <div class="s3blue30">
          <img src="../assets/images/section3blue30.png" width="220px">
          <div id="text03">청휘석x300000</div>
        </div>
      </div>
      <div id="text4">4단계 40만명
        <div class="s3blue40">
          <img src="../assets/images/section3blue40.png" width="220px">
          <div id="text04">청휘석x400000</div>
        </div>
      </div>
      <div id="text5">5단계 50만명
        <div class="s3arurelation">
          <img src="../assets/images/section3arurelation.png" width="160" height="130">
          <div id="text05">★3아루x1</div>
        </div>
      </div>
      <div id="text6">6단계 60만명
        <div class="s3Kayokorelation">
          <img src="../assets/images/section3Kayokorelation.webp" width="160" height="130">
          <div id="text06">★3카요코x1</div>
        </div>
      </div>
    </div>
    <div class="s3Kayoko">
      <img src="../assets/images/section3Kayoko.png" alt="카요코" width="600px">
    </div>
    <div class="s3Aru">
      <img src="../assets/images/section3Aru.png" alt="아루" width="300px">
    </div>
    <div class="s3realtime">
      <img src="../assets/images/section3realtime.png" alt="실시간 출력 캐릭터" width="380px">
    </div>
    <div class="s3bubble">
      <img src="../assets/images/section3bubble.png" width="400px">
    </div>
    <div class="s3logo">
      <img src="../assets/images/section3logo.png">
    </div>
    <div class="s3writing">사전예약 누적 참여자 달성 보상!</div>
    <div id="s3app">
      <!-- 프로그레스 바와 마일스톤 표시 -->
      <div class="progress-container">
        <div class="s3progress" :style="{ width: progressPercent + '%' }"></div>
        <!-- 마일스톤 위치에 눈금 표시 -->
        <div v-for="(milestone, index) in milestones" :key="'milestone'+index" class="milestone" :style="{ left: (milestone / 6 * 100) + '%' }">
          <div v-if="index < milestones.length - 1" class="milestone-mark"></div> <!-- 6 눈금 제외 -->
          <div class="milestone-reached">{{ formatMilestone(milestone) }}</div>
          <div class="milestone-line"></div>
        </div>
      </div>
      <!-- 조건에 맞을 때 이미지를 보여주는 곳 -->
      <div id="imageContainer">
        <img v-for="(milestone, index) in milestonesReached" :key="index" :src="milestoneImageUrl" class="milestoneImage" :id="'milestone' + (index + 1)" :style="milestone.style" alt="">
      </div>
    </div>
    <div>
      <p class="s3mail">누적 사전예약 인원: {{ emailCount }}명!</p>
    </div>
  </div>
</template>
<script>
    export default {
    name: 'Section3',
    data() {
      return {
        emailCount: 0, // 현재 이메일 개수
        milestones: [1, 2, 3, 4, 5, 6 ], // 이메일 개수 구간
        milestonesReached: [],
        milestoneImageUrl: require('@/assets/images/section3Stamp.png'),
        progressPercent: 0, // 프로그레스 바 진행율
      };
    },
    created() {
      this.fetchEmailCount();
      this.startEmailCountInterval();
    },
    methods: {
      fetchEmailCount() {
        fetch('http://192.168.0.196:8080/emailCount')
          .then(response => response.json())
          .then(data => {
            this.emailCount = data;
            this.checkMilestones();
            // 이메일 개수에 따라 프로그레스 바 진행율 업데이트
            this.progressPercent = Math.min((this.emailCount / 6) * 100, 100);
          })
          .catch(error => {
            console.error('Error fetching email count:', error);
          });
      },
      startEmailCountInterval() {
        setInterval(this.fetchEmailCount, 5000);
      },
      checkMilestones() {
        this.milestonesReached = [];
        this.milestones.forEach((milestone, index) => {
          if (this.emailCount >= milestone) {
            this.milestonesReached.push({
              index: index,
              style: this.getMilestoneStyle(index + 1)
            });
          }
        });
      },
      getMilestoneStyle(index) {
        const positions = [
          { top: '365px', left: '-650px' },
          { top: '360px', left: '-435px' },
          { top: '360px', left: '-225px' },
          { top: '620px', left: '-650px' },
          { top: '620px', left: '-435px' },
          { top: '620px', left: '-225px' }
        ];
        return positions[index - 1];
      },
      formatMilestone(milestone) {
        return milestone + '명 달성!';
      },
    }
}
</script>
<style scoped>
/*Section3*/
@font-face {
  font-family: 'Ownglyph_meetme-Rg'; /* 글씨 폰트 */
  src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2402_1@1.0/Ownglyph_meetme-Rg.woff2') format('woff2');
  font-weight: normal;
  font-style: normal;
}
.s3board {
  position: absolute; /* 이미지 위치 고정 */
  top:150px;
  left:400px;
  transform: rotate(4deg); /* 이미지 회전 (원 이미지가 약간 기울어진 게시판) */
}
.s3notepad {
  position: absolute; /* 이미지 위치 고정 */
  top: 350px;
  left: 600px;
}
.s3text{
  font-family: 'Ownglyph_meetme-Rg'; /* 글씨 폰트 Section3만 적용*/
  font-size: 35px;
  font-weight: 300px;
  color: black
}
#text1 {
  position: absolute; /* 이미지 위치 고정 */
  top:395px;
  left:659px;
}
.s3blue10 {
  position: absolute; /* 이미지 위치 고정 */
  top:25px;
  left:-55px;
}
#text01 {
  position: absolute; /* 이미지 위치 고정 */
  top:148px;
  left:38px;
}
#text2 {
  position: absolute; /* 이미지 위치 고정 */
  top:395px;
  left:859px;
  color: rgb(211, 157, 11);
}
.s3blue20 {
  position: absolute; /* 이미지 위치 고정 */
  top:25px;
  left:-35px;
}
#text02 {
  position: absolute; /* 이미지 위치 고정 */
  top:146px;
  left:24px;
  color: rgb(211, 157, 11);
}
#text3 {
  position: absolute; /* 이미지 위치 고정 */
  top:386px;
  left:1066px;
  color: rgb(154, 238, 179);
}
.s3blue30 {
  position: absolute; /* 이미지 위치 고정 */
  top:35px;
  left:-35px;
}
#text03 {
  position: absolute; /* 이미지 위치 고정 */
  top:144px;
  left:24px;
  color: rgb(154, 238, 179);
}
#text4 {
  position: absolute; /* 이미지 위치 고정 */
  top:642px;
  left:653px;
  color: rgb(98, 110, 219);
}
.s3blue40 {
  position: absolute; /* 이미지 위치 고정 */
  top:18px;
  left:-40px;
}
#text04 {
  position: absolute; /* 이미지 위치 고정 */
  top:145px;
  left:15px;
  color: rgb(98, 110, 219);
}
#text5 {
  position: absolute; /* 이미지 위치 고정 */
  top:640px;
  left:859px;
  color: rgb(216, 109, 109);
}
.s3arurelation {
  position: absolute; /* 이미지 위치 고정 */
  top:48px;
  left:-9px;
}
#text05 {
  position: absolute; /* 이미지 위치 고정 */
  top:130px;
  left:29px;
  color: rgb(216, 109, 109);
}
#text6 {
  position: absolute; /* 이미지 위치 고정 */
  top:635px;
  left:1085px;
  color: rgba(66, 66, 66, 0.719);
}
.s3Kayokorelation {
  position: absolute; /* 이미지 위치 고정 */
  top:55px;
  left:-24px;
}
#text06 {
  position: absolute; /* 이미지 위치 고정 */
  top:127px;
  left:25px;
  color: rgba(66, 66, 66, 0.719);
}
.s3Kayoko {
  position: absolute; /* 이미지 위치 고정 */
  top: 65px;
  left: 100px
}
.s3Aru {
  position: absolute; /* 이미지 위치 고정 */
  top: 70px;
  left: 1300px;
}
.s3realtime {
  position: absolute; /* 이미지 위치 고정 */
  top: 45px;
  left: 890px;
}
.s3bubble {
  position: absolute; /* 이미지 위치 고정 */
  top: -5px;
  left: 1205px;
}
.s3logo {
  position: absolute; /* 이미지 위치 고정 */
  top: -20px;
  left: 500px;
}
#s3app {
  position: absolute; /* 이미지 위치 고정 */
  top: 10px;
  left: 1250px;
}

.milestoneImage {
  position: absolute;
  z-index: 999; /* 이미지를 화면 맨 앞으로 가져옵니다. */
  width: 250px;
  height: 250px;
}
.progress-container {
  position: relative;
  width: 700px;
  height: 10px;
  top:335px;
  left:-650px;
  background-color: #eee;
  border-radius: 8px;
}
.milestone {
  position: absolute;
  top: 0;
}

.milestone-reached {
  position: absolute;
  top: -30px; /* 프로그레스 바 위로 텍스트 이동 */
  transform: translateX(-50%); /* 가로 정렬을 위한 변환 */
  white-space: nowrap;
  padding: 2px 5px;
  border-radius: 5px;
  font-family: 'Ownglyph_meetme-Rg'; /* 글씨 폰트 Section3만 적용*/
  font-size: 20px;
  color: white;
}
.milestone-line {
  position: absolute;
  top: 0px; /* 프로그레스 바 위쪽으로 조금 더 올라가도록 설정 */
  height: 10px; /* 선의 높이, 프로그레스 바를 포함해서 위 아래로 확장될 수 있도록 설정 */
  width: 2px; /* 선의 너비 */
  background-color: black; /* 선의 색상, 원하는 색상으로 설정 */
  transform: translateX(-50%);
}

.milestone-mark {
  position: absolute;
  top: -20px; /* 프로그레스 바 위쪽으로 설정 */
  height: 0px; /* 눈금의 높이 */
  width: 2px; /* 눈금의 너비 */
  background-color: black; /* 눈금의 색상 */
  transform: translateX(-50%);
}

.s3progress {
  height: 10px;
  background-color: #00D6FA;
  border-radius: 8px;
  transition: width 0.5s ease-in-out;
}
.s3writing {
  position: absolute;
  top: 265px;
  left: 700px;
  font-family: 'Ownglyph_meetme-Rg'; /* 글씨 폰트 Section3만 적용*/
  font-size: 50px;
  font-weight: 300px;
  color: #FFFFFF;
}
.s3mail {
  position: absolute;
  top: 10px;
  left: 1259px;
  font-family: 'Ownglyph_meetme-Rg'; /* 글씨 폰트 Section3만 적용*/
  font-size: 35px;
  color: black;
  }

</style>