<%@page import="entities.Persona" %>

<section id="action" class="py-4 mb-4 bg-secondary">
	<div class="container">
		<div class="row">
			<%
			Persona per = (Persona)session.getAttribute("persona");
			
			if(per.getTipoPersona().equals("Admin") || per.getTipoPersona().equals("Docente")) {
			
			%>
			<div class="col-md-3">
				<a href="principal.jsp" class="btn btn-info btn-block">Inicio</a>
			</div>
			
			<div class="col-md-3">
				<a href="#" data-toggle="modal" data-target="#confirmaEdicionInscripcion"
				class="btn btn-info btn-block">Guardar datos</a>
			</div>
			
			<div class="col-md-3">
				<a href="#" data-toggle="modal" data-target="#confirmaEliminarInscripcion"
				class="btn btn-danger btn-block">Eliminar</a>
			</div>
			<%}%>
			
		</div>
	</div>
</section>

<jsp:include page="/WEB-INF/paginas/docente/listaMaterias.jsp"></jsp:include>
<jsp:include page="/WEB-INF/paginas/elementosComunes/inscripcion/confirmaEdicionInscripcion.jsp"></jsp:include>
<jsp:include page="/WEB-INF/paginas/elementosComunes/inscripcion/confirmaEliminarInscripcion.jsp"></jsp:include>