<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>

	<!-- Bootstrap -->	
	<jsp:include page="/WEB-INF/paginas/elementosComunes/bootstrap.jsp"></jsp:include>
	<!-- Bootstrap -->
	
	 <!-- Color body -->
	 <jsp:include page="/WEB-INF/paginas/elementosComunes/colorFondo.jsp"></jsp:include>
	 <!-- Color body -->
	 
<title>Listado de planes</title>
</head>

<body>
	<jsp:include page="WEB-INF/paginas/elementosComunes/plan/cabecero.jsp"></jsp:include>
	
	<jsp:include page="WEB-INF/paginas/elementosComunes/plan/botonesNavegacion.jsp"></jsp:include>

	<jsp:include page="WEB-INF/paginas/plan/listadoPlanes.jsp"></jsp:include>
	
	<jsp:include page="/WEB-INF/paginas/elementosComunes/scripts.jsp"></jsp:include>
	
	
</body>
</html>