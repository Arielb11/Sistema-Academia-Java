<%@ page contentType="text/html; charset=UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="modal fade" id="agregarDocenteModal">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header bg-success text-white">
				<h5 class="modal-title">Agregar cargo</h5>
				
				<button class="close" data-dismiss="modal">
					<span>&times;</span>
				</button>
				
			</div>
			
			<form action="${pageContext.request.contextPath}/ControladorDocente?accion=insertar" 
			method="post" class="was-validated">
				
				<div class="modal-body">
					<div class="input-group mb-3">	
						<label class="input-group-text" for="descripcionMateria">Materia</label><br/>
                          <select class="form-select" aria-label="Default select example" name="descripcionMateria">
                          	<c:forEach var="mat" items="${materiasAcademia}">
                            	<option value="${mat.getDescripcion()}">${mat.getDescripcion()}</option>
                            </c:forEach>
                          </select>
					</div>
					<div class="input-group mb-3">	
						<label class="input-group-text" for="descripcionMateria">Docente</label><br/>
							<select class="form-select" aria-label="Default select example" name="legajo">
	                          	<c:forEach var="doc" items="${docentesActuales}">
	                            	<option value="${doc.getLegajo()}">${doc.getNombre()} ${doc.getApellido()}</option>
	                            </c:forEach>
                          	</select>
					</div>
					<div class="form-group">
						<label for="cargo">Cargo</label>
						<input type="text" class="form-control" name="cargo" required>
					</div>
									
					<div class="row">
						<div class="col-md-3">
							<button class="btn btn-primary btn-block" type="submit">Guardar</button> 
						</div>
					</div>
				</div>
			</form>

		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/paginas/docente/listaDocentes.jsp"></jsp:include>
<jsp:include page="/WEB-INF/paginas/docente/listaMaterias.jsp"></jsp:include>
