<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<script type="text/javascript">
	function modifyComment() {
		var form = document.commenttext;
		//Empty Check
		if (form.ic_content.value.trim() == "") {
			alert("comment를 입력하세요!");
			form.ic_content.focus();
			return false;
		}
		form.submit();
	}
</script>
<style>
.container {
	text-align: center;
	position: absolute;
	left: 50%;
	top: 50%;
	transform : translate(-50%, -50%);
}
</style>
<head>
<meta charset="UTF-8">
<title>comment modify</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>
	<form action="CommentModifyItem" name="commenttext" method="post">
		<div class="container">
			<div>
				<input type="hidden" name="ic_num" size="20" value="${commentcontent_view.ic_num}">
				<input type="text" name="ic_content" size="50" value="${commentcontent_view.ic_content}" class="form-control">
			</div>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<div>
				<button type="button" onclick="modifyComment();" class="btn btn-primary pull-right">수정하기</button>
				<button type="reset" class="btn btn-primary pull-right">되돌리기</button>
			</div>
		</div>
	</form>
</body>
</html>