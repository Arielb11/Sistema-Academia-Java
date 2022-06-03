<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="entities.Persona" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<section id="inscripciones">
<%
Persona per = (Persona)session.getAttribute("persona"); 
if(per.getTipoPersona().equals("Admin") || per.getTipoPersona().equals("Docente")) {
%>
	<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="card">
						<div class="card-header bg-success text-white">
							<h4>Listado de inscripciones a materias</h4>
						</div>
						<table class="table table-striped">
							<thead class="thead-dark">
								<tr>
									<th>Nombre</th>
									<th>Apellido</th>
									<th>Materia</th>
									<th>Nota</th>
									<th>Condición</th>
									
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="inscripcion" items="${inscripciones}">
									<tr>
										<td>${inscripcion.getNombre()}</td>
										<td>${inscripcion.getApellido()}</td>
										<td>
											<c:choose>
												<c:when test="${inscripcion.getDescripcionMateria() != null}">
													${inscripcion.getDescripcionMateria()}
												</c:when>
												<c:when test="${inscripcion.getDescripcionMateria() == null}">
													Aún no está inscripto
												</c:when>
											</c:choose>
										</td>
										<td>
											<c:choose>
												<c:when test="${inscripcion.getNota() != 0}">
													${inscripcion.getNota()}
												</c:when>
												<c:when test="${inscripcion.getNota() == 0 && inscripcion.getCondicion().equals('Cursando')}">
													Aún se encuentra cursando
												</c:when>
												<c:when test="${inscripcion.getNota() == 0 && inscripcion.getCondicion().equals('Regular')}">
													Se encuentra regular
												</c:when>
											</c:choose>
										</td>
										
										<td>${inscripcion.getCondicion()}</td>
											
											<td>
												<a href="${pageContext.request.contextPath}/ControladorInscripcion?accion=editar&idMateria=${inscripcion.getIdMateria()}&idPersona=${inscripcion.getIdPersona()}"
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



<jsp:include page="/WEB-INF/paginas/inscripcion/agregarInscripcion.jsp"></jsp:include>