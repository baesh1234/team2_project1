<template>
  <div class="position-relative">
    <div id="fullpage">
      <div class="section s1" pageNum="1">
        <div class="section1">
          <div class="section1_header">
            <div class="section1_logo"></div>

            <div class="section1_headline">

              <!-- <p>블루 아카이브 100주년 기념 특설페이지</p> -->
            </div>
            <audio autoplay controls loop onloadstart="this.volume=0.5" class="section1_bgm">
              <source src="./assets/audio/ブルーアーカイブ Blue Archive OST 7. Unwelcome School.mp4" type="audio/mp3">
            </audio>

          </div>
          <div class="section1_space">

          </div>


          <div class="section1_PV">
            <iframe width="1080" height="540" src="https://www.youtube.com/embed/gMZ1BWFLDMw?si=zQNFoc5wwx7jMcVG" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
          </div>
        </div>



      </div>
      <div class="section s2">
        <img  src="./assets/images/section2Title.png" alt="titleImg" class="titleImg">
        <img src="./assets/images/section2Subbg.png" alt="초대장" class="subBg">
        <div  id="section2Form" class="row g-3">
          <input class="form-control col-auto" type="text" placeholder="이메일을 입력해주세요." name="email" required>
          <button type="submit" class="btn btn-primary col-auto" @click="s2emailBtn()">인증</button>
        </div>
        <p class="s2emailMsg">인증이 완료되었습니다.</p>
        <div class="container s2checkContainer">
          <input type='checkbox'
                 name='agreeall'
                 value='selectall'
                 @click='s2selectAllCheckbox($event)'/> <b>아래 내용을 확인하였으며,모두 동의 합니다.</b>
          <br />
          <input type='checkbox'
                 name='agree'
                 value='age'
                 @click='s2uncheckSelectAll()||s2checkSelectAll()'/> 만 14세 이상입니다.
          <br />
          <input type='checkbox'
                 name='agree'
                 value='personalInfo'
                 @click='s2uncheckSelectAll()||s2checkSelectAll()'/> 개인정보 수집 및 이용 동의
          <br />
          <input type='checkbox'
                 name='agree'
                 value='eventAgree'
                 @click='s2uncheckSelectAll()||s2checkSelectAll()'/> 이벤트 등 프로모션 알림 수신 동의
        </div>
        <a @click='s2AlertBtn()'><img src="./assets/images/s2submitButton.png" alt="submitBtnImg" class="s2submitBtn"></a>
      </div>
      <div class="section s3">
        <div class="s3board">
          <img src="./assets/images/section3board.png" alt="게시판"  width="1100px">
        </div>
        <div class="s3notepad">
          <img src="./assets/images/section3notepad.png" alt="메모장" width="700px">
        </div>
        <div class="s3text">
          <div id="text1">1단계 10만명
            <div class="s3blue10">
              <img src="./assets/images/section3blue10.png">
              <div id="text01">청휘석x100000</div>
            </div>
          </div>
          <div id="text2">2단계 20만명
            <div class="s3blue20">
              <img src="./assets/images/section3blue20.png">
              <div id="text02">청휘석x200000</div>
            </div>
          </div>
          <div id="text3">3단계 30만명
            <div class="s3blue30">
              <img src="./assets/images/section3blue30.png">
              <div id="text03">청휘석x300000</div>
            </div>
          </div>
          <div id="text4">4단계 40만명
            <div class="s3blue40">
              <img src="./assets/images/section3blue40.png">
              <div id="text04">청휘석x400000</div>
            </div>
          </div>
          <div id="text5">5단계 50만명
            <div class="s3arurelation">
              <img src="./assets/images/section3arurelation.png" width="180" height="150" alt="">
              <div id="text05">★3아루x1</div>
            </div>
          </div>
          <div id="text6">6단계 60만명
            <div class="s3Kayokorelation">
              <img src="./assets/images/section3Kayokorelation.webp" width="180" height="150">
              <div id="text06">★3카요코x1</div>
            </div>
          </div>
        </div>
        <div class="s3Kayoko">
          <img src="./assets/images/section3Kayoko.png" alt="카요코" width="600px">
        </div>
        <div class="s3Aru">
          <img src="./assets/images/section3Aru.png" alt="아루" width="300px">
        </div>
        <div class="s3realtime">
          <img src="./assets/images/section3realtime.png" alt="실시간 출력 캐릭터" width="380px">
        </div>
        <div class="s3bubble">
          <img src="./assets/images/section3bubble.png" width="400px">
        </div>
        <div class="s3logo">
          <img src="./assets/images/section3logo.png">
        </div>
        <div id="s3app">
          <!-- 숫자 입력 필드 -->
          <input v-model.number="number" type="number" placeholder="숫자를 입력하세요" class="s3input">
          <!-- 입력 버튼 -->
          <button @click="submitNumber" class="s3button">예약</button>
          <!-- 출력된 숫자 합계를 보여주는 곳 -->
          <div class="s3reservations"> 사전예약 인원 {{ total }} 명!</div>
          <!-- 조건에 맞을 때 이미지를 보여주는 곳 -->
          <div id="imageContainer">
            <img v-for="(milestone, index) in milestonesReached" :key="index" :src="milestoneImageUrl" class="milestoneImage" :id="'milestone' + (index + 1)" :style="milestone.style" alt="">
          </div>
        </div>
      </div>
      <div class="section s4">
        <div id="s4_upImage">
          <img src="./assets/images/section4_arona3.png" alt="이벤트 확인" id="section4_up" width="600px">
          <h2 class="section4_text">선생님 100주년 축하드려요! 기념이벤트 개최중이니 아래의 저를 눌러 내용을 확인해주세요!</h2>
        </div>
        <img id="s4_openLetterImg" src="./assets/images/section4_arona.jpg" alt="편지 열기" @click="toggleLetter()">
        <div id="s4_letterPopup">
          <button id="s4_closeButton" @click="toggleLetterX()">X</button> <!-- 닫기 버튼 -->
        </div>
        <div>
          <ul class="s4_commit">
            <li class="s4_commit_num1">
              <h2 class="s4_font">한줄평쓰기<span></span></h2>
              <div class="s4_ps_box">
                <input type="text" class="s4_int2" v-model="userPhone" placeholder="핸드폰 번호를 입력해주세요" maxlength="13" />
                <div class="s4_verification-status"></div>
                <button class="s4_verification-request-button" @click="onRequestVerification">인증 요청</button>
                <div class="verification-container">
                  <input type="text" class="verificationCode" v-model="userVerificationCode" placeholder="인증번호 입력">
                  <button class="s4_verify-button" @click="onVerify">인증번호 확인</button>
                  <div class="s4_verification-status"></div>
                </div>
                <input type="text" class="s4_int" v-model="userComment" placeholder="한줄평을 입력해주세요" />
              </div>
              <input type="submit" class="s4_btn" value="등록" @click="onSubmitComment" />
            </li>
            <li id="s4_commit_list" class="comment-board">
              <div v-for="comment in comments" :key="comment.id" class="comment">
                번호: {{ comment.id }} - 전화번호: {{ comment.phone }} - 한줄평: {{ comment.comment }} - 날짜: {{ comment.date }}
              </div>
            </li>
          </ul>
        </div>
      </div>
      <div class="section s5" pageNum="5">


        <div class="section5_wrapper">
          <div class="section5_arona"></div>
          <div class="section5_plana"></div>

          <div class="section5_header">
            <div class="secstion5_top">
              <h1>SNS 공유 이벤트</h1>
              <h3>블루 아카이브 소식을 공유하고 선물도 받자!</h3>
            </div>
          </div>


          <div class="secstion5_explain">
            <div class="secstion5_board">
              <br><br><br>
              100주년 맞이 SNS 공유 이벤트를 개최합니다!<br><br>
              1.아래 3가지 SNS를 들어가서 100주년 이벤트를 공유해주세요!<br><br>
              2.공유 게시글에 응원 메세지와 유저 id를 남겨주세요!<br><br>
              3.이벤트 기간동안에 공유해주신 유저분들을 대상으로 푸짐한 <br>보상을 드립니다!
            </div>


          </div>

          <div class="secstion5_social">
            <div class="secstion5_imoticon1"><img src="./assets/images/물루.gif" alt="" width="80px" height="80px"></div>
            <div class="secstion5_sns1" ><img src="./assets/images/instagram.png" alt="" width="60px" height="60px" no-repeat>instagram<br>&nbsp;</div>
            <div class="secstion5_sns2" ><img src="./assets/images/xlogo.png" alt="" width="60px" height="60px" no-repeat>x<br>(前 트위터)</div>
            <div class="secstion5_sns3" ><img src="./assets/images/blueachive.png" alt="" width="60px" height="60px" no-repeat><br>블루아카<br> 커뮤니티</div>
            <div class="secstion5_imoticon2"><img src="./assets/images/아루.gif" alt="" width="80px" height="80px"></div>


          </div>




          <div class="secstion5_present">
            <div class="secstion5_gift1">
              <img src="./assets/images/starbuks.jpeg" alt="" width="170px" height="170px"><br>스타벅스 기프티콘<br>100명
            </div>

            <div class="secstion5_gift2">
              <img src="./assets/images/figure.webp" alt="" width="170px" height="170px"><br>아로나 피규어<br>1명
            </div>

            <div class="secstion5_gift3">
              <img src="./assets/images/giftcard.jpg" alt="" width="170px" height="170px"><br>구글기프트카드 10만원<br>10명
            </div>
          </div>

          <div class="section5_back">

          </div>

        </div>

      </div>
    </div>
  </div>

  <!--  <router-view/>-->
