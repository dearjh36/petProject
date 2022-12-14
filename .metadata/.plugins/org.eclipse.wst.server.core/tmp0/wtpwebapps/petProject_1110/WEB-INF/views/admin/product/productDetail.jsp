<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="../sub_menu.jsp"%>

<article>
	<h1>상품 상세 보기</h1>
	<form name="frm" method="post" action="/admin/product/productModify" enctype="multipart/form-data">
		<input type="hidden" name="pNum" value="${productVO.pNum}">
		<table id="list">
			<tr>
				<th>상품분류</th>
				<td colspan="5">
				 <select name="kind" required>
   					<c:forEach items="${kindList}" var="kind" varStatus="status">
      					<option value="${kind}" >${kind}</option>
   					</c:forEach>
 				</select>  
				</td>
			</tr>
			<tr>
				<th>카테고리</th>
				<td colspan="5"> <select name="cateCode" required>
   					<c:forEach items="${cateCodeList}" var="cateCode" varStatus="status1">
      					<option value="${status1.count}" >${cateCode}</option>
   					</c:forEach>
 				</select>  </td>
			</tr>
			<tr>
				<th align="center">상품 명</th>
				<td colspan="5"><input type="text" value="${productVO.pName}"></td>
				
			</tr>
			<tr>
				<th align="center">제조사</th>
				<td colspan="5"><input type="text" value="${productVO.CP}"></td>
			</tr>

			<tr>
				<th>가격</th>
				<td width="60"><input type="text" value="${productVO.pPrice}"></td>

			</tr>

			<tr>
				<th>상세설명</th>
				<td colspan="5"><input type="text" value="${productVO.pInfo}"></td>
			</tr>

			<tr>
				<th>상품이미지</th>
				<td colspan="5" align="center">
					<!--[7] 상품 이미지를 출력하기 --> 
					<img src="/resources/images/product_img/${productVO.pImg}" width="200pt" class="select_img"><br>
					<input type="file" name="fileImg" id="fileImg">
					<input type="hidden" name="pImg" value="${productVO.pImg}"/>
					<script>
						$("#fileImg").change(function(){
							if(this.files && this.files[0]){
								var reader = new FileReader;
								reader.onload = function(data){
									$(".select_img img").attr("src",data.target.result);
								}
								reader.readAsDataURL(this.files[0]);
							}
						})
					</script>
					<br>
					<%=request.getRealPath("/") %>
				</td>
			</tr>

		</table>
		<!--[8] 수정 버튼이 눌리면 상품 수정 페이지로 이동하되 현재 페이지와 상품 일련번호 값을 전달해 준다. -->
		<input class="btn" type="submit" value="수정">
		<!--[9] 목록 버튼이 눌리면 상품 리스트 페이지로 이동하되 현재 페이지를 전달해 준다. -->
		<input class="btn" type="button" value="목록" onClick="location.href='/admin/product/productList?num=1'">
	</form>
</article>
<%@ include file="../footer.jsp"%>
