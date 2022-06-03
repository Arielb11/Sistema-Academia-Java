<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>


	 <!-- Bootstrap CSS -->
     <jsp:include page="/WEB-INF/paginas/elementosComunes/bootstrap.jsp"></jsp:include>
	 <!-- Bootstrap CSS -->
	 
	 <!-- Color body -->
	 <jsp:include page="/WEB-INF/paginas/elementosComunes/colorFondo.jsp"></jsp:include>


<title>Docentes de Academia</title>
</head>
<body>
	
	<!-- Cabecero -->
	<jsp:include page="WEB-INF/paginas/elementosComunes/docente/cabecero.jsp"></jsp:include>
	<!-- Cabecero -->
	
	<!-- Botones de navegación -->
	<jsp:include page="WEB-INF/paginas/elementosComunes/docente/botonesNavegacion.jsp"></jsp:include>
	<!-- Botones de navegacion -->
	
	
	<!-- Listado de docentes -->
	<jsp:include page="WEB-INF/paginas/docente/listadoDocentes.jsp"></jsp:include>
	<!-- Listado de docentes -->
	
	<!-- Scripts -->
	<jsp:include page="WEB-INF/paginas/elementosComunes/scripts.jsp"></jsp:include>
	<!-- Scripts -->
	
</body>
</html>