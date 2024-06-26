<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="root" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="en">
<head>
<title>우리반 화이팅♥</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=fefc41acd5be31226ac1be47352506ca"></script>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=bb784ffcffa43568cb0b05ad80cc6f94"></script>
<script type="text/javascript">
  $(document).ready(function(){
  	var result='${result}';     	
  	checkModal(result); 
  	 
  	$("#regBtn").click(function(){
  		location.href="${root}/board/register";
  	}); 
  	var pageFrm=$("#pageFrm");
  	$(".paginate_button a").on("click", function(e){
  		e.preventDefault(); 
  		var page=$(this).attr("href"); // 페이지번호
  		pageFrm.find("#page").val(page);
  		pageFrm.submit(); 		
  	});    	
  
  	$(".moving").on("click", function(e){
  		e.preventDefault(); 
  		var idx=$(this).attr("href");
  		var tag="<input type='hidden' name='idx' value='"+idx+"'/>";
  		pageFrm.append(tag);
  		pageFrm.attr("action","${root}/board/get");
  		pageFrm.attr("method","get");
  		pageFrm.submit();
  	});
  	$("#search").click(function(){
  		var bookname=$("#bookname").val();
  		if(bookname==""){
  			alert("책 제목을 입력하세요");
  			return false;
  		}
  		//url복사
  		//헤더
  		$.ajax({
  			url : "https://dapi.kakao.com/v3/search/book?target=title",
  			headers : {"Authorization": "KakaoAK 5d812b73c549a3868e80aa4d5710e5c8"},
  			type : "get",
  			data : {"query" : bookname},
  			dataType : "json",
  			success : book,
  			error : function(){ alert("error");}	
  		});
  		//$(document).ajaxStart(function(){ $(".loading-progress").show(); });
  		//$(document).ajaxStop(function(){ $(".loading-progress").hide(); });
  	});    	
  	
   //input box에 책 제목이 입력되면 자동으로 검색 
  	$("#bookname").autocomplete({
  		source : function(){ 
  			var bookname=$("#bookname").val();
  			$.ajax({
  				url : "https://dapi.kakao.com/v3/search/book?target=title",
  	  			headers : {"Authorization": "KakaoAK 5d812b73c549a3868e80aa4d5710e5c8"},
      			type : "get",
      			data : {"query" : bookname},
      			dataType : "json",
      			success : book,
      			error : function(){ alert("error");}	
      		});
  		},
  		minLength : 1    		//최소한자이상입려고되면 function실행
  	}); 
//지도 mapBtn클릭시 지도가 보이도록 하기
  	 $("#mapBtn").click(function(){
  		var address=$("#address").val();
  		if(address==''){
  			alert("주소를 입력하세요");
  			return false;
  		}
  		$.ajax({
  			url : "https://dapi.kakao.com/v2/local/search/address.json",
  			headers : {"Authorization": "KakaoAK 5d812b73c549a3868e80aa4d5710e5c8"},
  			type : "get",
  			data : {"query" : address},
  			dataType : "json",
  			success : mapView,
  			error : function() { alert("error"); }  			
  		});
  	}); 
   });
   function checkModal(result){
       	 
  	 if(result==''){
  		 return;
  	 }    	 
  	 if(parseInt(result)>0){
  		 // 새로운 다이얼로그 창 띄우기
  		 $(".modal-body").html("게시글 "+parseInt(result)+"번이 등록되었습니다.");
  	 }
  	 $("#myModal").modal('show');
   }
   function del(){
  	 alert("삭제된 게시물입니다."); // Modal창
   }
    function book(data){
  	 var bList="<table class='table table-hover'>";
  	 bList+="<thead>";
  	 bList+="<tr>";
  	 bList+="<th>책이미지</th>";
  	 bList+="<th>책가격</th>";
  	 bList+="</tr>";
  	 bList+="</thead>";
  	 bList+="<tbody>";
  	 $.each(data.documents,function(index, obj){
  		 var image=obj.thumbnail;
  		 var price=obj.price;
  		 var url=obj.url;
  		 bList+="<tr>";
      	 bList+="<td><a href='"+url+"'><img src='"+image+"' width='50px' height='60px'/></a></td>";
      	 bList+="<td>"+price+"</td>";
      	 bList+="</tr>";
  	 }); 
  	 bList+="</tbody>";
  	 bList+="</table>";
  	 $("#bookList").html(bList);
   }
  

// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
   function mapView(data){
	 var x=data.documents[0].x; // 경도
	 var y=data.documents[0].y; // 위도
  	 var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
  	    mapOption = { 
  	        center: new kakao.maps.LatLng(y, x), // 지도의 중심좌표
  	        level:2 // 지도의 확대 레벨
  	    };

  	var map = new kakao.maps.Map(mapContainer, mapOption); 
  	

 // 마커가 표시될 위치입니다 
  	var markerPosition  = new kakao.maps.LatLng(y, x); 

  	// 마커를 생성합니다
  	var marker = new kakao.maps.Marker({
  	    position: markerPosition
  	});

  	// 마커가 지도 위에 표시되도록 설정합니다
  	marker.setMap(map);

  	var iwContent = '<div style="padding:5px;">${mem.memberName}</div>', 
  	    iwRemoveable = true; 

  	// 인포윈도우를 생성합니다
  	var infowindow = new kakao.maps.InfoWindow({
  	    content : iwContent,
  	    removable : iwRemoveable
  	});

  	// 마커에 클릭이벤트를 등록합니다
  	kakao.maps.event.addListener(marker, 'click', function() {
  	      // 마커 위에 인포윈도우를 표시합니다
  	      infowindow.open(map, marker);  
  	});
   } 
  </script>

