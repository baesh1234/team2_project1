<template>
  <div class="section s2">
    <img  src="../assets/images/section2Title.png" alt="titleImg" class="titleImg">
    <img src="../assets/images/section2Subbg.png" alt="초대장" class="subBg">
    <div  id="section2Form" class="row g-3">
      <form @submit.prevent="sendEmail">
        <input type="email" class="form-control" v-model="to" placeholder="Enter your email" required />
        <button class="btn btn-success">인증메일보내기</button>
      </form>
    </div>
    <p class="s2emailMsg" v-if="s2message">{{ s2message }}</p>
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
      <img @click='s2AlertBtn()' src="../assets/images/s2submitButton.png" alt="submitBtnImg" class="s2submitBtn">
    </div>

  </div>
</template>

<script>
import axios from "axios";

export default {
  name: 'Section2',
  data() {
    return {
      to: '',
      s2message: ''
    };
  },
  methods: {
    /***Section2 function***/
    getData() {
      axios.post('http://localhost:8080/findAll')
          .then((response) => {
            console.log(response)
          })
          .catch((error) => {
            console.log(error)
          })
    },
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
    async sendEmail(){
      try {
        const response = await axios.post('http://localhost:8080/sendEmail', {to: this.to});
        this.s2message = '이메일이 성공적으로 전송 되었습니다.';
      }catch (error) {
        this.s2message = '이메일 전송이 실패 했습니다.';
      }
    },
    //사전예약 등록 버튼 alert 출력
    async s2AlertBtn(){
      const selectAllCheckbox = document.querySelector('input[value="selectall"]');
      const allAgreed = selectAllCheckbox.checked;

      if (allAgreed) {
        try {
          const response = await axios.post('http://localhost:8080/memberBook', { to: this.to });
          Swal.fire({
            icon: 'success',
            title: response.data,
            showConfirmButton: true,
          });
        } catch (error) {
          Swal.fire({
            icon: 'error',
            title: error.response.data,
            showConfirmButton: false,
            timer: 1500,
          });
        }
      } else {
        Swal.fire({
          icon: 'error',
          title: '이메일 등록과 약관을 모두 동의해주세요.',
          showConfirmButton: false,
          timer: 1500,
        });
      }
    },
  }
}
</script>
<style scoped>
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
  top: 20rem;
  left: 10rem;
}
.s2checkContainer {
  position: absolute;
  z-index: 2;
  left: 470px;
  top: 400px;
}
.s2emailMsg{
  position: absolute;
  z-index: 2;
  left: 480px;
  top: 366px;
  color : #007bff;
}
.form-control {
  display: inline-block;
  width: 20rem;
  margin-right: 0.5rem;
}
</style>