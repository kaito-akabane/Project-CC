// const loginBtn = document.querySelector('.loginBtn');
//
// loginBtn.addEventListener("DOMContentLoaded", function () {
//     // 버튼 클릭 시 check 함수 호출
//     loginBtn.addEventListener("click", function (event) {
//         event.preventDefault(); // 폼 제출 막기
//         check();
//     });
// });

function check() {
    // const id = document.querySelector(".id");
    const pw = document.querySelector(".pw");
    const pw2 = document.querySelector(".pw2");
    // if(id.value==="") {
    //     alert("ID를 입력해주세요.");
    //     id.focus();
    //     return false;
    // }
    if(pw.value.length < 4 && pw.value.length > 20) {
        alert("4자 이상 20자 이하의 비밀번호를 입력해주세요.");
        pw.focus();
        return false;
    }
    else if(pw.value!==pw2.value) {
        alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
        pw.focus();
        return false;
    }
    return true;

    // const loginEmail = document.querySelector(".email").value;
    // const loginPhone = document.querySelector(".phone").value;

    // if (checkNumLength(loginNum) === false) {
    //     alert("학번을 정확히 입력해 주세요");
    //     document.join.class_of.focus();
    //     return false;
    // }
    // else if (checkEmail(loginEmail) === false) {
    //     alert("이메일을 정확히 입력해주세요");
    //     return false;
    // }
    // else if (checkPhone(loginPhone) === false) {
    //     alert("전화번호를 정확히 입력해주세요");
    //     return false;
    // }
    // if (passwordLength(loginPassword) === false) {
    //     alert("비밀번호는 4~20글자 사이의 값으로 입력해주세요");
    //     document.join.password.focus();
    //     return false;
    // }
}

// function checkNumLength(stuNum) {
//     return stuNum.length === 7;
// }
//
// function checkEmail(email) {
//     return /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/.test(email);
// }
//
// function checkPhone(phone) {
//     return /^01([0-9])-?([0-9]{3,4})-?([0-9]{4})$/.test(phone);
// }

// function passwordLength(pw) {
//     return pw.length >= 4 && pw.length <= 20
// }