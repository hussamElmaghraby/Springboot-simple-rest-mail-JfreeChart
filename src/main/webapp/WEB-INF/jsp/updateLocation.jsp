<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Edit Page</title>
</head>
<body>
	<form action="updateLoc" method="POST">
		<pre>
		Id : <input type="text" name="id" readonly value="${location.id}"/> 
		Code : <input type="text" name="code" value="${location.code}"/>
		Name : <input type="text" name="name" value="${location.name}"/>
		Type :URBAN <input type="radio" name="type" value="URBAN" ${location.type=='URBAN' ? 'checked':''}  />
			  RURAL <input type="radio" name="type" value="RURAL" ${location.type=='RURAL' ? 'checked':''} />
		<input type="submit" value="Update"> 	
		</pre>
	</form>
</body>
</html>