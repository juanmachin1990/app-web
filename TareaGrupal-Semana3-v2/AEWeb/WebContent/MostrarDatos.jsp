<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Usuarios</title>
</head>
<body>
<form action="com/ws/restapi/MostrarDatos" method="get">
		<%=request.getParameter("jsonObj")%>
	</form>
</body>
</html>