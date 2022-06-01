<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="ejercicio.Persona"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienvenido</title>

<style>
table {border-colapse =collapse;
	
}
</style>
<link rel="stylesheet" type="text/css" href="./index.css">
</head>
<body class='body'>
	<h2>
		Bienvenido:
		<%=request.getParameter("name")%></h2>




	${pageScope.request.contextPath}
	<table border=1 style="border-collapse: collapse;">
		<tr>
			<td class='columnaIdentificador'>Id de persona</td>
			<td>${requestScope.identificador}</td>
		</tr>
		<tr>
			<td class='columnaIdentificador'>Nombre</td>
			<td>${requestScope.persona.name}</td>
		</tr>
		<tr>
			<td class='columnaIdentificador'>Edad</td>
			<td>${requestScope.persona.age}</td>
		</tr>
		<tr>
			<td class='columnaIdentificador'>Dirección</td>
			<td>${requestScope.persona.address}</td>
		</tr>
		<tr>
			<td class='columnaIdentificador'>Teléfono</td>
			<td>${requestScope.persona.phone}</td>
		</tr>

	</table>
	
	<button class="botonVolver" onclick="history.back()">Volver</button>

</body>
</html>