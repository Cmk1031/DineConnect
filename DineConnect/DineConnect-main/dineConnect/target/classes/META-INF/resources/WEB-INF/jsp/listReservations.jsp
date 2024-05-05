<!--JSTL tag -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 예약하기(날짜) -->

<html>
<head>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
          rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css"/>
    <!-- DateRangePicker CSS 사용 -->
    <title>List Reservation Page</title>
</head>
<body>
<%@ include file="common/navigation.jspf" %>


<div class="container">
    <form id="reservationForm" action="make-reservation" method="get">
        <input type="text" id="date" name="date" />
        <div class="container" style="display:none" id="timeButtonContainer">
        <table class="table">
            <thead>
            <tr>
            </tr>
            </thead>
            <tbody>
            <!--모든 reservations를 반복  -->
            <tr>
                <input type="hidden" name="time" id="selectedTime"/>

                <td>
<%--                    <button type="button" class="timeSelectBtn">09:00</button>--%>
					<button type="button" onclick="selectTime('09:00')">09:00</button>
                </td>
                <td>
					<button type="button" onclick="selectTime('10:00')">10:00</button>
                </td>
                <td>
					<button type="button" onclick="selectTime('11:00')">11:00</button>
                </td>
            </tr>
            <tr>
                <td>
<%--                    <button type="button" class="timeSelectBtn">12:00</button>--%>
					<button type="button" onclick="selectTime('12:00')">12:00</button>
                </td>
                <td>
<%--                    <button type="button" class="timeSelectBtn">13:00</button>--%>
					<button type="button" onclick="selectTime('13:00')">13:00</button>
                </td>
                <td>
<%--                    <button type="button" class="timeSelectBtn">14:00</button>--%>
	                <button type="button" onclick="selectTime('14:00')">14:00</button>
                </td>
            </tr>
            <tr>
                <td>
<%--                    <button type="button" class="timeSelectBtn">17:00</button>--%>
                    <button type="button" onclick="selectTime('17:00')">17:00</button>
                </td>
                <td>
<%--                    <button type="button" class="timeSelectBtn">18:00</button>--%>
                    <button type="button" onclick="selectTime('18:00')">18:00</button>
                </td>
                <td>
<%--                    <button type="button" class="timeSelectBtn">19:00</button>--%>
                    <button type="button" onclick="selectTime('19:00')">19:00</button>
                </td>
                <td>
<%--                    <button type="button" class="timeSelectBtn">20:00</button>--%>
                    <button type="button" onclick="selectTime('20:00')">20:00</button>
                </td>
            </tr>
            </tbody>
        </table>
        <button type="submit" onclick="reserBtn()">예약하기</button>
        </div>

    </form>
    <%--			<div class="container" style="display:none" id="timeButtonContainer">--%>
    <%--				--%>
    <%--			</div>--%>
</div>
<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>

<!-- 날짜 선택 -->
<script>
    $(function () {
        $('#date').daterangepicker({
            singleDatePicker: true,
            showDropdowns: true,

            minDate: moment(),
            maxYear: parseInt(moment().format('YYYY'), 1),
            locale: {
                format: 'YYYY-MM-DD' // 날짜 형식 설정
            //     daysOfWeek: ["일", "월", "화", "수", "목", "금", "토"],
            //     monthNames: ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"]
             }
        }, function (start, end, label) {
            $('#timeButtonContainer').show();
        });
    });
    function selectTime(time) {
        document.getElementById('selectedTime').value = time;
    }
    function reserBtn() {
        var date = $('#date').val();
        var time = $('#selectedTime').val();
        alert(date + " " + time + " 예약되었습니다.");
        return false;
    }
</script>

</body>

</html>