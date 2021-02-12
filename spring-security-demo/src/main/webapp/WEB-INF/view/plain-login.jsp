<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login Form</title>
    <style>
        .failed {
            color: red;
            font-size: larger;
        }
    </style>
</head>
<body>
<h3>Custom Login Page</h3>

<form:form action="${pageContext.request.contextPath}/authenticateUser"
           method="post">
    <c:if test="${param.error != null}">
        <i class="failed">Sorry, you entered incorrect username/password</i>
    </c:if>
    <p>User name: <input type="text" name="username"></p>
    <p>Password: <input type="text" name="password"></p>
    <input type="submit" value="Login">
</form:form>
</body>
</html>
