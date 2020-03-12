<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Create Location</title>
</head>
<body>
	<form action="saveloc" method="post">
	<pre>
		Id : <input type="text" name="id"/> 
		Code : <input type="text" name="code"/>
		Name : <input type="text"  name="name"/>
		Type :URBAN <input type="radio" name="type" value="URBAN"/>
			  RURAL <input type="radio" name="type" value="RURAL"/>
		<input type="submit" value="save"> 	
		</pre>
	</form>
	<p style="center">${msg}</p>
	<p style="center">Email Sent To ${name}</p>
	<a href="displayLocations">View All</a>
</body>
</html>