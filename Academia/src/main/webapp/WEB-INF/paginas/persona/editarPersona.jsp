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


<title>Editar persona</title>
</head>
<body>




	<!-- Cabecero -->
	<jsp:include page="/WEB-INF/paginas/elementosComunes/persona/cabecero.jsp"></jsp:include>
	<!-- Cabecero -->
	
	<form action="${pageContext.request.contextPath}/ControladorPersona?accion=modificar&idPersona=${persona.getIdPersona()}" 
	method="post" class="was-validated">
	

	<jsp:include page="/WEB-INF/paginas/elementosComunes/persona/botonesNavegacionEdicion.jsp"></jsp:include>
	
	
	<section id="details">
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="card">
						<div class="card-header bg-success text-white">
							<h4>Editar persona</h4>
						</div>
						
						<div class="card-body">
							
							<div class="form-group">
								<label for="nombre">Nombre</label>
								<input type="text" class="form-control" name="nombre" required value="${persona.getNombre()}">
							</div>
							<div class="form-group">
								<label for="apellido">Apellido</label>
								<input type="text" class="form-control" name="apellido" required value="${persona.getApellido()}">
							</div>
							<div class="form-group">
								<label for="direccion">Dirección</label>
								<input type="text" class="form-control" name="direccion" required value="${persona.getDireccion()}">
							</div>
							<div class="form-group">
								<label for="email">Email</label>
								<input type="email" class="form-control" name="email" required value="${persona.getEmail()}">
							</div>
							<div class="form-group">
								<label for="telefono">Teléfono</label>
								<input type="text" class="form-control" name="telefono" required value="${persona.getTelefono()}">
							</div>
							<div class="form-group">
								<label for="fechaNacimiento">Fecha de nacimiento</label>
								<input type="date" class="form-control" name="fechaNacimiento" required value="${persona.getFechaNacimiento()}">
							</div>
							<div class="form-group">
								<label for="legajo">Legajo</label>
								<input type="number" class="form-control" name="legajo" required value="${persona.getLegajo()}">
							</div>
							<div class="form-group">	
								<label for="nombreUsuario">Nombre de usuario</label>
								<input type="text" class="form-control" name="nombreUsuario" required value="${persona.getNombreUsuario()}">
							</div>
							<div class="form-group">
								<label for="clave">Clave</label>
								<input type="password" class="form-control" name="clave" required value="${persona.getClave()}">
							</div>
							<div class="input-group mb-20">
		  						<label class="input-group-text" for="tipoPersona">Tipo de persona</label>
			  						<select class="form-select" name="tipoPersona">
			  							<option selected>${persona.getTipoPersona()}</option>
			  							
			  							
			  							<c:choose>
			  								<c:when test="${persona.getTipoPersona().equals('Docente') || persona.getTipoPersona().equals('Alumno')}">
			  									<c:choose>
			  										 <c:when test="${persona.getTipoPersona().equals('Docente')}">
			  										 	<option value="Admin">Administrador</option>	
			  										 	<option value="Alumno">Alumno</option>
			  										 </c:when>
			  										 <c:when test="${persona.getTipoPersona().equals('Alumno')}">
				  										 <option value="Admin">Administrador</option>
				  										 <option value="Docente">Docente</option>
			  										 </c:when>
			  									</c:choose>	
			  								</c:when>
			  								
			  								<c:when test="${persona.getTipoPersona().equals('Admin')}">
													<option value="Docente">Docente</option>
		  											<option value="Alumno">Alumno</option>
			  								</c:when>
			  							</c:choose>
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