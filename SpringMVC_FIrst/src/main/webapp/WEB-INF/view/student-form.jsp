<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Student Registration Form</title>
</head>
<body>



<form:form action="processForm" modelAttribute="student">

    First name: <form:input path="firstName" />
    <br>    <br>
    Last name: <form:input path="lastName" />
    <br>    <br>

    Country:
    <form:select path="country">
        <form:options items="${student.countryOptions}"/>
    </form:select>
    <br>    <br>

    Favourite Language: <br>
    <form:radiobuttons path="favouriteLanguage" items="${student.languageOptions}" />
    <br>    <br>

    Operating Systems:
    <form:checkboxes path="operatingSystems" items="${student.osOptions}"/>

    <br>    <br>
    <input type="submit" value="Submit" />

</form:form>


</body>
</html>
