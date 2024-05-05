<!-- 예약하기(시간) -->
<!--JSTL tag  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<title>Time Select</title>
</head>
<body>
	<%@ include file="common/navigation.jspf"%>
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th>Lunch</th>
					<th></th>
					<th></th>
					<th>Dinner</th>
					<th></th>

				</tr>
			</thead>
			<tbody>
				<!--모든 reservations를 반복  -->
				<tr>
					<td><button type="button">11</button></td>
					<td><button type="button">12</button></td>
					<td><button type="button">13</button></td>

					<td><button type="button">17</button></td>
					<td><button type="button">18</button></td>
					<td><button type="button">19</button></td>
				</tr>


			</tbody>
		</table>
	</div>
	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>

</html>