<%@ page contentType="text/html; charset=UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal fade" id="listarMateriaPlanModal">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header bg-info text-white">
				<h5 class="modal-title">Listado de materias de un plan</h5>
				<button class="close" data-dismiss="modal">
					<span>&times;</span>
				</button>
			</div>
			
			<!-- Formulario para obtener el nombre del plan -->
			<form action="${pageContext.request.contextPath}/ControladorPlan?accion=buscarPlan"
			method="post" class="was-validated">
			
				<div class="modal-body">
					<div class="input-group mb-3">
						<label class="input-group-text" for="descripcion">Plan</label>
						<select class="form-select" aria-label="Default select example" name="descripcion">
                          	<c:forEach var="pla" items="${planes}">
                            	<option value="${pla.getDescripcion()}">${pla.getDescripcion()} ${pla.getEspecialidad()}</option>
                            </c:forEach>
						</select>
					</div>
				<div class="row">
					<div class="col-md-3">
						<button class="btn btn-primary btn-block" type="submit">Buscar materias</button> 
					</div>
				</div>
				</div>
			</form>
			
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/paginas/listarMateriasPlan/listaPlanes.jsp"></jsp:include>