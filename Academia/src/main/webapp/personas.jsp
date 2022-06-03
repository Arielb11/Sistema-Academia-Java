<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>

	 <!-- Bootstrap CSS -->
     <jsp:include page="/WEB-INF/paginas/elementosComunes/bootstrap.jsp"></jsp:include>
	 <!-- Bootstrap CSS -->
	 
	 <!-- Color body -->
	 <jsp:include page="/WEB-INF/paginas/elementosComunes/colorFondo.jsp"></jsp:include>


<title>Listado de personas</title>
</head>
<body>

	<!-- Cabecero -->
	<jsp:include page="WEB-INF/paginas/elementosComunes/persona/cabecero.jsp"></jsp:include>
	<!-- Cabecero -->
	
	<!-- Botones de navegacion -->
	<jsp:include page="WEB-INF/paginas/elementosComunes/persona/botonesNavegacion.jsp"></jsp:include>
	<!-- Botones de navegacion -->
	
	<!-- Listado de personas -->
	<jsp:include page="WEB-INF/paginas/persona/listadoPersonas.jsp"></jsp:include>
	<!-- Listado de personas -->
	
	<!-- Scripts -->
	<jsp:include page="/WEB-INF/paginas/elementosComunes/scripts.jsp"></jsp:include>
	<!-- Scripts --> 
	
</body>
</html>