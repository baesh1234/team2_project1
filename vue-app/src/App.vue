<template>
  <div class="position-relative">
    <div id="fullpage">
      <div id="full1" class="section">Section 1</div>
      <div class="section full2">
        <img  src="./assets/images/section2Title.png" alt="titleImg" class="titleImg">
        <img src="./assets/images/section2Subbg.png" alt="초대장" class="subBg">
        <form action="emailReg" method="POST" id="section2Form">
          <input type="text" placeholder="이메일을 입력해주세요." name="email" required>
          <button type="submit" class="btn">인증</button>
        </form>

      </div>
      <div class="section">Section 3</div>
      <div class="section s4">
        <div id="upImage">
      <img src="./assets/images/section4_arona3.png" alt="이벤트 확인" id="section4_up" width="600px">
      <h2 class="section4_text">선생님 100주년 축하드려요! 기념이벤트 개최중이니 아래의 저를 눌러 내용을 확인해주세요!</h2>
        </div>
        <img id="openLetterImg" src="./assets/images/section4_arona.jpg" alt="편지 열기">
        <div id="letterPopup">
          <button id="closeButton" onclick="toggleLetter()">X</button> <!-- 닫기 버튼 -->
        </div>

        <div>
          <ul class="commit">
            <li class="commit_num1">
              <form id="commit_num2">
                <h2 class="s4_font">한줄평쓰기<span></span></h2>
                <span class="ps_box">
            <input type="text" class="s4_int2" name="phone" placeholder="핸드폰 번호를 입력해주세요" maxlength="13"  />
          <div class="verification-status"></div>
        <button class="verification-request-button">인증 요청</button>
        <div class="verification-container">
          <input type="text" class="verificationCode" name="verificationCode" placeholder="인증번호 입력" >
          <button class="verify-button">인증번호 확인</button>
          <div class="verification-status"></div>
        </div>
        <div class="verification-status"></div>
          <input type="text" class="int" name="content" placeholder="한줄평을 입력해주세요" />
          </span>
                <input type="submit" class="btn" value="등록" />
              </form>
            </li>
            <li id="commit_list" class="comment-board"></li>
          </ul>
        </div>


      </div>
      <div class="section">Section 5</div>
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
      });
    }
  }
</script>

<style>
  .section {
    background-image: url('assets/images/bgImg.jpg');
    height: 100%;
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
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

   /*Section4*/

   /*Section4_commit*/
ul,li{
    list-style: none;
}

.commit{
    position: absolute;
    top: -20px;
    display:flex;
    left: 25cm;
    padding: 30px;
    width: 600px;
    flex-wrap: nowrap;
  }

.commit > li {
    margin-top: 120px;
   right: 100px;
}

.commit > li:nth-child(1){
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

.commit_num1 > form {
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    justify-content: space-between;
}

.commit_num1 > form > h2 {
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

.ps_box > input {
    outline: none;
}

.int {
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

.btn {
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

#commit_list{
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
    right: 82px;
    bottom: -5px;
    height: 30px;
    font-size: 15px;
}

.s4_font{
font-size: 65px
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
    background-image: url(assets/images/section4_arona6.jpg);
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

.verification-request-button {
    position: absolute;
    right: -5px;
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
    right: 50px;
    bottom: -50px;
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

.verify-button {
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

  #letterPopup {
    display: none;
    position: fixed;
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);
    width: 1500px;
    height: 850px;
    background: url(assets/images/section4_arona4.jpg) no-repeat center center;
    background-size: cover;
    padding: 20px;
    box-sizing: border-box;
    color: black;
    font-family: 'Courier New', Courier, monospace;
    z-index: 1000;
    position: relative; /* 팝업 내 위치 지정을 위해 relative 설정 */
}
#closeButton {
    position: absolute;
    top: 10px;
    right: 10px;
    background: none; /* 배경 없음 */
    border: none; /* 테두리 없음 */
    cursor: pointer;
    font-size: 24px;
    color: white; /* X의 색상 설정 */
}
#openLetterImg {
  position: absolute;
  left: 210px;
  top: 470px;
    cursor: pointer;
    width: 700px; /* 이미지 크기 조정 필요 */
    transition: transform 0.3s ease, box-shadow 0.3s ease; /* 부드러운 효과를 위한 전환 */
    border-radius: 30%;
}
#openLetterImg:hover {
    transform: scale(1.05); /* 이미지를 조금 확대 */
    box-shadow: 0 0 20px 5px rgba(255, 255, 255, 0.75); /* 빛나는 효과 */
}

#upImage{
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


</style>