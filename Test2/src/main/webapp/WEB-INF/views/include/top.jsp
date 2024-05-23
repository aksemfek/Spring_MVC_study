<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }" />
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container-fluid">
		<div class="navbar-header">
			<button class="navbar-toggle" type="button" data-toggle="collapse"
				data-target="#Navbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${root }/">Spring Legacy</a>
		</div>

		<div class="collapse navbar-collapse" id="Navbar">
			<ul class="nav navbar-nav">
				<li><a href="MainBoard">게시판</a></li>
			</ul>

			<c:if test="${empty memberVo }">
				<!-- 회원정보 비어있을 경우 -->
				<ul class="nav navbar-nav navbar-right">
					<li><a href="${root }/memberLoginForm"> <span
							class="people"> 로그인 </span>
					</a></li>
					<li><a class="dropdown-item" href="${root }/memberJoin">회원가입</a></li>
				</ul>
			</c:if>

			<c:if test="${!empty memberVo }">
				<ul class="nav navbar-nav navbar-right">

					<li><a href="${root }/memberUpdateForm">회원수정</a></li>
					<li><a href="${root }/memberImageForm">사진</a></li>
					<li><a href="${root }/memberLogout">로그아웃</a></li>
					
					<c:if test="${!empty memberVo }">
						<%-- <c:if test="${memberVo.memberProfile eq '' }">
							<li><img src="${root }/resources/images/bo.jpeg"
								style="width: 50px; height: 50px;" />${memberVo.memberName }님
								안녕하세요!</li>
						</c:if> --%>

						<c:if test="${memberVo.memberProfile ne '' }">
							<li><img
								src="${root }/resources/upload/${memberVo.memberProfile}"
								style="width: 50px; height: 50px;" />${memberVo.memberName }님
								안녕하세요!</li>
						</c:if>
					</c:if>
				</ul>
			</c:if>
		</div>
	</div>
</nav>