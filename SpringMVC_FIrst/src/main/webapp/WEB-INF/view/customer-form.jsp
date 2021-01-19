<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Customer Form</title>

    <style>
        .error {color: #ff0000
        }
    </style>
</head>

<i>Fill out the form. Asterisk (*) means required.</i>
<body>
    <form:form action="processForm" modelAttribute="customer">

        First name: <form:input path="firstName" />
        <br><br>
        Last name (*): <form:input path="lastName" />
        <form:errors path="lastName" cssClass="error" />
        <br><br>
        <input type="submit" value="Submit"/>

    </form:form>
</body>
</html>
