<template>
  <div class="position-relative">
    <div id="fullpage">
      <div class="section s1 active">
        <audio data-autoplay>
          <source src="https://epsilon.vgmsite.com/soundtracks/blue-archive-gamerip/pgcasqoumy/07%20Mitsukiyo%2005%20Unwelcome%20School.mp3" type="audio/ogg">
        </audio>
      </div>
      <div class="section s2">
        <img src="./assets/images/section2Title.png" alt="titleImg" class="titleImg">
        <img src="./assets/images/section2Subbg.png" alt="초대장" class="subBg">
        <div id="section2Form" class="row g-3">
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
      <div class="section s3">Section 3</div>
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
          <div class="s4_comment-form">
            <div v-for="(message, index) in cheerMessages" :key="index">
              <img class="s4_message-image" :src="require(`./assets/images/${message.image}`)" :alt="message.image">
              <p class="s4_message">{{ message.message }}</p>
              <p>{{ message.registrationDateTime }}</p>
            </div>
          </div>
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
      <div class="section s5">Section 5</div>
    </div>
  </div>
</template>

<script>
  import Swal from 'sweetalert2';
import fullpage from 'fullpage.js'; // Import fullpage library

  export default {
    mounted() {

      new fullpage('#fullpage', {
        sectionSelector: '.section',
        scrollOverflow: true,
        navigation: true,
        scrollingSpeed: 1000,
        anchors: ['section1', 'section2', 'section3', 'section4', 'section5']
      });
    },
    data() {
      return {
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
      // 이메일 인증 버튼
      s2emailBtn() {
        const emailMsg = document.querySelector('.s2emailMsg');
        emailMsg.style.display = 'block';
      },
      // 사전예약 등록 버튼 alert 출력
      s2AlertBtn() {
        const emailMsg = document.querySelector('.s2emailMsg');
        const emailVerified = emailMsg.style.display === 'block';
        const selectAllCheckbox = document.querySelector('input[value="selectall"]');
        const allAgreed = selectAllCheckbox.checked;

        if (emailVerified && allAgreed) {
          Swal.fire({
            icon: 'success',
            title: '모든 조건이 충족되었습니다.',
            showConfirmButton: true,
          }).then(() => {
            fullpage_api.moveTo(4);
          });
        } else {
          Swal.fire({
            icon: 'error',
            title: '이메일 인증이 완료되었고 모든 항목에 동의해야 합니다.',
            showConfirmButton: false,
            timer: 1500,
          });
        }
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
  };
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
  height: 100px; /* 모든 이미지의 높이를 동일하게 설정합니다. */
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

    /*fullpage nav 재정의*/

  #fp-nav.fp-right {
    right: 5%; /*네비바 오른쪽 여백*/
  }
  #fp-nav ul li {
      margin: 5rem;
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
