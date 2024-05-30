<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>학생 정보 목록</title>
<style>
body {
	display: flex;
	justify-content: flex-start;
	align-items: flex-start;
	height: 100vh;
	margin: 0;
	padding: 0;
}

.container {
	background-color: #f0f0f0;
	padding: 20px;
	border-radius: 10px;
	width: 30%;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	margin: 20px;
}

#detailsContainer {
	background-color: #f9f9f9;
	padding: 20px;
	border-radius: 10px;
	width: 30%;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	margin: 20px;
}

table {
	width: 100%;
	border-collapse: collapse;
}

th, td {
	border: 1px solid #ddd;
	padding: 8px;
	text-align: left;
}

th {
	background-color: #f2f2f2;
}

tr:hover {
	background-color: #f1f1f1;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		loadStudent();
	});

	function loadStudent() {
		$.ajax({
			url : "main/list",
			type : "get",
			dataType : "json",
			success : make,
			error : function() {
				alert("학생 목록을 불러오는 데 실패했습니다.");
			}
		});
	}

	function make(data) {
		var table = "<table class='table table-striped'>";
		table += "<tr><th>번호</th><th>이름</th><th></th></tr>";
		$
				.each(
						data,
						function(index, student) {
							table += "<tr>";
							table += "<td>" + student.idx + "</td>";
							table += "<td>" + student.name + "</td>";
							table += "<td>";
							table += "<button type='button' class='btn btn-primary' onclick='stuDetails("
									+ student.idx + ")'>자세히 보기</button> ";
							table += "</td>";
							table += "</tr>";
						});
		table += "</table>";
		$("#studentList").html(table);
	}

	function stuDetails(id) {
		$
				.ajax({
					url : "main/student/" + id,
					type : "get",
					dataType : "json",
					success : function(student) {
						var details = "<h2>학생 정보</h2>";
						details += "<p><strong>번호:</strong> " + student.idx
								+ "</p>";
						details += "<p><strong>이름:</strong> " + student.name
								+ "</p>";
						details += "<p><strong>주소:</strong> " + student.addr
								+ "</p>";
						details += "<p><strong>대학교:</strong> " + student.uni
								+ "</p>";
						details += "<p><strong>전공:</strong> " + student.major
								+ "</p>";
						details += "<button type='button' class='btn btn-warning' onclick='editStudent("
								+ student.idx + ")'>수정</button> ";
						details += "<button type='button' class='btn btn-danger' onclick='deleteStudent("
								+ student.idx + ")'>삭제</button>";
						$("#detailsContainer").html(details);
					},
					error : function() {
						alert("학생 정보를 불러오는 데 실패했습니다.");

					}
				});
	}

	function updateStudent(id) {
		var editedAddr = $("#editAddr").val();
		var editedUni = $("#editUni").val();
		var editedMajor = $("#editMajor").val();

		// 수정할 정보를 객체에 담기
		var updatedStudent = {
			idx : id,
			addr : editedAddr,
			uni : editedUni,
			major : editedMajor
		};

		// Ajax 요청으로 수정된 정보 전송
		$.ajax({
			url : "main/update/" + id,
			type : "put",
			contentType : "application/json",
			data : JSON.stringify(updatedStudent),
			success : function() {
				// 성공적으로 수정되었을 때의 동작
				alert("학생 정보가 성공적으로 수정되었습니다.");
				// 수정 모달 닫기
				$('#detailsContainer').modal('hide');
				// 학생 목록 다시 불러오기
				loadStudent();
			},
			error : function() {
				// 수정 실패 시의 동작
				alert("학생 정보를 수정하는 데 실패했습니다.");
			}
		});
	}

	function editStudent(id) {
		$
				.ajax({
					url : "main/student/" + id,
					type : "get",
					dataType : "json",
					success : function(student) {
						var details = "<h2>학생 정보 수정</h2>";
						details += "<form id='editForm'>";
						details += "<div class='form-group'>";
						details += "<label for='editName'>이름:</label>";
						details += "<input type='text' class='form-control' id='editName' value='" + student.name + "' readonly>";
						details += "</div>";
						details += "<div class='form-group'>";
						details += "<label for='editAddr'>주소:</label>";
						details += "<input type='text' class='form-control' id='editAddr' value='" + student.addr + "'>";
						details += "</div>";
						details += "<div class='form-group'>";
						details += "<label for='editUni'>대학교:</label>";
						details += "<input type='text' class='form-control' id='editUni' value='" + student.uni + "'>";
						details += "</div>";
						details += "<div class='form-group'>";
						details += "<label for='editMajor'>학과:</label>";
						details += "<input type='text' class='form-control' id='editMajor' value='" + student.major + "'>";
						details += "</div>";
						details += "<button type='button' class='btn btn-success' onclick='updateStudent("
								+ id + ")'>저장</button>";
						details += "</form>";

						// 모달 열기
						$("#detailsContainer").html(details);
					},
					error : function() {
						alert("학생 정보를 불러오는 데 실패했습니다.");
					}
				});
	}
	
	function searchStudent() {
	    var searchName = $("#searchInput").val().trim();

	    // 검색어가 비어있지 않은 경우에만 서버로 요청
	    if (searchName !== "") {
	        $.ajax({
	            url: "main/search",
	            type: "get",
	            data: { name: searchName },
	            dataType: "json",
	            success: function(data) {
	                if (data.length > 0) {
	                    make(data); // 검색 결과가 있을 때
	                } else {
	                    showAddStudentForm(); // 검색 결과가 없을 때 등록 폼 표시
	                }
	            },
	            error: function() {
	                alert("학생 목록을 불러오는 데 실패했습니다.");
	            }
	        });
	    } else {
	        // 검색어가 비어있을 경우 학생 정보 등록 폼 보여주기
	        showAddStudentForm();
	    }
	}

	function showAddStudentForm() {
	    var form = "<h2>학생 정보 등록</h2>";
	    form += "<form id='addStudentForm'>";
	    form += "<div class='form-group'>";
	    form += "<label for='nameInput'>이름:</label>";
	    form += "<input type='text' class='form-control' id='nameInput' required>";
	    form += "</div>";
	    form += "<div class='form-group'>";
	    form += "<label for='addrInput'>주소:</label>";
	    form += "<input type='text' class='form-control' id='addrInput'>";
	    form += "</div>";
	    form += "<div class='form-group'>";
	    form += "<label for='uniInput'>대학교:</label>";
	    form += "<input type='text' class='form-control' id='uniInput'>";
	    form += "</div>";
	    form += "<div class='form-group'>";
	    form += "<label for='majorInput'>학과:</label>";
	    form += "<input type='text' class='form-control' id='majorInput'>";
	    form += "</div>";
	    form += "<button type='button' class='btn btn-success' onclick='addStudent()'>등록</button>";
	    form += "</form>";

	    $("#studentList").html(form);
	}

	function addStudent() {
	    var name = $("#nameInput").val().trim();
	    var addr = $("#addrInput").val().trim();
	    var uni = $("#uniInput").val().trim();
	    var major = $("#majorInput").val().trim();

	    if (name === "") {
	        alert("이름을 입력해주세요.");
	        return;
	    }

	    // 학생 정보를 서버로 전송하여 등록
	    $.ajax({
	        url: "main/add",
	        type: "post",
	        contentType: "application/json",
	        data: JSON.stringify({ name: name, addr: addr, uni: uni, major: major }),
	        success: function() {
	            alert("학생 정보가 성공적으로 등록되었습니다.");
	            // 등록 후 다시 학생 목록 불러오기
	            loadStudent();
	        },
	        error: function() {
	            alert("학생 정보를 등록하는 데 실패했습니다.");
	        }
	    });
	}
</script>
</head>
<body>
	<div class="container">
		<h1>학생 정보 목록</h1>
		<form id="searchForm">
			<input type="text" id="searchInput" placeholder="이름 검색">
			<button type="button" class="btn btn-primary"
				onclick="searchStudent()">검색</button>
		</form>
		<div id="studentList"></div>
		<!-- 데이터가 표시될 위치 -->
	</div>
	<div id="detailsContainer" class="container">
		<!-- 자세히 보기 클릭 시 데이터가 표시될 위치 -->
	</div>

</body>
</html>
