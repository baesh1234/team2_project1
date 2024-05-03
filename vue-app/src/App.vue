<template>
  <div class="position-relative">
    <div id="fullpage">
      <div id="full1" class="section">Section 1</div>
      <div class="section full2">
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
      <div class="section" data-anchor="section3">Section 3</div>
      <div class="section">Section 4</div>
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
        anchors: ['section1','section2', 'section3', 'section4', 'section5']
      });
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
            fullpage_api.moveTo(3);
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