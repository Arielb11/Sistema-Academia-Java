<%@page import="entities.Persona" %>
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
				<a href="#" data-toggle="modal" data-target="#confirmaEdicionPlan"
				class="btn btn-info btn-block">Guardar plan</a>
			</div>
			
			<div class="col-md-3">
				<a href="#" data-toggle="modal" data-target="#confirmaEliminarPlan"
				class="btn btn-danger btn-block">Eliminar plan</a>
			</div>
			<%}%>	
		</div>
	</div>
</section>

<jsp:include page="/WEB-INF/paginas/elementosComunes/plan/confirmaEdicionPlan.jsp"></jsp:include>
<jsp:include page="/WEB-INF/paginas/elementosComunes/plan/confirmaEliminarPlan.jsp"></jsp:include>