<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc"%>
<html>
<head>
<title>Spring MVC File Upload</title>
</head>
<body>
	<h2>File Upload With Servlet 3.0</h2>
	<mvc:form modelAttribute="user" action="upload.mvc"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td>Name</td>
				<td><mvc:input path="name" /></td>
			</tr>
			<tr>
				<td>Choose File</td>
				<td><mvc:input type="file" path="file" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</mvc:form>
	<h3>Uploaded Information</h3>
	<table>
		<tr>
			<td>Name</td>
			<td>${userName}</td>
		</tr>
		<tr>
			<td>Choose File</td>
			<td>${fileLength}</td>
		</tr>
	</table>
</body>
</html>