<%@ page contentType="text/html; charset=UTF-8"%>
<div class="modal fade" id="agregarPlanModal">
	<div class="modal-dialog modal-lg">
	<div class="modal-content">
		<div class="modal-header bg-success text-white">
			<h5 class="modal-title">Agregar plan</h5>
			<button class="close" data-dismiss="modal">
				<span>&times;</span>
			</button>
		</div>
		
		<form action="${pageContext.request.contextPath}/ControladorPlan?accion=insertar"
		method="post" class="was-validated">
			
			<div class="modal-body">
				<div class="form-group">
					<label for="descripcion">Descripción</label>
					<input type="text" class="form-control" name="descripcion" required> 
				</div>
				<div class="form-group">
					<label for="especialidad">Especialidad</label>
					<input type="text" class="form-control" name="especialidad" required>
				</div>
				
				<div class="modal-footer">
					<button class="btn btn-primary" type="submit">Guardar</button> 
				</div>				
			</div>
		</form>
	</div>
	</div>
</div>