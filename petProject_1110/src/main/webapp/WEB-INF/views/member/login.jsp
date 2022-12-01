<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>  
<%@ include file="../include/header.jsp" %>  
<script>
function check() {
	  if (document.login_frm.id.value == "") {
	    alert('아이디를 입력하여 주십시오.');
	    document.login_frm.id.focus();
	    return;
	  } else if(document.login_frm.id.value == "") {
		alert('비밀번호를 입력하여 주십시오.');
		document.login_frm.id.focus();
		return;
	  } else{
		  document.login_frm.submit();
	  }
	 
}
</script>
  <article>
    <h2>로그인</h2>
    <form method="post" name="login_frm">
        <fieldset id="login_field">
        <legend></legend>
          <input name="id" type="text" value="${id}" placeholder="아이디"><br> 
          <input name="password" type="password" placeholder="비밀번호"><br> 
          <c:if test="${msg == false}">
			<p style="color:#f00;">로그인에 실패했습니다.</p>
		</c:if>
        </fieldset>
        <div class="clear"></div>
        <div>
            <input type="button" value="로그인" onclick="check()" id="login_btn">
            <input type="button" value="회원가입" onclick="location.href='/member/contract'" id="cons_btn">
        </div>
    </form>  
  </article>
<%@ include file="../include/footer.jsp" %>      
