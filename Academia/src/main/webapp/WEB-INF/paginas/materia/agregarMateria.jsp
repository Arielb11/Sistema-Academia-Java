<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal fade" id="agregarMateriaModal">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header bg-success text-white">
				<h5 class="modal-title">Agregar materia</h5>
				<button class="close" data-dismiss="modal">
					<span>&times;</span>
				</button>
			</div>
			
			
			<form action="${pageContext.request.contextPath}/ControladorMateria?accion=insertar" 
			method="post" class="was-validated">
				
				<div class="modal-body">
					<div class="form-group">
						<label for="descripcion">Descripción</label>
						<input type="text" class="form-control" name="descripcion" required>
					</div>
					<div class="form-group">
						<label for="hsSemanales">Horas semanales</label>
						<input type="number" class="form-control" name="hsSemanales" required>
					</div>
					<div class="form-group">	
						<label for="hsTotales">Horas totales</label>
						<input type="number" class="form-control" name="hsTotales" required>
					</div>
					<div class="form-group">
						<label for="cupo">Cupo</label>
						<input type="number" class="form-control" name="cupo" required>
					</div>
					<div class="input-group mb-3">
						<label class="input-group-text" for="idPlan">Plan</label>
						<select class="form-select"  name="nombrePlan">
                          	<c:forEach var="pla" items="${planes}">
                            	<option value="${pla.getDescripcion()}">${pla.getDescripcion()}   ${pla.getEspecialidad()}</option>
                            </c:forEach>
						</select>
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