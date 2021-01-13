<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Confirmation</title>
</head>
<body>

<h2>Student confirmed from Model: ${student.firstName} ${student.lastName}</h2>
<br>
<h2>Student confirmed from Request: ${param.firstName} ${param.lastName}</h2>
<br>
<h2> Country: ${student.country}</h2>
<br>
<h2> Favourite Language: ${student.favouriteLanguage}</h2>

</body>
</html>
