<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta charset="UTF-8">
<title>welcomepet 관리자 로그인</title>
<link rel="stylesheet" href="/resources/admin/css/adminlogin.css">
<script type="text/javascript">
function admin_check()
{
  if(document.frm.adminid.value==""){ /*document.frm.workid해결  */
      alert("아이디를 입력하세요.");
      document.frm.adminid.focus();
      return false;
  }else if(document.frm.adminow.value==""){/*document.frm.workPw해결  */
     alert("비밀번호를 입력하세요.");
     document.frm.adminpw.focus();  
  return false;
    }
    return true;  
}
</script>
</head>

<body>

	<div class="main-container">

		<div class="main-wrap">
			<header>
			<div class="logo-wrap">
				<a href="/"><img
					src="/resources/images/admin_logo.png"></a>
			</div>

			</header>
			<section class="login-input-section-wrap">
			<form name="frm" method="post" action="/admin/main">
				<div class="login-input-wrap">
					<input type="text" placeholder="아이디" name="id"></input>
				</div>
				<div class="login-input-wrap password-wrap">
					<input placeholder="비밀번호" type="password" name="password"></input>
				</div>

				<div class="login-button-wrap">
					<button>관리자 로그인</button>
					<br>
					<br>
					<c:if test="${msg == false}">
						<p style="color:#f00;">로그인에 실패했습니다.</p>
					</c:if>
			</form>
		</div>

	</div>




	</section>

	</div>

</body>

</html>