</template>

<script>
  export default {
    mounted() {
      new fullpage('#fullpage', {
        sectionSelector: '.section',
        scrollOverflow: true,
        navigation: true,
        scrollingSpeed: 1000,
        anchors: ['section1','section2', 'section3', 'section4', 'section5'],
      });
    },
    data() {
      return {
        number: 0,
        total: 0,
        milestones: [100000, 200000, 300000, 400000, 500000, 600000],
        milestonesReached: [],
        milestoneImageUrl: require('@/assets/images/section3Stamp.png')
      };
    },
    methods: {
      /***Section2 function***/
      s2selectAllCheckbox(event) {
        const checkboxes = document.querySelectorAll('input[name="agree"]');
        checkboxes.forEach((checkbox) => {
          checkbox.checked = event.target.checked;
        });
      },
      //모두 선택되었을때 개별체크박스가 해제되면 전체선택체크박스를 해제하는 함수
      s2uncheckSelectAll() {
        // 전체 선택 체크박스를 가져옵니다.
        const selectAllCheckboxes = document.querySelectorAll('input[value="selectall"]');
        // 모든 전체 선택 체크박스에 대해 반복합니다.
        selectAllCheckboxes.forEach((selectAllCheckbox) => {
          // 만약 전체 선택 체크박스가 선택되어 있다면 실행합니다.
          if (selectAllCheckbox.checked) {
            // 모든 개별 체크박스를 가져옵니다.
            const checkboxes = document.querySelectorAll('input[name="agree"]');
            let allChecked = true;
            // 각 개별 체크박스를 확인하여 모두 선택되었는지 확인합니다.
            checkboxes.forEach((checkbox) => {
              if (!checkbox.checked) {
                allChecked = false;
              }
            });
            // 개별 체크박스 중 하나라도 선택되지 않은 경우 전체 선택 체크박스를 해제합니다.
            if (!allChecked) {
              selectAllCheckbox.checked = false;
            }
          }
        });
      },
      //모든 개별 체크박스가 선택되었을 때 전체 선택 체크박스를 체크하는 함수
      s2checkSelectAll() {
        const selectAllCheckboxes = document.querySelectorAll('input[value="selectall"]');
        selectAllCheckboxes.forEach((selectAllCheckbox) => {
          // 만약 전체 선택 박스가 체크 해제되어 있다면 실행합니다.
          if (!selectAllCheckbox.checked) {
            // 모든 개별 체크박스를 가져옵니다.
            const checkboxes = document.querySelectorAll('input[name="agree"]');
            let allChecked = true;
            // 모든 개별 체크박스에 대해 반복합니다.
            checkboxes.forEach((checkbox) => {
              // 만약 하나라도 체크되지 않은 상태라면 모든 체크박스가 선택되지 않은 것으로 표시합니다.
              if (!checkbox.checked) {
                allChecked = false;
              }
            });
            // 모든 개별 체크박스가 선택되어 있다면 전체 선택 체크박스를 체크합니다.
            if (allChecked) {
              selectAllCheckbox.checked = true;
            }
          }
        });
      },
      //이메일 인증 버튼
      s2emailBtn(){
        const emailMsg = document.querySelector('.s2emailMsg');
        emailMsg.style.display = 'block';
      },
      //사전예약 등록 버튼 alert 출력
      s2AlertBtn(){
        const emailMsg = document.querySelector('.s2emailMsg');
        const emailVerified = emailMsg.style.display === 'block';
        const selectAllCheckbox = document.querySelector('input[value="selectall"]');
        const allAgreed = selectAllCheckbox.checked;

        if (emailVerified && allAgreed) {
          // SweetAlert2로 'O' 알림을 출력하고, 확인 버튼을 누르면 다음 섹션으로 이동합니다.
          Swal.fire({
            icon: 'success',
            title: '모든 조건이 충족되었습니다.',
            showConfirmButton: true,
          }).then(() => {
            // alert의 확인버튼을 누를시 section3으로 이동
            // section3으로 이동합니다.
            fullpage_api.moveTo(4);
            console.log('slide');
          });
        } else {
          // SweetAlert2로 'X' 알림을 출력합니다.
          Swal.fire({
            icon: 'error',
            title: '이메일 인증이 완료되었고 모든 항목에 동의해야 합니다.',
            showConfirmButton: false,
            timer: 1500, // 1.5초 후에 자동으로 닫힙니다.
          });
        }
      },

      /***Section3 function***/
      submitNumber: function() {
        this.total += this.number;
        this.checkMilestones();
        this.number = 0;
      },
      checkMilestones: function() {
        this.milestonesReached = []; // 기존 이미지 초기화
        this.milestones.forEach((milestone, index) => {
          if (this.total >= milestone) {
            this.milestonesReached.push({
              index: index,
              style: this.getMilestoneStyle(index + 1)
            });
          }
        });
      },
      getMilestoneStyle: function(index) {
        const positions = [
          {top: '330px', left: '-640px'},
          {top: '330px', left: '-410px'},
          {top: '330px', left: '-180px'},
          {top: '600px', left: '-640px'},
          {top: '600px', left: '-410px'},
          {top: '600px', left: '-180px'}
        ];
        return positions[index - 1];
      },

      /***Section4 function***/
      toggleLetter() {
        const letter = document.querySelector('#s4_letterPopup');
        letter.style.display = 'block';
      },
      toggleLetterX() {
        const letter = document.querySelector('#s4_letterPopup');
        letter.style.display = 'none';
      },
      onRequestVerification() {
        if (this.userPhone.trim() === "") {
          alert("핸드폰 번호를 입력해주세요.");
        } else {
          this.verificationCode = this.generateVerificationCode();
          console.log("Generated Verification Code: " + this.verificationCode); // 콘솔에 인증번호 로깅
          alert("인증번호가 전송되었습니다. 개발자 도구의 콘솔을 확인하세요.");
        }
      },
      onVerify() {
        if (this.userVerificationCode.trim() === "") {
          alert("인증번호를 입력해주세요.");
        } else if (this.userVerificationCode === this.verificationCode) {
          alert("인증 성공!");
          this.isVerified = true;
        } else {
          alert("인증번호가 일치하지 않습니다. 다시 시도해주세요.");
        }
        this.userVerificationCode = "";
      },
      onSubmitComment() {
        if (!this.isVerified) {
          alert("먼저 핸드폰 인증을 완료해주세요.");
          return;
        }
        if (this.userPhone.trim() === "") {
          alert("핸드폰 번호를 입력해주세요.");
          return;
        }
        if (this.userComment.trim() === "") {
          alert("한줄평을 입력해주세요.");
          return;
        }
        const currentDate = new Date().toLocaleString();
        this.comments.push({
          id: this.commentId++,
          phone: this.maskPhoneNumber(this.userPhone),
          comment: this.userComment,
          date: currentDate
        });
        this.userComment = "";
        this.userPhone = "";
      },
      generateVerificationCode() {
        return Math.floor(100000 + Math.random() * 900000).toString(); // 6자리 랜덤 숫자 생성
      },
      maskPhoneNumber(phoneNumber) {
        const cleaned = phoneNumber.replace(/\D/g, ''); // 숫자만 추출
        const matched = cleaned.match(/^(\d{3})(\d{4})(\d{4})$/);
        return matched ? `${matched[1]}-XXXX-${matched[3]}` : phoneNumber;
      }
    }
  }
