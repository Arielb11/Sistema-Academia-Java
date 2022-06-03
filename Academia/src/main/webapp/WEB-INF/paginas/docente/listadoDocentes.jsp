<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="entities.Persona" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section id="docentes">
<%
Persona per = (Persona)session.getAttribute("persona"); 
if(per.getTipoPersona().equals("Admin")) {
%>
	<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="card">
						<div class="card-header bg-success text-white">
							<h4>Listado de docentes</h4>
						</div>
						<table class="table table-striped">
							<thead class="thead-dark">
								<tr>
									<th>Nombre</th>
									<th>Apellido</th>
									<th>Cargo</th>
									<th>Materia</th>
									
									<th></th>
								</tr>
							</thead>
							<tbody>
							
								<c:forEach var="docente" items="${docentes}">
									<tr>
										<td>${docente.getNombre()}</td>
										<td>${docente.getApellido()}</td>
										<td>
											<c:choose>
												<c:when test="${docente.getCargo() != null}">
													${docente.getCargo()}
												</c:when>
												<c:when test="${docente.getCargo() == null}">
													Sin cargo aún
												</c:when>
											</c:choose>
										
										</td>
										<td>
											<c:choose>
												<c:when test="${docente.getDescripcionMateria() != null}">
													${docente.getDescripcionMateria()}
												</c:when>
												<c:when test="${docente.getDescripcionMateria() == null}">
													Materia no asignada
												</c:when>
											</c:choose>
										</td>
										<td>
											<a href="${pageContext.request.contextPath}/ControladorDocente?accion=editar&idDocente=${docente.getIdDocente()}"
											class="btn btn-secondary">Editar</a>
										</td>
										
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	<%}%>
</section>

<jsp:include page="/WEB-INF/paginas/docente/agregarDocente.jsp"></jsp:include>