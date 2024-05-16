<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value='/' var="root" />
<!-- 상단 -->

<nav
	class="navbar navbar-expand-md bg-dark text-white fixed-up shadow-lg">
	<a class="navbar-brand" href="${root }main">화이팅♥</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav">
			<c:forEach var="obj" items="${team }">
				<li class="nav-item"><a
					href="${root }board/main?board_info_idx=${obj.board_info_idx}"
					class="nav-link">${obj.board_info_name }</a></li>
			</c:forEach>

		</ul>

		<ul class="navbar-nav ml-auto">

			<li class="nav-item"><a class="nav-link"
				href="${root }user/modify">정보수정</a></li>

			<li class="nav-item"><a class="nav-link"
				href="${root }user/logout">로그아웃</a></li>

			<li class="nav-item"><a class="nav-link"
				href="${root }user/login">로그인</a></li>

			<li class="nav-item"><a class="nav-link"
				href="${root }user/join">회원가입</a></li>
		</ul>
	</div>
</nav>


