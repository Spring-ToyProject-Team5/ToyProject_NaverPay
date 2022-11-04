<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 10/28/22
  Time: 3:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SPRING</title>
</head>
<body>
<h1>하이</h1>
${now}
<%
    request.getAttribute("now");
%>
</body>
</html>
