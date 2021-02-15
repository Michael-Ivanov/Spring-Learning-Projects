<%--
  Created by IntelliJ IDEA.
  User: Michael
  Date: 15.02.2021
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Landing Page</title>
</head>
<body>
<h2>Landing Page</h2>
<hr>
<p>
    Welcome to the landing page! This page is open to the public, no login required.
</p>
<p>
    <a href="${pageContext.request.contextPath}/employees">Access Secure Site (requires login)</a>
</p>

</body>
</html>
