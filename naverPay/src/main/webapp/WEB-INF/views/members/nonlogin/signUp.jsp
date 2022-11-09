<%@ page import="org.example.utils.Status" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SignUp</title>
</head>
<body>

<%@include file="../../messages/showMessage.jsp"%>
<%
    showMessage(request, response, "signup", Status.FAIL);
%>

<h1>SIGN UP</h1>

<form method="post" action="/members/signup">

    <div>
        <label for="uEmail">EMAIL: </label>
        <input type="email" id="uEmail" name="uEmail" placeholder="INPUT YOUR EMAIL" pattern="^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$" required/>
    </div>


    <div>
        <label for="uNaverId">NaverId: </label>
        <input type="text" id="uNaverId" name="uNaverId" placeholder="INPUT YOUR ID" pattern="[a-zA-Z]{1}[a-zA-Z0-9_-]{7,14}" required/>
    </div>


    <div>
        <label for="uPw">PASSWORD: </label>
        <input type="password" id="uPw" name="uPw" placeholder="INPUT YOUR PASSWORD" pattern="(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}" required/>
    </div>

    <div>
        <label for="uAddress">Address: </label>
        <input type="text" id="uAddress" name="uAddress" placeholder="INPUT YOUR ID" pattern="[a-zA-Z]{1}[a-zA-Z0-9_-]{7,14}" required/>
    </div>

    <div>
        <label for="uId">ID: </label>
        <input type="text" id="uId" name="uId" placeholder="INPUT YOUR ID" pattern="[a-zA-Z]{1}[a-zA-Z0-9_-]{7,14}" required/>
    </div>


    <input type="submit" name="submit" value="Submit">
</form>

</body>
</html>
