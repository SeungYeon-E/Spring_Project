<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file ="Header.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<script src="https://unpkg.com/@webcreate/infinite-ajax-scroll/dist/infinite-ajax-scroll.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	/* search 수정 */
	.search {
    	position: relative;
    	text-align: center;
    	width: 900px;
    	margin: 0 auto;
    	font-family: Georgia, Serif;
		font-size: 30px;
	}
	
	input {
    	width: 100%;
    	border-radius: 20px;
    	border: 1px solid #bbb;
    	margin: 10px 0;
    	padding: 10px 12px;
    	font-family: fontAwesome;
	}
	
	.box {
    display: inline;
    width: auto;
    border-radius: 0;
    margin: auto;
    text-align: center;
    color: #bbb;
	}

	.category {
		margin-left:200px;
		margin-top:10px;
		
	}
	.category div {
		 display: inline-block;
		 padding: 12px;
		 padding-left: 20px;
		 padding-right: 20px;
		 margin: 0px;
		 border-radius: 30px;
	}
	
	.columns{
		column-width:250px;
		column-gap: 15px;
		max-width: 1300px;
		margin: 50px auto;
		
		font-family: Georgia, Serif;
		font-size: 20px;
	}
	.columns figure{
		display: inline-block;
		/* border : 1px solid rgba(0,0,0,0.2); */
		margin:0;
		
		margin-bottom: 30px;
		/* box-shadow:10px 10px 5px rgba(2,2,2,0.2); */
	}
	
	.columns figure img{
		width: 100%;
		border-radius: 20px;
	}
	
	.columns figcaption {
		margin-left:20px;
	}
	
	figure:hover img{
	opacity: 0.4;
	}
	
</style>

</head>
	<body>
		<form action="search.do?table=${CATEGORY }&condition=${CONDITION }" method="post">
			
			<div class="search">
    			<script src="https://kit.fontawesome.com/8eb5905426.js" crossorigin="anonymous"></script>
    			<input type="text" name="searched" placeholder="&#xf002; search" >
    		</div>
    	<div class="category">
				<div style="color: rgb(250,250,250); background-color: rgb(0,0,0);"onclick="location.href='list2.do';">ALL</div>
				<div style="color: rgb(250,250,250); background-color: rgb(255,149,0);"onclick="location.href='CodeTip.do';">CODE</div></a>
				<div style="color: rgb(250,250,250); background-color: rgb(88,86,214);"onclick="location.href='ProtoTip.do';">PROTOTYPE</div>
				<div style="color: rgb(250,250,250); background-color: rgb(52,199,89);"onclick="location.href='InfoTip.do';">INFO</div>
				<div style="color: rgb(250,250,250); background-color: rgb(255,204,0);"onclick="location.href='OtherTip.do';">OTHERS</div>
		</div>
			
		<div class="columns">
				<c:forEach items="${list}" var="dto">
  					<figure class="item"> 
  						<a href="ContentViewItem.do?t_num=${dto.num }"><img src=${dto.image }></a>
  							<figcaption>
  								<div>${dto.title }</div>
  								<div id="views">${dto.views  } Views</div>
  							</figcaption>	
					</figure>
				</c:forEach>
			</div>
		</form>
		<div class="pager">
			<a href="<%session.getAttribute("do");%>?page=next" class="pager__next"></a>
			</div>
			
		<script>
		let ias = new InfiniteAjaxScroll('.columns', {
		 item: '.item',
		 next: '.pager__next',
		 pagination: '.pager',
		 
		});
		
		</script>
		<%@include file ="Footer.jsp" %>
</body>

</html>