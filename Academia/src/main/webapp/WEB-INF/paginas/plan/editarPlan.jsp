<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	
	<jsp:include page="/WEB-INF/paginas/elementosComunes/bootstrap.jsp"></jsp:include>
	
	<!-- Color body -->
	<jsp:include page="/WEB-INF/paginas/elementosComunes/colorFondo.jsp"></jsp:include>
	
<title>Editar plan</title>
</head>

<body>

	<jsp:include page="/WEB-INF/paginas/elementosComunes/plan/cabecero.jsp"></jsp:include>
	
	<form action="${pageContext.request.contextPath}/ControladorPlan?accion=modificar&idPlan=${plan.getIdPlan()}" 
	method="post" class="was-validated">
	
	<jsp:include page="/WEB-INF/paginas/elementosComunes/plan/botonesNavegacionEdicion.jsp"></jsp:include>
	
		<section id="details">
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="card">
						<div class="card-header bg-success text-white">
							<h4>Editar plan</h4>
						</div>
						
						<div class="card-body">
						
							<div class="form-group">
								<label for="descripcion">Descripción</label>
								<input type="text" class="form-control" name="descripcion" required value="${plan.getDescripcion()}">
							</div>
							<div class="form-group">
								<label for="especialidad">Especialidad</label>
								<input type="text" class="form-control" name="especialidad" required value="${plan.getEspecialidad()}">
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