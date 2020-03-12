<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Insert title here</title>
</head>
<body>
	<h2>Locations : </h2>
	<table border="2">
		<tr>
			<th>Id</th>
			<th>Code</th>
			<th>Name</th>
			<th>Type</th>
		</tr>
		<c:forEach items="${locations}" var="location">
		<tr>
			<td>${location.id}</td>
			<td>${location.code}</td>
			<td>${location.name}</td>
			<td>${location.type}</td>
			<td><a href="deleteLocations?id=${location.id}">DELETE</a></td>
			<td><a href="showUpdate?id=${location.id}">UPDATE</a></td>
		</tr>
		</c:forEach>
	</table>
	<a href="showCreate">Add Location</a><br>
	<a href="generateReport">See the Type Chart </a>
</body>
</html>