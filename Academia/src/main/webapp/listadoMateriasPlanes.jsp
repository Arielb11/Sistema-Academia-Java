<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    
	<!-- Bootstrap CSS -->
     <jsp:include page="/WEB-INF/paginas/elementosComunes/bootstrap.jsp"></jsp:include>
	 <!-- Bootstrap CSS -->
	 
	 <!-- Color body -->
	 <jsp:include page="/WEB-INF/paginas/elementosComunes/colorFondo.jsp"></jsp:include>
	 
	 
<title>Listado de materias del plan ${planBuscado.getDescripcion()}</title>
</head>

<body>


	<!-- Cabecero -->
	<jsp:include page="WEB-INF/paginas/listarMateriasPlan/cabecero.jsp"></jsp:include>
	<!-- Cabecero -->
	
	<br />
	<br />

	<!-- Listado de materias de un plan -->
	<jsp:include page="/WEB-INF/paginas/listarMateriasPlan/listadoMateriasPlan.jsp"></jsp:include>
	<!-- Listado de materias de un plan -->

	<jsp:include page="/WEB-INF/paginas/listarMateriasPlan/listaPlanes.jsp"></jsp:include>

	<!-- Scripts -->
	<jsp:include page="/WEB-INF/paginas/elementosComunes/scripts.jsp"></jsp:include>
	<!-- Scripts --> 
	 
</body>
</html>