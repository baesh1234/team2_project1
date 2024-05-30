<template>
  <HelloWorld msg="Welcome to Your Vue.js App"/>
  <div class="section s4">
    <div class="s4_container">
      <img src="../assets/images/section4_arona_final.png" class="s4_board">
      <input type="text" class="s4_int2" placeholder="사전예약한 이메일을 입력해주세요" v-model="userEmail" maxlength="50" />
      <img src="../assets/images/s4_btn.png" class="s4_btn" @click="s4_btn">
      <img src="../assets/images/s4_emailBtn.png" class="s4_emailBtn" @click="s4_emailBtn">
      <p class="s4emailMsg">인증이 완료되었습니다.</p>
      <img :src="getImageSrc(selectedImage || 's4_arona_raund.png')" class="s4_raund">
      <div class="s4_triangleMenu" @click="toggleImageSelector"></div>
      <input type="text" class="s4_int" v-model="s4_usermemo" placeholder="응원 메세지를 입력해주세요" />
      <div class="s4_comment-form">
        <div v-for="(message, index) in cheerMessages" :key="index" class="s4_message-item">
          <img class="s4_message-image" :src="getImageSrc(message.image)" :alt="message.image">
          <div class="s4_message-content">
            <p class="s4_message-text">{{ message.comment_content }}</p>
            <p class="s4_message-date">{{ message.registrationDateTime }}</p>
          </div>
        </div>
      </div>
      <img src="../assets/images/s4_cheerBtn.png" class="s4_cheerBtn" @click="s4_cheerBtn">
      <div v-show="showImageSelector" class="imageSelector">
        <div v-for="(image, index) in images" :key="index" @click="selectImage(image)">
          <img :src="require(`../assets/images/${image}`)" :alt="image">
        </div>
      </div>
      <div id="s4_letterPopup">
        <button id="s4_closeButton" @click="toggleLetterX()">X</button>
      </div>
    </div>
  </div>
</template>
<script>
import axios from "axios";
import HelloWorld from './HelloWorld.vue';
import { Stomp } from "@stomp/stompjs";
import SockJS from "sockjs-client";




