<%@ page contentType="text/html; charset=UTF-8"%>

<%@page import="entities.Persona" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<section id="listadoMateriasPlan">
<%
Persona per = (Persona)session.getAttribute("persona"); 
if(per.getTipoPersona().equals("Admin")) {
%>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="card-header  bg-success text-white">
						<h4>Listado de materias del plan ${planBuscado.getDescripcion()}</h4>
					</div>
					<table class="table table-striped">
						<thead class="thead-dark">
							<tr>
								<th>Id</th>
								<th>Descripción</th>
								<th>Horas semanales</th>
								<th>Horas totales</th>
								<th>Cupo</th>
								<th>Especialidad</th>
								
							</tr>
						</thead>
						<tbody>
							
							<c:forEach var="materia" items="${materiasPlan}">
								<tr>
									<td>${materia.getIdMateria()}</td>
									<td>${materia.getDescripcion()}</td>
									<td>${materia.getHsSemanales()}</td>
									<td>${materia.getHsTotales()}</td>
									<td>${materia.getCupo()}</td>
									<td>${planBuscado.getEspecialidad()}</td>
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