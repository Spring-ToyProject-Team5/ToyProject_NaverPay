<%--
  Created by IntelliJ IDEA.
  User: jisun
  Date: 2022-11-08
  Time: 오후 2:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
상세페이지 접근완료


<h2>구매 정보</h2>
<p> 구매한 상품명: ${detail.PName}</p>
<p> 상품 가격: ${detail.priceSum}</p>
<p> 구매한 횟수: ${detail.productNum}</p>
<p> 회사명: ${detail.companyName}</p>
<p> 회사번호: ${detail.companyNamePhone}</p>


<h2>결제정보</h2>
<p> 카드회사: ${detail.cardName}</p>
<p> 카드번호: ${detail.cardNum}</p>
<p> 결제방법: ${detail.paymentMethod}</p>
<p> 결제날짜: ${detail.paymentDate}</p>


<h2>포인트 정보</h2>
<p> 적립된 포인트: ${detail.savedPoint}</p>
<p> 사용한 포인트: ${detail.usePoint}</p>

<form action="/naver/pay/delete/${detail.pmId}" method="get">
    <input hidden class="input-field" type="submit" name="pmId" value="${detail.pmId}"/>
    <button>삭제</button>
</form>

</body>
</html>
