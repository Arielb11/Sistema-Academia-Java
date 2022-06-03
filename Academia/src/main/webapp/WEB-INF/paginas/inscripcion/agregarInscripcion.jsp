<%@ page contentType="text/html; charset=UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal fade" id="agregarInscripcionModal">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header bg-success text-white">
				<h5 class="modal-title">Agregar Inscripción</h5>
				<button class="close" data-dismiss="modal">
					<span>&times;</span>
				</button>
			</div>
			
			
			<form action="${pageContext.request.contextPath}/ControladorInscripcion?accion=insertar" 
			method="post" class="was-validated">
				
				<div class="modal-body">
						<div class="input-group mb-3">
							<label class="input-group-text" for="legajo">Alumno</label>
								<select class="form-select" aria-label="Default select example" name="legajo">
		                          	<c:forEach var="alu" items="${alusAcademia}">
		                            	<option value="${alu.getLegajo()}">${alu.getNombre()} ${alu.getApellido()}</option>
		                            </c:forEach>
							</select>
						</div>
						<br />
						<div class="input-group mb-3">
							<label class="input-group-text" for="descripcionMateria">Materia</label>
								<select class="form-select" aria-label="Default select example" name="descripcionMateria">
		                          	<c:forEach var="mat" items="${materiasAcademia}">
		                          		<c:choose>
		                          			<c:when test="${mat.getCupo() > 0}">
		                          				<option value="${mat.getDescripcion()}">${mat.getDescripcion()}</option>
		                          			</c:when>
		                          		</c:choose>
		                            </c:forEach>
	                          </select>
						</div>
						<br />
						<div class="input-group mb-3">	
							<label class="input-group-text" for="condicion">Condición</label>
								<select class="form-select" name="condicion">
		    						<option value="Aprobado">Aprobado</option>
		    						<option value="Cursando">Cursando</option>
		    						<option value="Regular">Regular</option>
  								</select>
						</div>
						<br />
						<div class="form-group">
							<label for="nota">Nota</label>
							<input type="number" class="form-control" name="nota" required>
						</div>
						<div class="row">
						<div class="modal-footer">
							<button class="btn btn-primary" type="submit">Guardar</button> 
						</div>	
						</div> 
					
					
				</div>
			</form>
			
			
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/paginas/docente/listaMaterias.jsp"></jsp:include>
<jsp:include page="/WEB-INF/paginas/inscripcion/listaAlumnos.jsp"></jsp:include>