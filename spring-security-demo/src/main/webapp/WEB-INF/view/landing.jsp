<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Landing Page</title>
</head>
<body>
<jsp:include page="logged_user.jsp"/>
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
