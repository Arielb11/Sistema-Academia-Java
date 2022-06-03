<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
 	 
 	 <!-- Bootstrap CSS -->
     <jsp:include page="/WEB-INF/paginas/elementosComunes/bootstrap.jsp"></jsp:include>
	 <!-- Bootstrap CSS -->
	 
	 <!-- Color body -->
	 <jsp:include page="/WEB-INF/paginas/elementosComunes/colorFondo.jsp"></jsp:include>
	 
<title>Editar docente</title>

</head>

<body>




	<!-- Cabecero -->
	<jsp:include page="/WEB-INF/paginas/elementosComunes/docente/cabecero.jsp"></jsp:include>
	<!-- Cabecero -->
	
	<form action="${pageContext.request.contextPath}/ControladorDocente?accion=modificar&idDocente=${docente.getIdDocente()}" 
	method="post" class="was-validated">


	<jsp:include page="/WEB-INF/paginas/elementosComunes/docente/botonesNavegacionEdicion.jsp"></jsp:include>
	
	
	<section id="details">
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="card">
						<div class="card-header bg-success text-white">
							<h4>Editar docente: ${pr.getNombre()} ${pr.getApellido()}</h4>
						</div>
						
						<div class="card-body">
							<div class="form-group">
								<label for="descripcion">Cargo</label>
								<input type="text" class="form-control" name="cargo" required value="${docente.getCargo()}">
							</div>
							
							<div class="input-group mb-3">	
								<label class="input-group-text" for="hsTotales">Materia</label>
									<select class="form-select" aria-label="Default select example" name="descripcionMateria">
										<option selected>${materia.getDescripcion()}</option>
		                          			<c:forEach var="mate" items="${materiasAcademia}">
		                          				<c:choose>
		                          					<c:when test="${mate.getDescripcion() != materia.getDescripcion()}">
		                          						<option value="${mate.getDescripcion()}">${mate.getDescripcion()}</option>
		                          					</c:when>
		                          				</c:choose>
		                            		</c:forEach>
									</select>
							</div>
						</div>
						
					</div>
				</div>
			</div>
		</div>
	</section>
	
	
	</form>
	
	
	<!-- Scripts -->
	<jsp:include page="/WEB-INF/paginas/elementosComunes/scripts.jsp"></jsp:include>
	<!-- Scripts --> 
	 
</body>
</html>