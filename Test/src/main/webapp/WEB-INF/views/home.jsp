<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script type="text/javascript">
 $(document).ready(function(){
	 loadBoard();
 });

 function loadBoard(){
	 $.ajax({
		 url: "boardList",
		 type: "get",
		 dataType: "json",
		 success: make,
		 error: function(){
			 alert("error");
		 }
	 });
 }
 
function make(data){
	
	var li="<table class='table table-bordered'>";
	li+="<tr>";
	li+="<td>글번호</td>";
	li+="<td>제목</td>";
	li+="<td>글쓴이</td>";
	li+="<td>작성일</td>";
	li+="<td>조회수</td>";
	li+="</tr>";
	
	$.each(data, function(index,obj){ //obj={"idx":1, "title":"제목1"...}
		li+="<tr>";
		li+="<td>"+obj.idx+"</td>"; // 글번호 idx값 가지고 goContent함수
		li+="<td id='tit"+obj.idx+"'><a href='javascript:goContent("+obj.idx+")'>"+obj.title+"</a></td>";
		li+="<td>"+obj.writer+"</td>";
		li+="<td>"+obj.indate.split(' ')[0]+"</td>";
		li+="<td id='cnt"+obj.idx+"'>"+obj.count+"</td>";
		li+="</tr>";
		
		li+="<tr id='con"+obj.idx+"' style='display:none'>";
		li+="<td>내용</td>";
		li+="<td colspan='4'>";
		li+="<textarea id='ta"+obj.idx+"' readonly rows='7' class='form-control'></textarea>";
		li+="<br/>";
		li+="<span id='up"+obj.idx+"'><button class='btn btn-success btn-sm' onclick='goUpdateForm("+obj.idx+")'>수정화면</button></span>&nbsp;";
		li+="<button class='btn btn-danger btn-sm' onclick='goDelete("+obj.idx+")'>삭제</button>";        	 
		li+="</td>";
		li+="</tr>";
		
	});
	
	li+="<tr>";
	li+="<td colspan='5'>";
	li+="<button class='btn btn-primary btn-sm' onclick='getForm()'>글작성</button>";
	li+="</td>";
	li+=<"/tr>";
	li+="</table>";
	
	$("#view").html(li);
	$("#view").css("display","block");
	$("#wfrom").css("display","none");
	
	
	
}

function getForm() {
	$("#wfrom").css("display", "block");
}
</script>
</head>
<body>
	<div class="container">
		<h2>Spring Legacy</h2>
		<div class="panel panel-default">
			<div class="panel-heading">게시판</div>
			<div class="panel-body" id="view">본문</div>
			<div class="panel-body" id="wfrom">
				<form id="frm">
					<table class="table">
						<tr>
							<td>제목</td>
							<td><input type="text" id="title" name="title"
								class="form-control" /></td>
						</tr>
						<tr>
							<td>내용</td>
							<td><textarea rows="7" class="form-control" id="content"
									name="content"></textarea></td>
						</tr>
						<tr>
							<td>글쓴이</td>
							<td><input type="text" id="writer" name="writer"
								class="form-control" /></td>
						</tr>
						<tr>
							<td colspan="2" align="center">
								<button type="button" class="btn btn-success btn-sm"
									onclick="goInsert()">등록</button>
								<button type="reset" class="btn btn-warning btn-sm"
									id="formclear">취소</button>
								<button type="button" class="btn btn-info btn-sm"
									onclick="goList()">리스트</button>
							</td>
						</tr>
					</table>
				</form>
			</div>
			<div class="panel-footer">비트캠프</div>
		</div>
	</div>
</body>
</html>