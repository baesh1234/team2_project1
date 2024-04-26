document.addEventListener("DOMContentLoaded", function() {
    const commitForm = document.getElementById("commit_num2");
    let verificationCode = ""; // 서버에서 생성될 가상의 인증 코드
    let isVerified = false; // 인증 상태 초기화
    let commentId = 1; // 댓글 번호 초기화

    function generateVerificationCode() {
        return Math.floor(100000 + Math.random() * 900000).toString(); // 6자리 랜덤 숫자 생성
    }

    function maskPhoneNumber(phoneNumber) {
        // 전화번호를 하이픈이 포함된 형식으로 표준화하고, 중간 네 자리를 XXXX로 마스킹 처리
        // 예: 01012345678 -> 010-XXXX-5678, 010-1234-5678 -> 010-XXXX-5678
        const cleaned = phoneNumber.replace(/\D/g, ''); // 숫자만 추출
        const matched = cleaned.match(/^(\d{3})(\d{4})(\d{4})$/);
        if (matched) {
            return `${matched[1]}-XXXX-${matched[3]}`;
        } else {
            return phoneNumber; // 형식에 맞지 않는 번호는 그대로 반환
        }
    }
    
    document.querySelector('.verification-request-button').addEventListener('click', function(event) {
        event.preventDefault();
        const phoneInput = document.querySelector('input[name="phone"]');
        if (phoneInput.value.trim() === "") {
            alert("핸드폰 번호를 입력해주세요.");
        } else {
            verificationCode = generateVerificationCode();
            console.log("Generated Verification Code: " + verificationCode); // 콘솔에 인증번호 로깅
            alert("인증번호가 전송되었습니다. 개발자 도구의 콘솔을 확인하세요.");
        }
    }, { passive: false });

    document.querySelector('.verify-button').addEventListener('click', function(event) {
        event.preventDefault();
        const userCodeInput = document.querySelector('input[name="verificationCode');
        if (userCodeInput.value.trim() === "") {
            alert("인증번호를 입력해주세요.");
        } else if (userCodeInput.value === verificationCode) {
            alert("인증 성공!");
            isVerified = true;
        } else {
            alert("인증번호가 일치하지 않습니다. 다시 시도해주세요.");
        }
        userCodeInput.value = "";
    }, { passive: false });

    commitForm.addEventListener("submit", function(event) {
        event.preventDefault();
        if (!isVerified) {
            alert("먼저 핸드폰 인증을 완료해주세요.");
            return;
        }
        const phoneInput = document.querySelector('input[name="phone"]');
        const contentInput = document.querySelector('input[name="content"]');
        if (contentInput.value.trim() === "") {
            alert("한줄평을 입력해주세요.");
            return;
        }
        const currentDate = new Date().toLocaleString();
        addComment(commentId++, maskPhoneNumber(phoneInput.value), contentInput.value, currentDate);
        contentInput.value = ""; // 입력 필드 초기화
        phoneInput.value = "";
    }, { passive: false });

    function addComment(id, phone, comment, date) {
        const commitList = document.getElementById("commit_list");
        const div = document.createElement("div");
        div.className = "comment";
        div.innerHTML = `번호: ${id} - 전화번호: ${phone} - 한줄평: ${comment} - 날짜: ${date}`;
        commitList.appendChild(div);
    }
});

function toggleLetter() {
    var letter = document.getElementById('letterPopup');
    letter.style.display = (letter.style.display === 'none' ? 'block' : 'none');
}
document.getElementById('openLetterImg').addEventListener('click', toggleLetter);
