<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer confirmation</title>
</head>
<body>

<h2>The customer is confirmed: ${customer.firstName} ${customer.lastName}</h2>
<h2>Free passes: ${customer.freePasses}</h2>
<h2>Postal code: ${customer.postalCode}</h2>
</body>
</html>
