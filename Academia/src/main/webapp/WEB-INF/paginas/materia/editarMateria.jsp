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
	 
<title>Editar materia</title>
</head>

<body>

	<!-- Cabecero -->
	<jsp:include page="/WEB-INF/paginas/elementosComunes/materia/cabecero.jsp"></jsp:include>
	<!-- Cabecero -->
	
	
	
	<form action="${pageContext.request.contextPath}/ControladorMateria?accion=modificar&idMateria=${materia.getIdMateria()}" 
	method="post" class="was-validated">
	
	<jsp:include page="/WEB-INF/paginas/elementosComunes/materia/botonesNavegacionEdicion.jsp"></jsp:include>
	
	
	<section id="details">
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="card">
						<div class="card-header bg-success text-white">
							<h4>Editar materia</h4>
						</div>
						
						<div class="card-body">

							<div class="form-group">
								<label for="descripcion">Descripción</label>
								<input type="text" class="form-control" name="descripcion" required value="${materia.getDescripcion()}">
							</div>
							<div class="form-group">
								<label for="hsSemanales">Horas semanales</label>
								<input type="number" class="form-control" name="hsSemanales" required value="${materia.getHsSemanales()}">
							</div>
							<div class="form-group">	
								<label for="hsTotales">Horas totales</label>
								<input type="number" class="form-control" name="hsTotales" required value="${materia.getHsTotales()}">
							</div>
							<div class="form-group">
								<label for="cupo">Cupo</label>
								<input type="number" class="form-control" name="cupo" required value="${materia.getCupo()}">
							</div>
							<div class="input-group mb-3">
								<label class="input-group-text" for="idPlan">Plan</label>
									<select class="form-select" aria-label="Default select example" name="nombrePlan">
									<option selected>${materia.getDescPlan()}</option>
                          				<c:forEach var="pla" items="${planes}">
                            				<c:choose>
                            					<c:when test="${pla.getDescripcion() != materia.getDescPlan()}">
                            						<option value="${pla.getDescripcion()}">${pla.getDescripcion()} ${pla.getEspecialidad()}</option>
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
	