<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>

	<div class="container">
		<h1>즐겨 찾기 추가하기</h1>
		<label>제목</label>
		<input type="text" class="form-control" id="nameInput">
		
		<label class="mt-3">주소</label>

		<div class="d-flex">
			<input type="text" class="form-control" id="urlInput">
			<button type="button" class="btn btn-info" id="duplicateBtn">중복확인</button>
		</div>

		<button type="button" id="addBtn"  class="btn btn-success btn-block mt-3">추가</button>
	</div>
	
	<script>
		$(document).ready(function() {
			
			$("#duplicateBtn").on("click", function() {
				let url = $("#urlInput").val();
				
				if(url == "") {
					alert("주소를 입력하세요");
					return ;
				}
				
				if(!(url.startsWith("http://") || url.startsWith("https://"))) {
					alert("주소 형식이 잘못되었습니다.");
					return ;
				}
				
				
				$.ajax({
					type:"post"
					, url:"/ajax/favorite/is_duplicate"
					, data:{"url":url}
					, success:function(data) {
						
						if(data.is_duplicate) {
							alert("중복되었습니다.");
						} else {
							alert("사용가능합니다.");
						}
					}
					, error:function() {
						alert("중복확인 에러");
					}
				
				});
				
				
				
			});
			
		
			
			$("#addBtn").on("click", function() {
				
				let name = $("#nameInput").val();
				let url = $("#urlInput").val();
				
				if(name == "") {
					alert("이름 입력하세요");
					return;
					
				}
				
				if(url == "") {
					alert("주소를 입력하세요");
					return ;
				}
				
				// https://, http://
				// http 로 시작하지 않고 https로 시작하지 않으면
				// if(!url.startsWith("http://") && !url.startsWith("https://")) {
				if(!(url.startsWith("http://") || url.startsWith("https://"))) {
					alert("주소 형식이 잘못되었습니다.");
					return ;
				}
				
				
				$.ajax({
					type:"post"
					, url:"/ajax/favorite/add"
					, data:{"name":name, "url":url}
					, success:function(data) {
						
						// 성공시 : {"result":"success"}
						// 실패시 : {"result":"fail"}
						if(data.result == "success") {
							location.href = "/ajax/favorite/list";
						} else {
							alert("추가 실패");
						}
						
					}
					, error:function() {
						alert("추가 에러");
					}
					
				});
				
				
			});
			
		});
	
	</script>

</body>
</html>