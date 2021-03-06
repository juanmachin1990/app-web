<%@page import="jdk.internal.misc.FileSystemOption"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="org.utec.alumnos.Alumno" import="org.utec.alumnos.BuscarAlumnos" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sistema gesti?n de alumnos UTEC</title>
<link rel="stylesheet" type="text/css" href="./index1.css">
</head>

<%
String name = request.getParameter("nombre");
String lastname = request.getParameter("apellido");
Integer ci = request.getParameter("cedula")=="" ? 0: Integer.parseInt(request.getParameter("cedula"));
BuscarAlumnos buscarAlumnos = new BuscarAlumnos();
Alumno alumno = buscarAlumnos.buscarAlumno(name, lastname, ci);
%>

<body>
	<div>
	
		<table>
			<tr>
				<td><img src="utec.jpg" class="logo" /></td>
				<td><h1 class="titulo">Sistema de gesti?n de alumnos</h1></td>
			</tr>
		</table>
		<hr width=100% />
		<h3 class="subtitulo">Selecci?n de Alumnos</h3>
		<form class="formulario" method="get" action="/TareaGrupal-Semana1/mostrarAlumno.jsp">
			<table style="width: 100%">
				<tr>
					<td>Nombre</td>
					<td ><input name="nombre" id="nombre"  value=<%=alumno.getNombre()%> type="text"
						class="input"></td>
				</tr>
				<tr>
					<td>Apellido</td>
					<td><input name="apellido" id="apellido" value=<%=alumno.getApellido()%> type="text"
						class="input"></td>
				</tr>
				<tr>
					<td>C?dula de identidad</td>
					<td><input name="cedula" id="cedula" value=<%=alumno.getCi()%> type="number"
						class="input"> </td>
				</tr>
				<tr>
					<td>C?digo Carrera</td>
					<td><input name="codigo" id="codigo" value=<%=alumno.getCodigoCarrera()%> type="text"
						class="input"> </td>
				</tr>
				<tr>
					<td>Direcci?n</td>
					<td><input name="direccion" id="direccion" value=<%=alumno.getDireccion()%> type="text"
						class="input"> </td>
				</tr>
				<tr>
					<td>A?o Nacimiento</td>
					<td><input name="aniooNacimiento" id="anioNacimiento" value=<%=alumno.getAnioNacimiento()%> type="number"
						class="input"> </td>
				</tr>
				<tr>
					<td>Archivo Foto de Alumno </td>
					<td><input name="archivoFoto" id="archivoFoto" value=<%=alumno.getArchivoFoto()%> type="text"
						class="input"> </td>
				</tr>
				<tr>
					<td></td>
					
				</tr>
			</table>
			
		</form>
		

		<label class="comentario2"> Nota: Es de destacar que se
			seleccionar? el primer alumno que satisfaga el criterio de selecci?n
		</label>

		<footer class="footer">
			<hr width=100% />
			<label> Unidad curricular de programaci?n de aplicaciones web
				- UTEC - 2022 </label>
		</footer>
	</div>



</body>

</html>