</script>

<style>
  /*All*/
  .section { /*배경화면*/
    background-image: url('assets/images/bgImg.jpg');
    height: 100%;
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
  }
  .form-control {
    margin-right: 1rem;
  }

  /*Section１*/
  .section1{
    text-align: center;
  }

  .section1_header{
    position: relative;
  }

  .section1_logo{
    position: absolute;
    width: 320px;
    height: 110px;
    background-image: url('assets/images/blueachalogo.png');
    background-repeat: no-repeat;
    background-size: cover;
    left: 0; top: 0; margin: 0 auto;
  }


  .section1_headline{
    width: 841px; height: 474px;
    background-image: url('assets/images/blueachive2.png');
    position: absolute;
    right: 0; left: 0%; margin: 0 auto;
  }

  .section1_bgm{
    position: absolute;
    right: 0; top: 0; margin: 0 auto;
  }

  .section1_space{
    width: 1280px; height: 400px;
  }

  .section1_pv{


    right: 0; left: 0%; top: 0; bottom: 0; margin: 0 auto;

  }
  /*Section2*/
  .titleImg {
    position: absolute;
    width: 40rem;
    top: 3%;
    left: 3%;
    z-index: 1;
  }
  .subBg {
    position: absolute;
    width: 100rem;
    z-index: 0;
    top: 5rem;
    left: 6rem;
  }
  #section2Form {
    position: absolute;
    left: 30rem;
    top: 20rem;
    z-index: 2;
    flex-wrap: nowrap;
    width : 50rem;
  }
  .s2submitBtn {
    position: absolute;
    z-index: 2;
    width : 30rem;
    bottom: 100px;
    left: 650px;
  }
  .s2checkContainer {
    position: absolute;
    z-index: 2;
    left: 470px;
    top: 400px;
  }
  .s2emailMsg{
    display: none;
    position: absolute;
    left: 480px;
    top: 366px;
    color : #007bff;
  }

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
    top: 300px;
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
    top:360px;
    left:665px;
  }
  .s3blue10 {
    position: absolute; /* 이미지 위치 고정 */
    top:15px;
    left:-55px;
  }
  #text01 {
    position: absolute; /* 이미지 위치 고정 */
    top:170px;
    left:40px;
  }
  #text2 {
    position: absolute; /* 이미지 위치 고정 */
    top:360px;
    left:880px;
    color: rgb(211, 157, 11);
  }
  .s3blue20 {
    position: absolute; /* 이미지 위치 고정 */
    top:15px;
    left:-50px;
  }
  #text02 {
    position: absolute; /* 이미지 위치 고정 */
    top:170px;
    left:40px;
    color: rgb(211, 157, 11);
  }
  #text3 {
    position: absolute; /* 이미지 위치 고정 */
    top:350px;
    left:1105px;
    color: rgb(154, 238, 179);
  }
  .s3blue30 {
    position: absolute; /* 이미지 위치 고정 */
    top:25px;
    left:-50px;
  }
  #text03 {
    position: absolute; /* 이미지 위치 고정 */
    top:170px;
    left:40px;
    color: rgb(154, 238, 179);
  }
  #text4 {
    position: absolute; /* 이미지 위치 고정 */
    top:620px;
    left:665px;
    color: rgb(98, 110, 219);
  }
  .s3blue40 {
    position: absolute; /* 이미지 위치 고정 */
    top:10px;
    left:-70px;
  }
  #text04 {
    position: absolute; /* 이미지 위치 고정 */
    top:180px;
    left:35px;
    color: rgb(98, 110, 219);
  }
  #text5 {
    position: absolute; /* 이미지 위치 고정 */
    top:620px;
    left:880px;
    color: rgb(216, 109, 109);
  }
  .s3arurelation {
    position: absolute; /* 이미지 위치 고정 */
    top:45px;
    left:-15px;
  }
  #text05 {
    position: absolute; /* 이미지 위치 고정 */
    top:150px;
    left:35px;
    color: rgb(216, 109, 109);
  }
  #text6 {
    position: absolute; /* 이미지 위치 고정 */
    top:620px;
    left:1120px;
    color: rgba(66, 66, 66, 0.719);
  }
  .s3Kayokorelation {
    position: absolute; /* 이미지 위치 고정 */
    top:45px;
    left:-27px;
  }
  #text06 {
    position: absolute; /* 이미지 위치 고정 */
    top:150px;
    left:32px;
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
  .s3reservations {
    font-family: 'Ownglyph_meetme-Rg'; /* 글씨 폰트 Section3만 적용*/
    font-size: 20px;
    font-weight: 300px;
    color: black;
  }
  .s3input{
    font-family: 'Ownglyph_meetme-Rg'; /* 글씨 폰트 Section3만 적용*/
    font-size: 20px;
    font-weight: 300px;
    color: #FFFFFF;
    background-color: #00D6FA;
    border:1px solid #FFFFFF;
    border-radius: 10px;

  }
  .s3button{
    font-family: 'Ownglyph_meetme-Rg'; /* 글씨 폰트 Section3만 적용*/
    font-size: 20px;
    font-weight: 300px;
    color: #FFFFFF;
    background-color: #00D6FA;
    border:1px solid #FFFFFF;
    border-radius: 10px;
  }

  /*Section4*/
  .s4_commit{
    position: absolute;
    top: -20px;
    display:flex;
    left: 25cm;
    padding: 30px;
    width: 600px;
    flex-wrap: nowrap;
  }

  .s4_commit > li {
    margin-top: 120px;
    right: 100px;
  }

  .s4_commit > li:nth-child(1){
    margin: 0px;
    right: 100px;
  }

  .commit-row {
    right: 100px;
    display: flex;
    justify-content: space-between;
    flex-direction: row;
  }

  .commit-row {
    margin-top: 20px;
    width: 100%;
  }

  .commit-row > li:nth-child(2){
    flex-shrink: 0;
    flex-grow: 1;
    padding-left: 25px;
    z-index: 1;
    width: 100%;
  }

  .s4_commit_num1 > form {
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    justify-content: space-between;
  }

  .s4_commit_num1 > form > h2 {
    position: absolute;
    bottom: -65px;
    left: 20px;
    width: 100%;
    margin: 14px 0 14px 0;
  }

  .commit-content {
    cursor: pointer;
    word-break: break-all;
    padding-right: 25px;
  }

  .s4_ps_box > input {
    outline: none;
  }

  .s4_int {
    display: block;
    position: absolute;
    top: 115px;
    right: 78px;
    width: 85%;
    height: 50px;
    padding-right: 25px;
    line-height: 29px;
    border: 1px solid black;
    background: #fff;
    font-size: 30px;
    box-sizing: border-box;
    z-index: 10;
  }

  .s4_btn {
    position: absolute;
    left: 585px;
    top: 115px;
    width: 18%;
    padding: 18px 0 16px;
    text-align: center;
    box-sizing: border-box;
    text-decoration: none;
    border: none;
    background: #333;
    color: #fff;
    font-size: 14px;
    border-radius: 4px;
    cursor: pointer;
  }

  #s4_commit_list{
    position: absolute;
    top: 50px;
    background-color: white;
    border: 1px solid black;
    position: absolute;
    right: 376px;
  }

  .s4_int2 {
    position: absolute;
    width: 200px;
    right: 78px;
    top: 35px;
    height: 30px;
    font-size: 15px;
  }

  .s4_font{
    position: absolute;
    font-size: 65px;
    bottom: -105px;
    right: 312px;
  }

  .comment-board {
    position: absolute;
    top: 50px;
    left: 21px;
    width: 660px; /* 원하는 너비로 조정하세요 */
    height: 720px;
    max-height: 720px; /* 댓글 목록이 너무 길어지지 않도록 최대 높이 지정 */
    overflow-y: auto; /* 댓글 목록이 너무 길어질 때 스크롤바 표시 */
    background-color: white;
    border: 1px solid black;
    padding: 10px;
    background-image: url('assets/images/section4_arona6.jpg');
    background-size: cover;
    font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
  }

  .comment {
    margin-bottom: 10px; /* 각 댓글 사이의 간격 조정 */
  }

  .comment .user {
    font-weight: bold; /* 댓글 작성자 이름을 굵게 표시 */
  }

  .comment .content {
    margin-left: 10px; /* 댓글 내용을 작성자 이름과 구분하기 위해 여백 추가 */
  }

  .phone-input-container {
    display: flex;
    align-items: center;
  }

  .phone-input {
    flex: 1; /* 입력란이 남은 공간을 차지하도록 함 */
    margin-right: 10px; /* 입력란과 버튼 사이의 간격 조정 */
  }

  .s4_verification-request-button {
    position: absolute;
    top:35px;
    right: -6px;
    padding: 8px 12px;
    background-color: #007bff;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
  }

  .verification-container {
    display: flex;
    position: absolute;
    right: 46px;
    top:68px;
    align-items: center;
    gap: 10px;
    height: 50px;
  }

  .verificationCode {
    position: absolute;
    width: 200px;
    right: 32px;
    flex-grow: 1;
    height: 30px;
    font-size: 15px;
  }

  .s4_verify-button {
    position: relative;
    left: 90px;
    padding: 8px 12px;
    background-color: #007bff;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    display:block;
    justify-content: center;
    text-align:center;
  }

  /* section4 main css */


  /*Section５*/

  .section5_wrapper{
    position: relative;
    margin: 0 auto;
  }

  .section5_header{

    display: flex;
    justify-content: center;
    line-height: 20px;

    text-shadow: -1px 0px aqua, 0px 1px aqua, 1px 0px aqua, 0px -1px aqua;
    font-size: 150%;
    font-weight: 300;
  }
  .secstion5_top{
    margin:0 auto;

    font-family: Arial, Helvetica, sans-serif;
    color: blue;
  }



  .secstion5_explain{

    display: flex;
    justify-content: center;
  }
  .secstion5_explain>div{
    width: 720px; height: 480px;

  }

  .secstion5_board{
    background-image: url(assets/images/board2.png);
    background-size: cover;
    background-repeat: no-repeat;

    padding-left: 50px;

    /* text-shadow: -1px 0px aqua, 0px 1px aqua, 1px 0px aqua, 0px -1px aqua; */
    font-size: 20px;
    font-weight: 600;
    color: azure;
  }

  .secstion5_social{

    margin: 10px;
    text-align: center;
    display: block;
    text-shadow: -1px 0px yellow, 0px 1px yellow, 1px 0px yellow, 0px -1px yellow;
    font-weight: 400;

    color: blue;

  }
  .secstion5_social>div{
    margin-left: 20px; margin-right: 20px;
    display: inline-block;
    width: 50px; height: 70px;


  }
  .secstion5_sns1{
    font-size: 10px;
  }

  .secstion5_sns2{
    font-size: 10px;
  }

  .secstion5_sns3{
    font-size: 10px;
  }

  .secstion5_present{

    text-align: center;

  }
  .secstion5_present>div{
    background-color: rgb(0,255,255, 0.5);
    margin-left: 10px; margin-right: 10px;

    display: inline-block;
    width: 150px; height: 150px;
  }
  .secstion5_gift1{
    background-image: url(assets/images/gift.com.png);
    background-size: cover;
    background-repeat: no-repeat;

    text-shadow: -1px 0px yellow, 0px 1px yellow, 1px 0px yellow, 0px -1px yellow;
    font-weight: 400;
    font-size: 15px;
    color: blue;
  }
  .secstion5_gift2{
    background-image: url(assets/images/gift.com.png);
    background-size: cover;
    background-repeat: no-repeat;

    text-shadow: -1px 0px yellow, 0px 1px yellow, 1px 0px yellow, 0px -1px yellow;
    font-weight: 400;
    font-size: 15px;
    color: blue;
  }
  .secstion5_gift3{
    background-image: url(assets/images/gift.com.png);
    background-size: cover;
    background-repeat: no-repeat;

    text-shadow: -1px 0px yellow, 0px 1px yellow, 1px 0px yellow, 0px -1px yellow;
    font-weight: 400;
    font-size: 14px;
    color: blue;
  }



  .section5_arona{
    width: 410px; height: 290px;
    background-image: url("assets/images/아로나.png");
    background-size: cover;
    background-repeat: no-repeat;
    position: absolute;
    left:0; bottom: 0;
  }

  .section5_plana{
    width: 410px; height: 290px;
    background-image: url("assets/images/프라나.png");
    background-size: cover;
    background-repeat: no-repeat;

    position: absolute;
    right: 0; bottom: 0;
  }


  .navbar-and-event {
    display: flex;
    align-items: center; /* 수직 가운데 정렬 */
  }

  head{
    position: relative;
    margin-top: 0;
  }


  .event-description img {
    position: absolute;
    max-width: 150%; /* 이미지가 요소의 너비를 벗어나지 않도록 설정 */
  }

  #s4_letterPopup {
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);
    width: 1500px;
    height: 850px;
    background: url('assets/images/section4_arona4.jpg') no-repeat center center;
    background-size: cover;
    padding: 20px;
    box-sizing: border-box;
    color: black;
    font-family: 'Courier New', Courier, monospace;
    z-index: 1000;
    display: none;
  }
  #s4_closeButton {
    position: absolute;
    top: 10px;
    right: 10px;
    background: none; /* 배경 없음 */
    border: none; /* 테두리 없음 */
    cursor: pointer;
    font-size: 24px;
    color: white; /* X의 색상 설정 */
  }
  #s4_openLetterImg {
    position: absolute;
    left: 210px;
    top: 470px;
    cursor: pointer;
    width: 700px; /* 이미지 크기 조정 필요 */
    transition: transform 0.3s ease, box-shadow 0.3s ease; /* 부드러운 효과를 위한 전환 */
    border-radius: 30%;
  }
  #s4_openLetterImg:hover {
    transform: scale(1.05); /* 이미지를 조금 확대 */
    box-shadow: 0 0 20px 5px rgba(255, 255, 255, 0.75); /* 빛나는 효과 */
  }

  #s4_upImage{
    position: absolute;
    left: 450px;
    top: 5px;
  }

  #section4_up{
    position: relative;
    border-radius: 5%;
    right: 200px;
  }

  .section4_text{
    background-color: white;
    position: absolute;
    bottom:-20px;
    left: -200px;
    width: 600px;
    font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
    color: #1c96dd;
    font-size: 25px;
    border-radius: 5%;
    text-align: center;
  }

  /*fullpage nav 재정의*/

  #fp-nav.fp-right {
    right: 5%; /*네비바 오른쪽 여백*/
  }
  #fp-nav ul li {
      margin: 5rem;
      z-index: 2000;
  }
  #fp-nav ul li a span {
    background: unset;
  }

  #fp-nav ul li a {
    width: 4rem; /* 내비게이션 아이템의 너비 설정 */
    height: 4rem; /* 내비게이션 아이템의 높이 설정 */
    background-image: url('https://item.kakaocdn.net/do/4155f71e3350f0ee40ffde6dcdcb2804d0bbab1214a29e381afae56101ded106'); /* 배경 이미지 설정 */
    background-size: cover; /* 배경 이미지를 아이템에 맞게 조정 */
  }

  #fp-nav ul li a.active {
    width: 4rem; /* 내비게이션 아이템의 너비 설정 */
    height: 4rem; /* 내비게이션 아이템의 높이 설정 */
    background-image: url('https://item.kakaocdn.net/do/4155f71e3350f0ee40ffde6dcdcb2804f604e7b0e6900f9ac53a43965300eb9a'); /* 배경 이미지 설정 */
    background-size: cover; /* 배경 이미지를 아이템에 맞게 조정 */
  }
</style>