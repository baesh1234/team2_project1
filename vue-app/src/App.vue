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
            <audio data-autoplay data-keepplaying controls loop onloadstart="this.volume=0.5" class="section1_bgm">
              <source src="https://epsilon.vgmsite.com/soundtracks/blue-archive-gamerip/pgcasqoumy/07%20Mitsukiyo%2005%20Unwelcome%20School.mp3" type="audio/mp3">
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
          <div class="s3reservations"> 누적 사전예약 인원 {{ total }} 명!</div>
          <!-- 조건에 맞을 때 이미지를 보여주는 곳 -->
          <div id="imageContainer">
            <img v-for="(milestone, index) in milestonesReached" :key="index" :src="milestoneImageUrl" class="milestoneImage" :id="'milestone' + (index + 1)" :style="milestone.style" alt="">
          </div>
        </div>
      </div>
      <div class="section s4">
        <div>
          <img src="./assets/images/section4_arona_final.png" class="s4_board">
          <input type="text" class="s4_int2" placeholder="사전예약한 이메일을 입력해주세요" v-model="userEmail" maxlength="50" />
          <img src="./assets/images/s4_btn.png" class="s4_btn" @click="s4_btn">
          <img src="./assets/images/s4_emailBtn.png" class="s4_emailBtn" @click="s4_emailBtn">
          <p class="s4emailMsg">인증이 완료되었습니다.</p>
          <img src="./assets/images/s4_arona_raund.png" class="s4_raund">
          <div class="s4_triangleMenu" @click="toggleImageSelector"></div> <!-- 역삼각형 메뉴 추가 -->
          <input type="text" class="s4_int" v-model="s4_usermemo" placeholder="응원 메세지를 입력해주세요" />
          <!-- 응원 메시지가 등록된 경우에만 메시지를 표시합니다. -->
          <!-- 응원 메시지가 등록된 경우에만 메시지를 표시합니다. -->
          <p class="s4_message" v-if="cheerMessage">{{ cheerMessage.message }}</p>
          <img class="s4_message-image" v-if="cheerMessage" :src="require(`./assets/images/${cheerMessage.image}`)" :alt="cheerMessage.image">
          <img src="./assets/images/s4_cheerBtn.png" class="s4_cheerBtn" @click="s4_cheerBtn">
          <div v-show="showImageSelector" class="imageSelector">
            <div v-for="(image, index) in images" :key="index" @click="selectImage(image)">
              <img :src="require(`./assets/images/${image}`)" :alt="image">
            </div>
          </div>
          <div>
            <div id="s4_letterPopup">
              <button id="s4_closeButton" @click="toggleLetterX()">X</button> <!-- 닫기 버튼 -->
            </div>
          </div>
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
        milestoneImageUrl: require('@/assets/images/section3Stamp.png'),
        userEmail: '',
        userMessage: '',
        emailVerified: false,
        s4_usermemo: '',
        // 이미지 선택기 표시 여부
        showImageSelector: false,
        // 선택된 이미지 파일명
        selectedImage: null,
        // 선택한 이미지 파일명
        images: ["s4_arona_raund.png", "s4_mika.png", "s4_toki.png"],
        // 응원 메시지 및 등록 날짜 및 시간
        // 이전에는 하나의 응원 메시지만 표시했지만 이제는 여러 메시지를 저장할 배열을 만듭니다.
        cheerMessages: [],
        // 이전 코드에서는 선택된 이미지를 저장하는 selectedImage 변수를 사용했습니다.
        // 이제는 이미지와 메시지를 함께 저장하는 객체를 사용합니다.
        selectedCheerMessage: null,
        // 다음 메시지를 위한 입력 필드를 초기화하는 플래그
        clearInputField: false,
        registrationDateTime: ''
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
      async fetchImages() {
        try {
          const response = await fetch('/images/list');
          const images = await response.json();
          this.images = images;
        } catch (error) {
          console.error('이미지를 불러오는데 실패했습니다.', error);
        }
      },
      // 한 줄평 등록 버튼 클릭 시
      s4_btn() {
        if (this.s4_usermemo) { // 응원 메시지가 정상적으로 입력되었는지 검사합니다.
          this.submitMessage(); // 응원 메시지 등록 처리
        } else {
          // 응원 메시지가 입력되지 않은 경우 에러 메시지 출력
          Swal.fire({
            text: '한 줄평을 입력해주세요.',
            icon: 'error',
            timer: 2000
          });
        }
      },
      // 이메일 인증 버튼
      s4_emailBtn() {
        this.emailVerified = true;
        this.showEmailMessage();
      },

      // 응원 메시지 입력 후 등록 날짜 설정
      setRegistrationDateTime() {
        this.registrationDateTime = new Date().toLocaleString();
      },
      // 응원 메시지 등록 처리 메서드
      async submitMessage() {

        // 이미지 선택 여부 확인
        if (!this.selectedImage) {
          // 이미지가 선택되지 않은 경우 기본 이미지를 설정합니다.
          this.selectedImage = "s4_default_image.png"; // 기본 이미지 파일명으로 설정
        }

        // 이메일이 인증되었는지 확인
        if (!this.emailVerified) {
          // 이메일이 인증되지 않은 경우
          console.error('이메일 인증이 완료되지 않았습니다.');
          Swal.fire({
            text: '이메일 인증이 완료되어야 합니다.',
            icon: 'error',
            timer: 2000
          });
          return; // 함수 종료
        }

        // 이메일과 메시지가 입력되었는지 확인
        if (!this.userEmail || !this.s4_usermemo) {
          console.error('이메일과 메시지를 입력해야 합니다.');
          Swal.fire({
            text: '이메일과 메시지를 입력해야 합니다.',
            icon: 'error',
            timer: 2000
          });
          return; // 함수 종료
        }

        // 모든 조건이 충족되었을 때 실행되는 부분
        // 서버 요청 대신에 콘솔에 응원 메시지 출력
        console.log('User Email:', this.userEmail);
        console.log('User Message:', this.s4_usermemo);
        this.setRegistrationDateTime(); // 등록 날짜 및 시간 설정
        console.log('Registration Date Time:', this.registrationDateTime);
        this.cheerMessages.push({
          message: this.s4_usermemo,
          image: this.selectedImage,
          registrationDateTime: this.registrationDateTime // 등록된 날짜를 사용합니다.
        });
        // 입력 필드를 초기화합니다.
        this.s4_usermemo = '';
        this.clearInputField = true;
        // 등록된 응원 메시지를 표시합니다.
        this.showCheerMessages();
      },
      // ...
      // 등록된 응원 메시지를 표시하는 메서드
      showCheerMessages() {
        // 입력 필드가 초기화되면서 새로운 응원 메시지가 추가되었으므로 스크롤을 가장 아래로 조정합니다.
        this.scrollToBottom();
      },
      // 응원 메시지 입력 후 스크롤을 가장 아래로 조정하는 메서드
      scrollToBottom() {
        const cheerMsg = document.querySelector('.cheerMsg');
        if (cheerMsg) {
          cheerMsg.scrollTop = cheerMsg.scrollHeight;
        }
      },

      // 응원 메시지 입력 후 SweetAlert 표시
      showEmailMessage() {
        Swal.fire({
          text: '인증이 완료되었습니다.',
          icon: 'success',
          timer: 2000
        }).then(() => {
          // SweetAlert 알림이 사라진 후에 텍스트를 나타내도록 setTimeout 사용
          setTimeout(() => {
            const emailMsg = document.querySelector('.s4emailMsg');
            emailMsg.style.display = 'block';
          }, 100);
        });
      },
      // 응원 메시지 팝업 표시
      s4_cheerBtn() {
        const letter = document.querySelector('#s4_letterPopup');
        letter.style.display = 'block';
      },
      // 응원 메시지 팝업 닫기
      toggleLetterX() {
        const letter = document.querySelector('#s4_letterPopup');
        letter.style.display = 'none';
      },
      // 응원 메시지 표시 후 스크롤을 가장 아래로 조정
      showCheerMessage() {
        const cheerMsg = document.querySelector('.s4_int');
        cheerMsg.scrollTop = cheerMsg.scrollHeight;
      },
      // 이미지 선택기 토글 메서드
      toggleImageSelector() {
        this.showImageSelector = !this.showImageSelector;
      },
      // 이미지 선택 시 호출되는 메서드
      selectImage(selectedImage) {
        console.log('선택된 이미지:', selectedImage);
        this.selectedImage = selectedImage;
        // 이미지 크기 조정 로직을 이미지 선택기를 닫기 전에 호출
        this.adjustImageSelectorSize(selectedImage);
        this.showImageSelector = false; // 이미지를 선택하면 선택기를 닫습니다.

        // 이미지를 선택한 후 해당 이미지를 화면에 반영하기 위해
        // .s4_raund 클래스를 가진 요소에 선택된 이미지를 바인딩합니다.
        const imageElement = document.querySelector('.s4_raund');
        if (imageElement) {
          imageElement.src = require(`./assets/images/${selectedImage}`);
        }
      },
      // 이미지 선택기의 크기를 조정하는 새로운 메서드
      adjustImageSelectorSize(selectedImage) {
        const img = new Image();
        img.src = require(`./assets/images/${selectedImage}`);
        img.onload = () => {
          const imageSelector = document.querySelector('.imageSelector');
          if (!imageSelector) {
            console.error('.imageSelector 요소를 찾을 수 없습니다.');
            return;
          }
          imageSelector.style.width = img.width + 'px';
          imageSelector.style.height = img.height + 'px';
        };
      },
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
    top: 30px;
    position: absolute;
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

  .s4_board{
    position: absolute;
    width: 80%; /* 이미지의 너비를 부모 요소의 100%로 설정합니다. */
    height: auto; /* 이미지의 높이를 자동으로 조정하여 비율을 유지합니다. */
    top: 50px;
    left: 100px;
    object-fit: contain; /* 이미지가 요소에 맞게 확대되거나 축소되도록 설정합니다. */
    border-radius: 3%;
  }

  .s4_int{
    position: absolute;
    width: 450px;
    z-index: 2000;
    bottom: 130px;
    right: 340px;
    height: 50px;
    font-size: 15px;
    border-radius: 25px; /* 보다 둥근 형태를 위해 반지름 값을 조정합니다. */
    border: 2px solid #4A89C3; /* 테두리 스타일 및 색상을 지정합니다. */
    padding: 0 15px; /* 입력 필드 내용과 테두리 사이의 여백을 조정합니다. */
    outline: none; /* 포커스된 상태에서의 외곽선을 제거합니다. */
  }


  .s4_int2{
    position: absolute;
    width: 600px;
    z-index: 1000;
    top: 150px;
    left: 245px;
    height: 50px;
    font-size: 15px;
    border-radius: 25px; /* 보다 둥근 형태를 위해 반지름 값을 조정합니다. */
    border: 2px solid #4A89C3; /* 테두리 스타일 및 색상을 지정합니다. */
    padding: 0 15px; /* 입력 필드 내용과 테두리 사이의 여백을 조정합니다. */
    outline: none; /* 포커스된 상태에서의 외곽선을 제거합니다. */

  }

  .s4_btn{
    position: absolute;
    width: 55px;
    height: 52px;
    bottom:131px;
    right: 340px;
    z-index: 2100;
    border-radius: 25px;
    cursor: pointer;
  }


  .s4_emailBtn{
    position: absolute;
    width: 100px;
    height:50px;
    border-radius: 25px;
    z-index: 1200;
    top: 152px;
    left: 780px;
    cursor: pointer;
  }

  .s4_cheerBtn{
    position: absolute;
    z-index: 1200;
    width: 30%;
    bottom: 115px;
    left: 280px;
    cursor: pointer;
    transition: transform 0.3s ease, box-shadow 0.3s ease; /* 부드러운 효과를 위한 전환 */
  }

  #s4_letterPopup{
    position: absolute;
    left: 45%;
    top: 50%;
    transform: translate(-50%, -50%);
    width: 1600px;
    height: 900px;
    background: url('assets/images/section4_arona4.jpg') no-repeat center center;
    background-size: cover;
    padding: 20px;
    box-sizing: border-box;
    color: black;
    font-family: 'Courier New', Courier, monospace;
    z-index: 2000;
    display: none;
  }

  .s4_cheerBtn:hover{
    transform: scale(1.05); /* 이미지를 조금 확대 */
    box-shadow: 0 0 20px 5px rgba(255, 255, 255, 0.75); /* 빛나는 효과 */
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

  .s4_raund{
    position: absolute;
    width: 80px;
    z-index: 1200px;
    right: 880px;
    bottom:120px;
  }

  .s4_triangleMenu {
    position: absolute;
    width: 30px; /* 너비 */
    height: 20px; /* 높이 */
    background-color: black; /* 배경 색상 */
    clip-path: polygon(50% 100%, 0% 0%, 100% 0%); /* 역삼각형 모양 */
    right: 840px; /* 오른쪽에서의 위치 조정 */
    bottom: 145px; /* 아래에서의 위치 조정 */
    z-index: 1200; /* z-index로 레이어 순서 조정 */
    cursor: pointer;
  }

  .s4emailMsg {
    display: none;
    position: absolute;
    left: 260px;
    top: 200px;
    color : #007bff;
    z-index: 1500;
  }

  .imageSelector {
    position: absolute;
    background-color: white;
    border: 1px solid #ddd;
    padding: 10px;
    display: flex;
    flex-wrap: nowrap;
    gap: 10px;
    z-index: 2500;
    right: 780px;
    bottom: 1px;
  }

  .imageSelector img {
    width: 100px; /* 이미지 크기를 조정합니다. 상황에 맞게 조정해주세요. */
    margin: 10px;
    cursor: pointer;
  }

  #s4_openLetterImg{
    position:absolute;
    z-index: 2000;
  }

  /* 응원 메시지 스타일 */
  .s4_message-item {
    display: flex;
    align-items: center;
    margin-bottom: 10px;
  }

  .s4_message-image {
    width: 80px;
    height: 60px;
    margin-right: 10px;
  }

  .s4_message-content {
    display: flex;
    flex-direction: column;
  }

  .s4_message-text {
    margin: 0;
  }

  .s4_message-date {
    margin: 0;
  }

  .s4_comment-form{
    position:absolute;
    margin-top: 20px;
    width: 700px;
    height:600px;
    left:930px;
    bottom:215px;
    overflow-y: auto; /* 수직 스크롤만 표시 */
  }


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
    z-index: 3000;
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