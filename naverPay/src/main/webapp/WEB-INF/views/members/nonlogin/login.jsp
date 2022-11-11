<%@ page import="org.example.utils.Status" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>NaverPay</title>
</head>
<body>

<%@include file="../../messages/showMessage.jsp" %>
<%
    showMessage(request, response, "login", Status.FAIL);
%>

<h1>LOGIN</h1>
<div>
    <form method="post" action="/login">
        <div>
            <label for="uNaverId">ID: </label>
            <input type="text" id="uNaverId" name="uNaverId" placeholder="INPUT YOUR ID" required/>
        </div>

        <div>
            <label for="uPw">PASSWORD: </label>
            <input type="password" id="uPw" name="uPw" placeholder="INPUT YOUR PASSWORD" required/>
        </div>

        <div>
            <label for="save">AUTO LOGIN: </label>
            <input id="save" type="checkbox" name="save"/>
        </div>
        <input type="submit" name="submit" value="Submit">
    </form>
</div>

</body>
</html>
