
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="../sub_menu.jsp"%>
<script type="text/javascript">
	function go_search3() {
		document.frm.action = "MypetServlet?command=order_Cntlist";
		document.frm.submit();
	}
	function go_search4() {
		document.frm.action = "MypetServlet?command=order_Ranklist";
		document.frm.submit();
	}
	function go_search5() {
	
		document.frm.action = "MypetServlet?command=order_odNumlist";
		document.frm.submit();
	}
	function go_search6() {
		
		document.frm.action = "MypetServlet?command=order_catelist";
		document.frm.submit();
	}
</script>
<article>
	<h1>회원랭크</h1>
	<form name="frm" method="post">
		
		
		<table id="orderList">
			<tr>
				<th>카테고리</th>
				<th>수량</th>
				<th>금액</th>
				<th>주문횟수</th>
				
			</tr>
			<c:forEach items="${p_orderList}" var="p_orderVO">

				<tr>

			<td>${p_orderVO.catename}</td>
			<td>${p_orderVO.cnt}</td>
			<td>${p_orderVO.pPrice}</td>
			<td>${p_orderVO.odNum}</td>



				</tr>
			</c:forEach>
		</table>
		<div style="width:1100px">
 
  <input class="btn" type="button" value="갯수"
					onclick="go_search3()">
				<input class="btn" type="button" value="금액"
					onclick="go_search4()">
				<input class="btn" type="button" value="주문횟수"
					onclick="go_search5()">
					<input class="btn" type="button" value="카테고리"
					onclick="go_search6()">
				</div>
</form>
</article>




<%@ include file="../footer.jsp"%>