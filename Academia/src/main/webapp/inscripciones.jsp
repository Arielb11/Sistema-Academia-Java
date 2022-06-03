<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>

     	<jsp:include page="/WEB-INF/paginas/elementosComunes/bootstrap.jsp"></jsp:include>
     	
	 	<!-- Color body -->
	 	<jsp:include page="/WEB-INF/paginas/elementosComunes/colorFondo.jsp"></jsp:include>
     	
<title>Inscripcion de materias Academia</title>
</head>
<body>

	<jsp:include page="WEB-INF/paginas/elementosComunes/inscripcion/cabecero.jsp"></jsp:include>
	
	<jsp:include page="WEB-INF/paginas/elementosComunes/inscripcion/botonesNavegacion.jsp"></jsp:include>
	
	<jsp:include page="WEB-INF/paginas/inscripcion/listadoInscripcion.jsp"></jsp:include>

	<jsp:include page="/WEB-INF/paginas/elementosComunes/scripts.jsp"></jsp:include>
	
</body>
</html>