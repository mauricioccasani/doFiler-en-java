<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="LoginServlet" method="post">
		${error }
	Usuario<input type="text" name="txtNombre" >
	Passwor<input type="password" name="txtPassword">
	<input type="submit" value="Ingresar">
</form>
</body>
</html>