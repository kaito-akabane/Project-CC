function check() {
    const id = document.querySelector(".id");
    const pw = document.querySelector(".pw");
    if(id.value==="") {
        alert("ID를 입력해주세요.");
        id.focus();
        return false;
    }
    else if(pw.value==="") {
        alert("PW를 입력해주세요.");
        pw.focus();
        return false;
    }
    return true;
}