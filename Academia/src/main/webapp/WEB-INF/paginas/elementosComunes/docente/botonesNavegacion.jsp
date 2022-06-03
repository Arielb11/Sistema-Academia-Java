<%@page import="entities.Persona" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<section id="actions" class="py-4 mb-4 bg-secondary">
	<div class="container">
		<div class="row">
			<%Persona per = (Persona)session.getAttribute("persona"); 
			
			if(per.getTipoPersona().equals("Admin")) {
			%>
			
			<div class="col-md-3">
				<a href="#" class="btn btn-info btn-block"
				data-toggle="modal" data-target="#agregarDocenteModal">
					Agregar cargo
				</a>
			</div>
			<div class="col-md-3">
					<a href="principal.jsp" class="btn btn-info btn-block">Inicio</a>
			</div>
			<%}%>
		</div>
	</div>
</section>