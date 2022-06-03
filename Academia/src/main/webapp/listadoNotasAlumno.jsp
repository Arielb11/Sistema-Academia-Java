<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    
 	 <!-- Bootstrap CSS -->
     <jsp:include page="/WEB-INF/paginas/elementosComunes/bootstrap.jsp"></jsp:include>
	 <!-- Bootstrap CSS -->
	 
	 <!-- Color body -->
	 <jsp:include page="/WEB-INF/paginas/elementosComunes/colorFondo.jsp"></jsp:include>
	 
	 
<title>Listado de materias del plan</title>
</head>

<body>


	<!-- Cabecero -->
	<jsp:include page="WEB-INF/paginas/listarNotasAlumno/cabecero.jsp"></jsp:include>
	<!-- Cabecero -->
	
	<br />
	<br />

	<!-- Listado de notas de un alumno -->
	<jsp:include page="/WEB-INF/paginas/listarNotasAlumno/listadoNotasAlumno.jsp"></jsp:include>
	<!-- Listado de notas de un alumno -->


	<!-- Scripts -->
	<jsp:include page="/WEB-INF/paginas/elementosComunes/scripts.jsp"></jsp:include>
	<!-- Scripts --> 
	 
</body>
</html>