<%@ page contentType="text/html;charset=ISO-8859-9" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
    <title>Spring MVC Themes</title>
    <link rel="stylesheet" href="<spring:theme code="style"/>" type="text/css" />
</head>
<body>
Theme :
<a href="?theme=light">Light</a> - <a href="?theme=dark">Dark</a>
<br/>
<mvc:form modelAttribute="user" action="result.mvc">
    <table>
        <tr>
            <td><mvc:label path="username">User Name</mvc:label></td>
            <td><mvc:input path="username" /></td>
            <td><mvc:errors path="username" /></td>
        </tr>
        <tr>
            <td><mvc:label path="email">E-Mail</mvc:label></td>
            <td><mvc:input path="email" /></td>
            <td><mvc:errors path="email" /></td>
        </tr>
        <tr>
            <td><mvc:label path="ccNumber">Credit Card Number</mvc:label></td>
            <td><mvc:input path="ccNumber" /></td>
            <td><mvc:errors path="ccNumber" /></td>
        </tr>
        <tr>
            <td><mvc:label path="password">Password</mvc:label></td>
            <td><mvc:password path="password" /></td>
            <td><mvc:errors path="password" /></td>
        </tr>
        <tr>
            <td colspan="3">
                <input type="submit" value="Submit" />
            </td>
        </tr>
    </table>
</mvc:form>
</body>
</html>