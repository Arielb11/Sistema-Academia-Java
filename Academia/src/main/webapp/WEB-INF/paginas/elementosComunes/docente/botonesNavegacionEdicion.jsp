<%@page import="entities.Persona" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<section id="action" class="py-4 mb-4 bg-secondary">
	<div class="container">
		<div class="row">
			<%
			Persona per = (Persona)session.getAttribute("persona");
			
			if(per.getTipoPersona().equals("Admin")) {
			
			%>
			<div class="col-md-3">
				<a href="principal.jsp" class="btn btn-info btn-block">Inicio</a>
			</div>
			
			<div class="col-md-3">
				<a href="#" data-toggle="modal" data-target="#confirmaEdicionDocente"
				class="btn btn-info btn-block">Guardar datos</a>
			</div>
			<div class="col-md-3">
				<a href="#" data-toggle="modal" data-target="#confirmaEliminarDocente"
				class="btn btn-danger btn-block">Eliminar</a>
			</div>
			<%}%>
		</div>
	</div>
</section>

<jsp:include page="/WEB-INF/paginas/docente/listaMaterias.jsp"></jsp:include>
<jsp:include page="/WEB-INF/paginas/elementosComunes/docente/confirmaEdicionDocente.jsp"></jsp:include>
<jsp:include page="/WEB-INF/paginas/elementosComunes/docente/confirmaEliminarDocente.jsp"></jsp:include>