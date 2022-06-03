<%@ page contentType="text/html; charset=UTF-8"%>
<div class="modal fade" id="agregarPersonaModal">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header bg-success text-white">
				<h5 class="modal-title">Agregar persona</h5>
				<button class="close" data-dismiss="modal">
					<span>&times;</span>
				</button>
			</div>
			
			<form action="${pageContext.request.contextPath}/ControladorPersona?accion=insertar" 
			method="post" class="was-validated" autocomplete="off">
				
				<div class="modal-body">
					<div class="form-group">
						<label for="nombre">Nombre</label>
						<input type="text" class="form-control" name="nombre" required>
					</div>
					
					<div class="form-group">
						<label for="apellido">Apellido</label>
						<input type="text" class="form-control" name="apellido" required>
					</div>
					
					<div class="form-group">
						<label for="direccion">Dirección</label>
						<input type="text" class="form-control" name="direccion" required>
					</div>
					
					<div class="form-group">
						<label for="email">Email</label>
						<input type="email" class="form-control" name="email" required>
					</div>
					
					<div class="form-group">
						<label for="telefono">Teléfono</label>
						<input type="text" class="form-control" name="telefono" required>
					</div>
					
					<div class="form-group">
						<label for="fechaNacimiento">Fecha de nacimiento</label>
						<input type="date" class="form-control" name="fechaNacimiento" required>
					</div>
					
					<!-- Legajo que se genera de manera automática -->
						<input type="hidden" name="legajo"
						value = "${personas.get(personas.size() - 1).getLegajo() + 1}">
					<!-- Legajo que se genera de manera automática -->
						
					<div class="form-group">	
						<label for="nombreUsuario">Nombre de usuario</label>
						<input type="text" class="form-control" name="nombreUsuario" required>
					</div>
					
					<div class="form-group">
						<label for="clave">Cláve</label>
						<input type="password" class="form-control" name="clave" required>
					</div>
					
					<div class="input-group mb-20">
  						<label class="input-group-text" for="tipoPersona">Tipo de persona</label>
  						<select class="form-select" name="tipoPersona">
    						<option value="Admin">Administrador</option>
    						<option value="Alumno">Alumno</option>
    						<option value="Docente">Docente</option>
  						</select>
					</div>
					
					<div class="modal-footer">
						<button class="btn btn-primary" type="submit">Guardar</button> 
					</div>
				</div>
			</form>
			
			
		</div>
	</div>
</div>