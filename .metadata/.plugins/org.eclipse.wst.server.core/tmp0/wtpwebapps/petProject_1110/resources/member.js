
function go_save() {
	
	var reg = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	
    if (document.formm.password.value == "") {
    alert("비밀번호를 입력해 주세요.");
    document.formm.pwd.focus();
  } else if ((document.formm.password.value != document.formm.passwordCheck.value)) {
    alert("비밀번호가 일치하지 않습니다.");
    document.formm.pwd.focus();
  } else if (document.formm.name.value == "") {
    alert("이름을 입력해 주세요.");
    document.formm.name.focus();
  } else if (document.formm.email.value == "") {
    alert("이메일을 입력해 주세요.");
    document.formm.email.focus();
  } else if (document.formm.birthday.value == "") {
    alert("생일을 입력해 주세요.");
    document.formm.phone.focus();
  }  else if (document.formm.phone.value == "") {
    alert("전화번호를 입력해 주세요.");
    document.formm.phone.focus();
  } else if (document.formm.address.value == "") {
    alert("주소를 입력해 주세요.");
    document.formm.address.focus();
  } else if (document.formm.cateName.value == "") {
    alert("관심사를 입력해 주세요.");
  }else {
    document.formm.submit();
  }
}

function idcheck() {
	  if (document.formm.id.value == "") {
	    alert('아이디를 입력하여 주십시오.');
	    document.formm.id.focus();
	    return;
	  }
	  var url = "MypetServlet?command=id_check_form&id=" 
	+ document.formm.id.value;
	  window.open( url, "_blank_1",
	"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=330, height=200");
}
	
function go_next() {
	  if (document.formm.okon1[0].checked == true) {
	    document.formm.action = "/member/join";
	    document.formm.submit();
	  } else if (document.formm.okon1[1].checked == true) {
	    alert('약관에 동의 하셔야 합니다.');
	  }
	}
	