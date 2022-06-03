<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="entities.Persona" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%
Persona per = (Persona)session.getAttribute("persona"); 
if(per.getTipoPersona().equals("Admin")) {
%>
<section id="materias">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="card-header bg-success text-white">
						<h4>Listado de personas</h4>
					</div>
					<table class="table table-striped">
						<thead class="thead-dark">
							<tr>
								<th>Id</th>
								<th>Nombre</th>
								<th>Apellido</th>
								<th>Dirección</th>
								<th>Email</th>
								<th>Fecha de nacimiento</th>
								<th>Legajo</th>
								<th>Tipo de persona</th>
								<th>Nombre de usuario</th>								
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>

							<c:forEach var="persona" items="${personas}">
								<tr>
									<td>${persona.getIdPersona()}</td>
									<td>${persona.getNombre()}</td>
									<td>${persona.getApellido()}</td>
									<td>${persona.getDireccion()}</td>
									<td>${persona.getEmail()}</td>
									<td>${persona.getFechaNacimiento()}</td>
									<td>${persona.getLegajo()}</td>
									<td>${persona.getTipoPersona()}</td>
									<td>${persona.getNombreUsuario()}</td>
									
									<td>
										<a href="${pageContext.request.contextPath}/ControladorPersona?accion=editar&idPersona=${persona.getIdPersona()}"
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
</section>


<!-- Agregar persona Modal -->
<jsp:include page="/WEB-INF/paginas/persona/agregarPersona.jsp"></jsp:include>
<%}%>