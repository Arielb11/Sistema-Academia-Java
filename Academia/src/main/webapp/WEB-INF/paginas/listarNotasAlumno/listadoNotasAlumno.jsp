<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="entities.Persona" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section id="listadoNotasAlumno">
<%
Persona per = (Persona)session.getAttribute("persona"); 
if(per.getTipoPersona().equals("Admin")) {
%>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="card-header  bg-success text-white">
						<h4>Notas del alumno: ${perBuscada.getNombre()} ${perBuscada.getApellido()}</h4>
					</div>
					<table class="table table-striped">
						<thead class="thead-dark">
							<tr>
								<th>Nombre</th>
								<th>Apellido</th>
								<th>Materia</th>
								<th>Nota</th>
							</tr>
						</thead>
					
						<tbody>
							<c:forEach var="inscripcion" items="${notasAlumno}">
								<tr>
									<td>${perBuscada.getNombre()}</td>
									<td>${perBuscada.getApellido()}</td>
									<td>${inscripcion.getDescripcionMateria()}</td>
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

<br />
<br />

<table align="center">
	<td align="center">
		<a href="principal.jsp" class="btn btn-info btn-lg">Inicio</a>
	</td>
</table>