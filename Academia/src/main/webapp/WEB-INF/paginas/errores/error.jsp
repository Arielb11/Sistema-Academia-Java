<%@ page language="java"%>
<!DOCTYPE html>
<html>
<head>

	
 	 <!-- Bootstrap CSS -->
     <jsp:include page="/WEB-INF/paginas/elementosComunes/bootstrap.jsp"></jsp:include>
	 <!-- Bootstrap CSS -->
	 
	 <!-- Color body -->
	 <jsp:include page="/WEB-INF/paginas/elementosComunes/colorFondo.jsp"></jsp:include>
	 
<title>Error</title>
</head>
<body>

	<!-- Cabecero -->
	<jsp:include page="/WEB-INF/paginas/errores/cabecero.jsp"></jsp:include>
	<!-- Cabecero -->
	
	
	
	<br />
	<br />
	<br />
	<br />
	
	<table align="center">
	<tr>
		<td align="center">
			<div class="alert alert-danger d-flex align-items-center" role="alert">
  				<svg xmlns="http://www.w3.org/2000/svg" width="100" height="40" fill="currentColor" class="bi bi-exclamation-triangle-fill flex-shrink-0 me-2" viewBox="0 0 16 16" role="img" aria-label="Danger:">
    				<path d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
  				</svg>
  				<div>
    				<strong>${mensaje}</strong>
  				</div>
			</div>	
		</td>
		</tr>
		
		<tr><td align="center"></td></tr>
		<tr><td align="center"></td></tr>
		<tr><td align="center"></td></tr>
		<tr><td align="center"></td></tr>
		<tr><td align="center"></td></tr>
		
		<tr>
		<td align="center">
			<a href="${enlaceAnterior}" class="btn btn-primary btn-lg">Volver a la página</a>
		</td>
		</tr>
		
	</table>
</body>
</html>