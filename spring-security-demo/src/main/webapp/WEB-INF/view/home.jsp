<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Home Page</title>
</head>
<body>
<jsp:include page="logged_user.jsp"/>

<h2>Company Home Page</h2>
<hr>
<p>
    Welcome to the company home page!
</p>
<hr>
<p>
    User: <security:authentication property="principal.username"/>
    <br>
    Role(s): <security:authentication property="principal.authorities"/>
</p>
<hr>
<%-- Add a link to point to /leaders --%>
<security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
    <p>
        <a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
        (only for manager peeps)
    </p>
</security:authorize>
<%-- Add a link to point to /systems --%>
<security:authorize access="hasRole('ADMIN')">
    <p>
        <a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
        (only for admin peeps)
    </p>
</security:authorize>

<%--Add a logout button--%>
<form:form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value="Logout">
</form:form>

</body>
</html>
