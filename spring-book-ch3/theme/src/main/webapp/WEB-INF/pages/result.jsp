<%@ page contentType="text/html; charset=ISO-8859-1" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
    <title>Spring MVC Themes</title>
</head>
<body>
<h2>User Registration Result</h2>
<table>
    <tr>
        <td>User Name</td>
        <td>${u.username}</td>
    </tr>
    <tr>
        <td>E-Mail</td>
        <td>${u.email}</td>
    </tr>
    <tr>
        <td>Credit Card Number</td>
        <td>${u.ccNumber}</td>
    </tr>
    <tr>
        <td>Password</td>
        <td>${u.password}</td>
    </tr>
</table>
</body>
</html>