<%@ page contentType="text/html; charset=ISO-8859-1" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<html>
<head>
    <title>Spring MVC Exception Handling</title>
</head>
<body>

<h2>Search User</h2>
<mvc:form modelAttribute="user" action="result.mvc">
    <table>
        <tr>
            <td><mvc:label path="name">Name</mvc:label></td>
            <td><mvc:input path="name" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Search" />
            </td>
        </tr>
    </table>
</mvc:form>
</body>
</html>