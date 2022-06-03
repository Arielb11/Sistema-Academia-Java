<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="entities.Persona" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
Persona per = (Persona)session.getAttribute("persona"); 
if(per.getTipoPersona().equals("Admin")) {
%>
<section id="planes">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="card-header bg-success text-white">
						<h4>Listado de planes</h4>
					</div>
					<table class="table table-striped">
						<thead class="thead-dark">
							<tr>
								<th>Id</th>
								<th>Descripcion</th>
								<th>Especialidad</th>
								
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="plan" items="${planes}">
								<tr>
									<td>${plan.getIdPlan()}</td>
									<td>${plan.getDescripcion()}</td>
									<td>${plan.getEspecialidad()}</td>
									
									<td>
										<a href="${pageContext.request.contextPath}/ControladorPlan?accion=editar&idPlan=${plan.getIdPlan()}"
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
<%}%>
<jsp:include page="/WEB-INF/paginas/plan/agregarPlan.jsp"></jsp:include>