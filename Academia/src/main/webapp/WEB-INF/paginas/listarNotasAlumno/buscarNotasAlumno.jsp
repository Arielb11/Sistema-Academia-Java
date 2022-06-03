<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal fade" id="listarNotasAlumnoModal">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header bg-info text-white">
				<h5 class="modal-title">Listado de notas de un alumno</h5>
				<button class="close" data-dismiss="modal">
					<span>&times;</span>
				</button>
			</div>
			
			<form action="${pageContext.request.contextPath}/ControladorPersona?accion=buscarAlumno"
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
			
				<div class="row">
					<div class="col-md-3">
						<button class="btn btn-primary btn-block" type="submit">Buscar notas</button>
					</div>
				</div>
			</div>
			</form>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/paginas/inscripcion/listaAlumnos.jsp"></jsp:include>