<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.Optional"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ingresar personas</title>
<link rel="stylesheet" type="text/css" href="./index.css">
</head>
<body class='body'>
	<h2>Ingreso de persona</h2>
	<label style="color: red;"> 
	
	<!-- <%=request.getAttribute("errorMessage")%> <br> 	   -->
	<!-- Se usan diferentes formas de mostrar el parametro errorMessage que vino en el request 
	<c:out value="${errorMessage}"/> (2)<br>
	${requestScope.errorMessage} (3)<br>
	
	-->

	</label>

	<form action="Validar" method="post">
		<table>
			<tr>
				<td>Nombre:</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Edad:</td>
				<td><input type="text" name="age"></td>
			</tr>
			<tr>
			<tr>
				<td>Dirección:</td>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
			<tr>
				<td>Tel:</td>
				<td><input type="text" name="phone"></td>
			</tr>
			<tr>
				<td><input type="submit" name="enviar" value="Enviar"></td>
			</tr>


		</table>
	</form>
</body>
</html>