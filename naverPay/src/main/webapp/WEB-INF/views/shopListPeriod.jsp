<%--
  Created by IntelliJ IDEA.
  User: ryujeyeong
  Date: 2022/11/07
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>shoppingList</title>
</head>
<body>
<h1><a href="http://localhost:8080/naver/pay" target=""> 5팀 페이 </a></h1>
<h2>${list[0].UNaverId}님</h2>
<form action="<c:url value="/naver/shopping"/>" method="GET">
    <input class="input-field" type="date" name="date1" value="${date1}"/>
    <input class="input-field" type="date" name="date2" value="${date2}"/>
    <select class="input-field" name="method">
        <option hidden>${method}</option>
        <option>전체상태</option>
        <option>결제진행중</option>
        <option>결제대기중</option>
        <option>결제완료</option>
        <option>배송확인</option>
        <option>구매완료</option>
        <option>취소</option>
        <option>반품</option>
        <option>교환</option>
        <option>결제처리중오류</option>
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
        <form action="/naver/pay/${s.pmId}" method="GET">
            <input hidden class="input-field" type="submit" name="pmId" value="${s.pmId}"/>
            <tr>
                <td>
                    <button>${s.PName}</button>
                </td>
                <td>
                    <button>${s.priceSum}</button>
                </td>
                <td>
                    <button>${s.companyName}</button>
                </td>
                <td>
                    <button>${s.companyNamePhone}</button>
                </td>
                <td>
                    <button>${s.paymentMethod}</button>
                </td>
                <td>
                    <button>${s.paymentDate}</button>
                </td>
            </tr>
        </form>
    </c:forEach>
</table>

</body>
</html>