</head>
<body>

	<div class="card">
		<div class="card-header">
			<div class="jumbotron jumbotron-fluid">
				<div class="container">
					<h1>화이팅♥</h1>

				</div>
			</div>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col-lg-2">
					<jsp:include page="left.jsp" />
				</div>
				<div class="col-lg-7">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>작성자</th>
								<th>작성일</th>
								<th>조회수</th>
							</tr>
						</thead>
						<c:forEach var="vo" items="${list}">
							<tr>
								<td>${vo.idx}</td>
								<td><c:if test="${vo.boLevel>0}">
										<c:forEach begin="1" end="${vo.boLevel}">
											<span style="padding-left: 10px"></span>
										</c:forEach>
										<i class="bi bi-arrow-return-right"></i>
									</c:if> <c:if test="${vo.boLevel>0}">
										<c:if test="${vo.boUsable==1}">
											<a class="moving" href="${vo.idx}"><c:out
													value='[RE]${vo.title}' /></a>
										</c:if>
										<c:if test="${vo.boUsable==0}">
											<a href="javascript:del()">[RE]삭제된 게시물입니다.</a>
										</c:if>
									</c:if> <c:if test="${vo.boLevel==0}">
										<c:if test="${vo.boUsable==1}">
											<a class="moving" href="${vo.idx}"><c:out
													value='${vo.title}' /></a>
										</c:if>
										<c:if test="${vo.boUsable==0}">
											<a href="javascript:del()">삭제된 게시물입니다.</a>
										</c:if>
									</c:if></td>
								<td>${vo.writer}</td>
								<td><fmt:formatDate pattern="yyyy-MM-dd"
										value="${vo.indate}" /></td>
								<td>${vo.count}</td>
							</tr>
						</c:forEach>
						<c:if test="${!empty mem}">
							<tr>
								<td colspan="5">
									<button id="regBtn" class="btn btn-sm btn-secondary pull-right">글쓰기</button>
								</td>
							</tr>
						</c:if>
					</table>
					<!-- 검색메뉴 -->
					<form class="form-inline" action="${root}/board/list" method="post">
						<div class="container">
							<div class="input-group mb-3">
								<div class="input-group-append">
									<select name="type" class="form-control">
										<option value="writer"
											${pageCre.cri.type=='writer' ? 'selected' : ''}>이름</option>
										<option value="title"
											${pageCre.cri.type=='title' ? 'selected' : ''}>제목</option>
										<option value="content"
											${pageCre.cri.type=='content' ? 'selected' : ''}>내용</option>
									</select>
								</div>
								<input type="text" class="form-control" name="keyword"
									value="${pageCre.cri.keyword}">
								<div class="input-group-append">
									<button class="btn btn-success" type="submit">Search</button>
								</div>
							</div>
						</div>
					</form>
					<!-- 페이징 START -->
					<ul class="pagination justify-content-center">
						<!-- 이전처리 -->
						<c:if test="${pageCre.prev}">
							<li class="paginate_button previous page-item"><a
								class="page-link" href="${pageCre.startPage-1}">Previous</a></li>
						</c:if>
						<!-- 페이지번호 처리 -->
						<c:forEach var="pageNum" begin="${pageCre.startPage}"
							end="${pageCre.endPage}">
							<li
								class="paginate_button ${pageCre.cri.page==pageNum ? 'active' : ''} page-item"><a
								class="page-link" href="${pageNum}">${pageNum}</a></li>
						</c:forEach>
						<!-- 다음처리 -->
						<c:if test="${pageCre.next}">
							<li class="paginate_button next page-item"><a
								class="page-link" href="${pageCre.endPage+1}">Next</a></li>
						</c:if>
					</ul>

					<!-- END -->
					<form id="pageFrm" action="${root}/board/list" method="post">
						<!-- 게시물 번호(idx)추가 -->
						<input type="hidden" id="page" name="page"
							value="${pageCre.cri.page}" /> <input type="hidden"
							name="perPageNum" value="${pageCre.cri.perPageNum}" /> <input
							type="hidden" name="type" value="${pageCre.cri.type}" /> <input
							type="hidden" name="keyword" value="${pageCre.cri.keyword}" />
					</form>
					<!-- Modal 추가 -->
					<div id="myModal" class="modal fade" role="dialog">
						<div class="modal-dialog">

							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header">
									<h4 class="modal-title">MESSAGE</h4>
									<button type="button" class="close" data-dismiss="modal">&times;</button>
								</div>
								<div class="modal-body"></div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Close</button>
								</div>
							</div>

						</div>
					</div>
					<!-- Modal END -->
				</div>
				<div class="col-lg-3">
					<jsp:include page="right.jsp" />
				</div>
			</div>
		</div>
	</div>


</body>
</html>