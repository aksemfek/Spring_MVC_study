<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }" />
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container-fluid">
		<div class="navbar-header">
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#Navbar">
				<span class="navbar-toggler-icon"></span> <span
					class="navbar-toggler-icon"></span> <span
					class="navbar-toggler-icon"></span>
			</button>

			<a class="navbar-brand" href="${root }/">Spring Legacy</a>
		</div>

		<div class="collapse navbar-collapse" id="Navbar">
			<ul class="nav navbar-nav">
				<li class="active">
				<li><a href="MainBoard">게시판</a></li>
			</ul>


			<ul class="nav navbar-nav">
				<li class="dropdown"><a class="dropdown-toggle" href="#"
					data-toggle="dropdown" aria-expanded="false"> 클릭 </a>
					<ul class="dropdown-menu dropdown-menu-dark">
						<li><a class="dropdown-item" href="#">로그인</a></li>
						<li><a class="dropdown-item" href="${root}/memberJoin">회원가입</a></li>
					</ul></li>
			</ul>

			<ul class="nav navbar-nav">
				<li class="dropdown"><a class="dropdown-toggle" href="#"
					data-toggle="dropdown" aria-expanded="false"> 정보 </a>
					<ul class="dropdown-menu dropdown-menu-dark">
						<li><a class="dropdown-item" href="#">회원수정</a></li>
						<li><a class="dropdown-item" href="#">사진</a></li>
						<li><a class="dropdown-item" href="#">로그아웃</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
</nav>
