<%@ page contentType="text/html; charset=ISO-8859-1" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<html>
<head>
    <title>Spring MVC Form Validation</title>
    <style type="text/css">
        .formFieldError { background-color: #FFC; }
    </style>
</head>
<body>

<h2>User Registration Form</h2>
<mvc:form modelAttribute="user" action="result.mvc">
	<table>
	    <tr>
	        <td><mvc:label path="username">User Name</mvc:label></td>
	        <td><mvc:input path="username" cssErrorClass="formFieldError" /></td>
	        <td><mvc:errors path="username" /></td>
	    </tr>
        <tr>
            <td><mvc:label path="email">E-Mail</mvc:label></td>
            <td><mvc:input path="email" cssErrorClass="formFieldError" /></td>
            <td><mvc:errors path="email" /></td>
        </tr>
        <tr>
            <td><mvc:label path="ccNumber">Credit Card Number</mvc:label></td>
            <td><mvc:input path="ccNumber" cssErrorClass="formFieldError" /></td>
            <td><mvc:errors path="ccNumber" /></td>
        </tr>
	    <tr>
	        <td><mvc:label path="password">Password</mvc:label></td>
	        <td><mvc:password path="password" cssErrorClass="formFieldError" /></td>
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