<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="entities.Persona" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section id="materias">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="card-header bg-success text-white">
						<h4>Listado de materias</h4>
					</div>
					<table class="table table-striped">
						<thead class="thead-dark">
							<tr>
								<th>Id</th>
								<th>Descripción</th>
								<th>Horas semanales</th>
								<th>Horas totales</th>
								<th>Plan</th>
								<%
								Persona per = (Persona)session.getAttribute("persona"); 
								if(per.getTipoPersona().equals("Admin")) {
								%>
								<th>Cupo</th>
								<%}%>
								

								
								<th></th>
							</tr>
						</thead>
						<tbody>

							<c:forEach var="materia" items="${materias}">
								<tr>
									<td>${materia.getIdMateria()}</td>
									<td>${materia.getDescripcion()}</td>
									<td>${materia.getHsSemanales()}</td>
									<td>${materia.getHsTotales()}</td>
									<td>${materia.getDescPlan()}</td>
									<% 
									if(per.getTipoPersona().equals("Admin")) {
									%>
									<td>${materia.getCupo()}</td>
									<td>
										<a href="${pageContext.request.contextPath}/ControladorMateria?accion=editar&idMateria=${materia.getIdMateria()}"
										class="btn btn-secondary">Editar</a>
									</td>
									<%}%>
									
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</section>


<jsp:include page="/WEB-INF/paginas/materia/agregarMateria.jsp"></jsp:include>