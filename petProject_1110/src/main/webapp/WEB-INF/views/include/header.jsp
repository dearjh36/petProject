<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>welcome pet</title>
<link href="/resources/css/mypet.css" rel="stylesheet">
</head>
<body>
<form name="frm" method="post" action = "/product/productList">
	<div id="wrap">
		<header>
			<div id="catagory_menu">
				<ul class="right_menu">
					<c:choose>
						<c:when test="${empty sessionScope.member}">
							<li><a href="/member/login">로그인</a></li>

							<li><a href="/member/contract">회원가입</a></li>
						</c:when>
						<c:otherwise>
							<li style="color: orange; transform:translateY(-10px)">
								${sessionScope.member.name}님(${sessionScope.member.id})</li>
							<li><a href="/member/logout.do">로그아웃</a></li>
							<li><a href="/mypage/cartList">장바구니</a></li>
							<li><a href="/mypage/mypage">마이페이지</a></li>
							<li><a href="/qna/qnaList">고객센터</a></li>
						</c:otherwise>
					</c:choose>

				</ul>
			</div>
			
			<div id="logo">
				<a href="/"> 
				<img src="/resources/images/logo.jpg">
				</a>
			</div>
			
			<div class="search_area">
				<div class="search_form">
					<input type="text" name="searchValue" class="searchTerm" placeholder="원하는 상품을 검색해보세요." required> 
					<button class="searchButton" type="submit" name="btn_search" value="검색">
						<i class="search"></i>
					</button>
				</div>
			</div>


			<div class="aa">
				<div class="top_box">
					<a href="/cate_main?cateName=dog" class="dog_box">강아지</a> 
					<a href="/cate_main?cateName=cat" class="cat_box">고양이</a>
				</div>
				<div class="bottom_box">
					<a href="/cate_main?cateName=bird" class="bird_box">조류</a> 
					<a href="/cate_main?cateName=rep" class="rep_box">파충류</a>
				</div>
			</div>

			<div class="clear"></div>

		</header>
	</div>
</form>