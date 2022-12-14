<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<script type="text/javascript" src="/resources/member.js"></script>

<article>
	<h2>회원가입</h2>
	<form  method="post" name="formm">
		<fieldset id="join_field">
			<table id="join_table">
				<tr>
					<th>아이디</th>
					<td><input type="text" name="id" id="id" size="12"></td>
					<td><input type="hidden" name="reid">
					   <!--  <input type="button" value="중복 체크" onclick="idcheck()" id="overlap"
					        style="width:80px; height:35px;"></td> -->
				</tr>
				<tr>
					<th>비밀번호</th>
					<td colspan='2'><input type="password" name="password"></td>
				</tr>
				<tr>
					<th>비밀번호 확인</th>
					<td colspan='2'><input type="password" name="passwordCheck"></td>
				</tr>
				<tr>
					<th>이름</th>
					<td colspan='2'><input type="text" name="name"></td>
				</tr>
				<tr id="email_type">
					<th>이메일 주소</th>
						<td colspan='2'><input type="text" name="email">
						<div style="display:none" id="w">
							<input type="text" name="we" style="margin-top: 0px; margin-bottom: 0px;"></div>
					</td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td colspan='2'><input type="text" name="birthday" placeholder="19900101"></td>
				</tr>
				<tr id="phone_type">
					<th>휴대폰 번호</th>
					<td colspan='2'>
					<div id="phone_div"><input type="text" name="phone"></div></td>
				</tr>
				<tr>
					<th>주소</th>
					<td colspan='2'><input type="text" name="address"></td>
				</tr>
				<tr>
					<th>관심사</th>
						<td colspan='2'>
						    <label><input type ="radio" name ="cateName" value ="none">관심없음</label>
						    <label><input type ="radio" name ="cateName" value ="dog">강아지</label>
						    <label><input type ="radio" name ="cateName" value ="cat">고양이</label>
						    <label><input type ="radio" name ="cateName" value ="bird">조류</label>
						    <label><input type ="radio" name ="cateName" value ="rep">파충류</label></td>
				</tr>
			</table>
		</fieldset>
		<div class="clear"></div>
		<div>
			<input type="button" value="이전 페이지" id="back" onclick="history.go(-1)">
			<input type="reset" value="지우기" id="join_cancle">
			<input type="button" value="회원가입" onclick="go_save()" id="join_ok">
		</div>
	</form>
</article>
<%@ include file="../include/footer.jsp"%>
