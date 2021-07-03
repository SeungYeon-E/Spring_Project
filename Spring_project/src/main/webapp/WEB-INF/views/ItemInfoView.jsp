<%@page import="com.spring.bbs.project.dto.ItemInfoDto"%>
<%@page import="com.spring.bbs.project.command.ItemInfoInsertCommand"%>
<%@page import="com.spring.bbs.project.dao.ItemInfoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<%@include file="Header.jsp"%>

<style>
* {
	box-sizing: border-box;
}

input[type="button"] {
	margin-top: 10px;
	text-align: center;
	width: 30%;
	height: 32px;
	background: #008CBA;
	border: none;
	border-radius: 2px;
	color: #FFF;
}

input[type="button"]:hover, 
input[type="button"]:focus {
	opacity: 0.8;
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.4);
	transition: 0.1s ease;
}

input[type="button"]:active {
	opacity: 1;
	box-shadow: 0 1px 2px rgba(0, 0, 0, 0.4);
	transition: 0.1s ease;
}

body {
	font-family: Arial, Helvetica, sans-serif;
}

/* Style the header */
@import
	url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap')
	;

* {
	margin: 0px;
	padding: 0px;
	list-style: none;
	text-decoration: none;
	color: black;
	font-family: 'Noto Sans KR', sans-serif;
}

article {
	float: center;
	padding: 20px;
	width: 100%;
	background-color: white;
	height: 640px; /* only for demonstration, should be removed */
}

/* Clear floats after the columns */
section::after {
	content: "";
	display: table;
	clear: both;
}

table{
  border-collapse: separate;
  border-spacing: 0 5px;
}


/* Responsive layout - makes the two columns/boxes stack on top of each other instead of next to each other, on small screens */
@media ( max-width : 1000px) {
	nav, article {
		width: 100%;
		height: auto;
	}
}
</style>
</head>
		<script type="text/javascript">
			//Empty Check
			function ItemView(){
				var form = document.ItemInsert
				if(form.I_TITLE.value==""){
					alert("제목을 입력해주세요!"); //alert에 있는 명령은 중요한 것 쓰지 않고 사소한 것만 쓰기!!
					form.I_TITLE.focus();
					return false;
				}
				
				else if(form.I_CATEGORY.value==""){
					alert("카테고리를 선택해주세요!");
					form.I_CATEGORY.focus();
					return false;
				}
				
				else if(form.I_IMAGE.value==""){
					alert("사진을 첨부해주세요!");
					form.I_IMAGE.focus();
					return false;
				}

				else if(form.I_CONTENT.value==""){
					alert("내용을 입력해주세요!");
					form.I_CONTENT.focus();
					return false;
				}
				
			//Length Check
		
		/* 	else if(form.I_CONTENT.value.length <50000){
				alert("내용은 50000자 이하로 입력해야 합니다.");
				form.I_CONTENT.select();
				return false;
				} */
			else{
				alert("작성에 성공하셨습니다.");
			}
				form.submit();
			}
			
		</script>

<body>
	<section>
		<article>
			<div class="write-container">
				<!-- <div class="row"> -->
					<form action="ItemInfoInsert.do" method="post" name="ItemInsert"
						enctype="multipart/form-data">
						<div style="text-align: center;">
						<h2>물건리뷰게시글 작성하기</h2>
						<br>
						</div>
						<table class="table table-bordered"
							style="margin-left: auto; margin-right: auto; text-align: left;" width=1300 border=0 cellpadding=2>
								<tr>
								<th>글 제목 </th>
								<td><input type="text" name="I_TITLE" placeholder="글 제목"  style="margin: 1px; width: 1160px;" class="form-control"></td>
							</tr>
							<tr>
								<th>카테고리 </th>
								<td><select name="I_CATEGORY" style="margin: 0px; width: 1160px;">
										<option value="none">선택하세요</option>
										<option value="컴퓨터" selected="selected">컴퓨터</option>
										<option value="악세사리" selected="selected">악세사리</option>
										<option value="책상" selected="selected">책상</option>
										<option value="기타" selected="selected">기타</option>
								</select></td>
							</tr>

							<tr>
								<th>사진추가 </th>
								<td><input type="file" name="I_IMAGE" multiple></td>
							</tr>
							<tr>
							<th>내용</th>
								<td><textarea style="margin: 1px; width: 1160px; height: 386px;" name="I_CONTENT"
								 class="form-control" placeholder="내용을 입력하세요."></textarea></td>
							</tr>
						</table>
					
						<div style="text-align: center;">
						<input type="button" value="확인" onclick="ItemView()">
						</div>
					</form>
				</div>
			<!-- </div> -->
		</article>
	</section>
	<footer><%@include file="Footer.jsp"%></footer>
</body>
</html>