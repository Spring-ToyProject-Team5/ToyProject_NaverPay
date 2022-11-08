<%--
  Created by IntelliJ IDEA.
  User: ryujeyeong
  Date: 2022/11/07
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%
    Date nowTime = new Date();
    Date timeMinus2Years = new Date();
    timeMinus2Years.setYear(timeMinus2Years.getYear()-2);
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>shoppingList</title>
</head>
<body>
<h1><a href = "http://localhost:8080/naver/pay" target = ""> 5팀 페이 </a></h1>
<form action="<c:url value="/naver/shopping"/>" method="GET">
    <input class="input-field" type="date" name="date1" value="<%=sf.format(timeMinus2Years)%>" />
    <input class="input-field" type="date" name="date2" value="<%=sf.format(nowTime)%>"/>
    <select class="input-field" name="method">
        <option selected>전체상태</option>
        <option>결제진행중</option>
        <option>결제대기중</option>
        <option>결제완료</option>
        <option>배송확인</option>
        <option>구매완료</option>
        <option>취소</option>
        <option>반품</option>
        <option>교환</option>
        <option>결제처리중오류</option>
        <option>p</option>
        <option>a</option>
        <option>b</option>
    </select>
    <button>조회&#x1F50D</button>

</form>
<table border="1">
    <tr>
        <th>상품 이름</th>
        <th>상품 가격</th>
        <th>회사 이름</th>
        <th>회사 번호</th>
        <th>결제 방식</th>
        <th>결제 날짜</th>
    </tr>
    <c:forEach items="${list}" var="s">
        <form action="<c:url value="/naver/detail"/>" method="post">
            <tr>
                <td>${s.pName}</td>
                <td>${s.pPrice}</td>
                <td>${s.companyName}</td>
                <td>${s.companyNamePhone}</td>
                <td>${s.paymentMethod}</td>
                <td>${s.paymentDate}</td>
            </tr>
        </form>
    </c:forEach>
</table>
<%--${list}--%>

</body>
</html>