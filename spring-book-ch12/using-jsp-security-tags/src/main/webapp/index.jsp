<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<body>
<h2>Hello World!</h2>
Current User:<sec:authentication property="principal.username"/>
<br>
<sec:authorize access="hasRole('ROLE_EDITOR')">
<a href="editor.jsp">Editors only</a>
</sec:authorize>
</body>
</html>
