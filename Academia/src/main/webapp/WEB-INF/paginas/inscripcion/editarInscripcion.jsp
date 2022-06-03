<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	
	<jsp:include page="/WEB-INF/paginas/elementosComunes/bootstrap.jsp"></jsp:include>
	
	<!-- Color body -->
	<jsp:include page="/WEB-INF/paginas/elementosComunes/colorFondo.jsp"></jsp:include>
		
<title>Editar inscripción </title>
</head>

<body>

	<jsp:include page="/WEB-INF/paginas/elementosComunes/inscripcion/cabecero.jsp"></jsp:include>
	
	<form action="${pageContext.request.contextPath}/ControladorInscripcion?accion=modificar&idMateria=${inscripcion.getIdMateria()}&idPersona=${inscripcion.getIdPersona()}" 
	method="post" class="was-validated">
	
	<jsp:include page="/WEB-INF/paginas/elementosComunes/inscripcion/botonesNavegacionEdicion.jsp"></jsp:include>
	
	<section id="details">
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="card">
						<div class="card-header bg-success text-white">
							<h4>Editar alumno: ${aluData.getNombre()} ${aluData.getApellido()}</h4>
						</div>
						
						<div class="card-body">
							<div class="input-group mb-3">
								<label class="input-group-text" for="descripcionMateria">Materia</label>
									<select class="form-select" aria-label="Default select example" name="descripcionMateria">
										<option selected>${materia.getDescripcion()}</option>
										<c:forEach var="mat" items="${materiasAcademia}">
			                          		<c:choose>
			                          			<c:when test="${mat.getCupo() > 0 && mat.getDescripcion() != materia.getDescripcion()}">
			                          				<option value="${mat.getDescripcion()}">${mat.getDescripcion()}</option>
			                          			</c:when>
			                          		</c:choose>
		                            </c:forEach>
									</select>
								
							</div>
							<div class="input-group mb-3">	
								<label class="input-group-text" for="condicion">Condición</label>
									<select class="form-select" name="condicion">
										<option selected>${inscripcion.getCondicion()}</option>
										
										<c:choose>
											<c:when test="${inscripcion.getCondicion().equals('Aprobado') || inscripcion.getCondicion().equals('Regular')}">
												<c:choose>
													<c:when test="${inscripcion.getCondicion().equals('Aprobado')}">
														<option value="Cursando">Cursando</option>
				    									<option value="Regular">Regular</option>
													</c:when>
													<c:when test="${inscripcion.getCondicion().equals('Regular')}">
														<option value="Aprobado">Aprobado</option>
														<option value="Cursando">Cursando</option>
													</c:when>
												</c:choose>
											</c:when>
											
											<c:when test="${inscripcion.getCondicion().equals('Cursando')}">
												<c:choose>
													<c:when test="${inscripcion.getCondicion().equals('Cursando')}">
														<option value="Aprobado">Aprobado</option>
														<option value="Regular">Regular</option>
													</c:when>
												</c:choose>
											</c:when>
											
										</c:choose>	
	  								</select>
							</div>
							<div class="form-group">	
								<label for="nota">Nota</label>
								<input type="number" class="form-control" name="nota" required value="${inscripcion.getNota()}">
							</div>
						</div>
						
					</div>
				</div>
			</div>
		</div>
	</section>
	</form>	
	
	<jsp:include page="/WEB-INF/paginas/elementosComunes/scripts.jsp"></jsp:include>
	
</body>
</html>
