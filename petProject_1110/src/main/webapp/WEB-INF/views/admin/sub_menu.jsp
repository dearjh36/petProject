<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>

<nav id="sub_menu">
 
<h2>Admin Setting</h2>

<ul>
<li><a href='/admin/product/productList?num=1'> 상품리스트</a></li>
<li><a href='/admin/p_order/p_orderList'> 주문리스트</a></li>
<li><a href='MypetServlet?command=admin_cancel_order_list'> 취소리스트</a></li>
<li><a href='MypetServlet?command=admin_member_list'> 회원리스트</a></li>
<li><a href='MypetServlet?command=admin_mtm_list'> Q/A리스트</a></li>
<li><a href='MypetServlet?command=admin_qna_list'> 공지사항작성</a></li>
<li><a href='/member/logout'> 로그아웃</a></li>
</ul>
</nav> 



