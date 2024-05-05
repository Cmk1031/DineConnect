<!-- 홈 화면 -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<title>Welcome Page</title>
</head>
<body>
	<%@ include file="common/navigation.jspf"%>
	<div class="container">
		<h1>소개, 사진 등</h1>
		
		<div>
			<a href="list-reservations">예약하기</a> 
		</div>
		
		
		<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
		<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
	</div>
</body>

</html>