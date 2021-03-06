<%@page import="com.mycom.blog.controller.assist.ConAssist"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/css/manager/header_subnav.css" />



<body>
	<div id="welcome" class="container-fluid">
		<br>
		<a href="/home"><img src="/image/키로미톡.PNG" width="50px"alt="logo"/></a>
		<h3 style="float:right;"><%= ConAssist.getUser().getUsername() %> 관리자님 환영합니다!</h3>
	</div>

	<nav id="bar" class="navbar navbar-expand-md bg-dark navbar-dark sticky-top">
		<a class="navbar-brand" href="/home"></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">

			<c:choose>
				<c:when test="${empty principal}">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link" href="/auth/loginForm">로그인</a></li>
						<li class="nav-item"><a class="nav-link" href="/auth/joinForm">회원가입</a>
					</ul>
				</c:when>
				<c:otherwise>
					<ul class="navbar-nav overfH">
						<!-- <li class="nav-item"><a class="nav-link" href="">일반사용자 메뉴</a></li> -->
						<li class="nav-item subnav"><a class="nav-link subnav-li" href="/manager/member/search">
						<!-- 회원관리 -->
						회원검색
						</a>
							<!-- <div class="subnav-content">
								<a href="/manager/member/search">회원검색</a> <a href="#deliver">블랙리스트</a> <a href="#package">회원동향 분석</a>
							</div> -->
							</li>
						<li class="nav-item subnav"><a class="nav-link subnav-li" href="/sales/">
						<!-- 매출분석 -->
						매출통계
						</a>
							<!-- <div class="subnav-content">
								<a href="/sales/">매출통계</a> <a href="#deliver">지역별 매출통계</a>
							</div> -->
							</li>
						<li class="nav-item subnav"><a class="nav-link subnav-li" href="">게시판관리</a>
							<div class="subnav-content">
								<a href="/manager/notice/noticeList">공지사항</a>
								<a href="/manager/FAQ/faqList">FAQ</a>
							</div></li>
					</ul>
					<ul class="navbar-nav ml-auto">
						<form action="/logout" method="post">
							<sec:csrfInput />
							<button id="logoutBtn" type="submit" class="btn btn-secondary btn-sm">로그아웃</button>
						</form>
					</ul>
				</c:otherwise>
			</c:choose>
		</div>
	</nav>
	<div class="subnav-content_bellow"></div>
	<br>
	<script type="text/javascript">
		$(function() {
			var sub = $(".subnav");
			var con = $(".subnav-content");

			sub.hover(function() {
				var lt = $(this).position().left;
				con.css("padding-left", lt);
			}, function() {
				con.css("padding-left", "0");
			});
		});
	</script>