export default {
  name: 'Section4',
  components: {
    HelloWorld
  },
  data() {
    return {
      userEmail: '',
      userMessage: '',
      emailVerified: false,
      s4_usermemo: '',
      showImageSelector: false,
      selectedImage: localStorage.getItem('selectedImage') || null,
      images: ["s4_arona_raund.png", "s4_mika.png", "s4_toki.png"],
      cheerMessages: [],
      selectedCheerMessage: null,
      clearInputField: false,
      registrationDateTime: '',
      stompClient: null // Stomp 클라이언트 객체 추가
    };
  },
  mounted() {
    this.initializeWebSocket();
    this.fetchCheerMessages();
    this.loadSelectedImage();
    setInterval(this.fetchCheerMessages, 3000);
  },
  methods: {

    async initializeWebSocket() {
      const socket = new SockJS('http://localhost:8080/gs-guide-websocket');
      this.stompClient = Stomp.over(socket);
      this.stompClient.connect({}, frame => {
        console.log('Connected: ' + frame);
        this.stompClient.subscribe('/topic/messages', message => {
          const newMessage = JSON.parse(message.body);
          this.cheerMessages.push(newMessage);
          // 추가된 댓글을 화면에 바로 반영하기 위해 scrollToBottom 메서드를 호출합니다.
          this.scrollToBottom();
          localStorage.setItem('cheerMessages', JSON.stringify(this.cheerMessages));
        });
      });
    },


    async fetchCheerMessages() {
      try {
        const response = await axios.get('http://localhost:8080/api/Cheer');
        this.cheerMessages = response.data;
        localStorage.setItem('cheerMessages', JSON.stringify(this.cheerMessages));
      } catch (error) {
        console.error('응원 메시지를 불러오는데 실패했습니다.', error);
      }
    },
    s4_btn() {
      if (this.s4_usermemo) {
        this.submitMessage();
      } else {
        Swal.fire({
          text: '한 줄평을 입력해주세요.',
          icon: 'error',
          timer: 2000
        });
      }
    },
    async s4_emailBtn() {
      try {
        const response = await axios.post('http://localhost:8080/api/checkEmail', { email: this.userEmail });
        if (response.data === "인증이 완료되었습니다.") {
          this.emailVerified = true;
          this.showEmailMessage();
        } else {
          Swal.fire({
            text: '사전등록을 해주세요.',
            icon: 'error',
            timer: 2000
          });
        }
      } catch (error) {
        console.error('Error verifying email:', error);
        Swal.fire({
          text: '인증에 실패했습니다.',
          icon: 'error',
          timer: 2000
        });
      }
    },
    setRegistrationDateTime() {
      this.registrationDateTime = new Date().toLocaleString();
    },
    async submitMessage() {
      if (!this.selectedImage) {
        this.selectedImage = "s4_default_image.png";
      }
      if (!this.emailVerified) {
        Swal.fire({
          text: '이메일 인증이 완료되어야 합니다.',
          icon: 'error',
          timer: 2000
        });
        return;
      }
      if (!this.userEmail || !this.s4_usermemo) {
        Swal.fire({
          text: '이메일과 메시지를 입력해야 합니다.',
          icon: 'error',
          timer: 2000
        });
        return;
      }

      this.setRegistrationDateTime();

      const commentData = {
        comment_content: this.s4_usermemo,
        email: this.userEmail,
        image: this.selectedImage,
        registrationDateTime: this.registrationDateTime
      };

      try {
        const response = await axios.post('http://localhost:8080/api/Cheer', commentData);
        this.stompClient.send("/app/chat", {}, JSON.stringify(commentData));
        this.userEmail = '';
        this.s4_usermemo = '';
        this.selectedImage = null; // Reset selected image after submission
      } catch (error) {
        console.error('댓글을 저장하는 동안 오류가 발생했습니다.', error);
      }

      this.showCheerMessages();
    },
    getImageSrc(imageName) {
      try {
        return require(`../assets/images/${imageName}`);
      } catch (e) {
        //console.log(1111);
        return require(`../assets/images/s4_default_image.png`);
      }
    },
    showCheerMessages() {
      this.scrollToBottom();
    },
    scrollToBottom() {
      const cheerMsg = document.querySelector('.cheerMsg');
      if (cheerMsg) {
        cheerMsg.scrollTop = cheerMsg.scrollHeight;
      }
    },
    showEmailMessage() {
      Swal.fire({
        text: '인증이 완료되었습니다.',
        icon: 'success',
        timer: 2000
      }).then(() => {
        setTimeout(() => {
          const emailMsg = document.querySelector('.s4emailMsg');
          emailMsg.style.display = 'block';
        }, 100);
      });
    },


    s4_cheerBtn() {
      const letter = document.querySelector('#s4_letterPopup');
      letter.style.display = 'block';
    },
    toggleLetterX() {
      const letter = document.querySelector('#s4_letterPopup');
      letter.style.display = 'none';
    },
    showCheerMessage() {
      const cheerMsg = document.querySelector('.s4_int');
      cheerMsg.scrollTop = cheerMsg.scrollHeight;
    },
    toggleImageSelector() {
      this.showImageSelector = !this.showImageSelector;
    },
    selectImage(selectedImage) {
      this.selectedImage = selectedImage;
      localStorage.setItem('selectedImage', selectedImage); // 선택된 이미지를 localStorage에 저장
      this.adjustImageSelectorSize(selectedImage);
      this.showImageSelector = false;
      const imageElement = document.querySelector('.s4_raund');
      if (imageElement) {
        imageElement.src = require(`../assets/images/${selectedImage}`);
      }
    },
    adjustImageSelectorSize(selectedImage) {
      const img = new Image();
      img.src = require(`../assets/images/${selectedImage}`);
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
    loadSelectedImage() {
      const storedImage = localStorage.getItem('selectedImage');
      if (storedImage) {
        this.selectedImage = storedImage;
        const imageElement = document.querySelector('.s4_raund');
        if (imageElement) {
          imageElement.src = require(`../assets/images/${storedImage}`);
        }
      }
    }
  }
}
</script>
<style scoped>
/*Section4*/

.s4_board{
  position: absolute;
  width: 100rem;
  height: auto;
  top: 50px;
  left: 6rem;
  -o-object-fit: contain;
  object-fit: contain;
  border-radius: 3%;
}
.s4_int{
  position: absolute;
  width: 35rem;
  z-index: 2000;
  bottom: 132px;
  left: 68rem;
  height: 53px;
  font-size: 15px;
  border-radius: 25px;
  border: 2px solid #4A89C3;
  padding: 0 15px;
  outline: none;
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
  height: 53px;
  bottom: 132px;
  left: 100rem;
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
  top: 150px;
  left: 746px;
  cursor: pointer;
}

.s4_cheerBtn{
  position: absolute;
  z-index: 1200;
  width: 37rem;
  top: 44.5rem;
  left: 18.5rem;
  cursor: pointer;
  transition: transform 0.3s ease, box-shadow 0.3s ease;
}

#s4_letterPopup{
  position: absolute;
  left: 45%;
  top: 49%;
  transform: translate(-50%, -50%);
  width: 1600px;
  height: 900px;
  background: url('../assets/images/section4_arona4.jpg') no-repeat center center;
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
  left: 60rem;
  bottom:120px;
}

.s4_triangleMenu {
  position: absolute;
  width: 30px; /* 너비 */
  height: 20px; /* 높이 */
  background-color: black; /* 배경 색상 */
  clip-path: polygon(50% 100%, 0% 0%, 100% 0%); /* 역삼각형 모양 */
  left: 65.5rem; /* 오른쪽에서의 위치 조정 */
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
  position: absolute;
  margin-top: 20px;
  width: 700px;
  height: 600px;
  left: 60rem;
  top: 135px;
  overflow-y: auto; /* 수직 스크롤만 표시 */
}

</style>