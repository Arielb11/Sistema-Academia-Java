<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="entities.Persona" %>
<%Persona per = (Persona)session.getAttribute("persona"); %>

<div style="text-align: center;">
	<a class="btn btn-success btn-lg" style="height:50px; width:400px" href="${pageContext.request.contextPath}/ControladorMateria" role="button">Materias</a>
	<br />
	<br />
	<br />
<%if(per.getTipoPersona().equals("Admin") || per.getTipoPersona().equals("Docente")) {
%>
	<a class="btn btn-success btn-lg" style="height:50px; width:400px" href="${pageContext.request.contextPath}/ControladorInscripcion" role="button">Agregar/calificar alumno a una materia</a>
	<br />
	<br />
	<br />
	
<%}%>

<% 		
if(per.getTipoPersona().equals("Admin")) {
%>
	<a class="btn btn-success btn-lg" style="height:50px; width:400px" href="${pageContext.request.contextPath}/ControladorDocente" role="button">Docentes</a>
	<br />
	<br />
	<br />
	<a class="btn btn-success btn-lg" style="height:50px; width:400px" href="${pageContext.request.contextPath}/ControladorPersona" role="button">Personas</a>
	<br />
	<br />
	<br />
	<a class="btn btn-success btn-lg" style="height:50px; width:400px" href="${pageContext.request.contextPath}/ControladorPlan" role="button">Planes</a>
	<br />
	<br />
	<br />
	<a href="${pageContext.request.contextPath}/ControladorPlan" class="btn btn-success btn-lg" style="height:50px; width:400px" 
	data-toggle="modal" data-target="#listarMateriaPlanModal">Listado de materias de un plan</a>
	<br />
	<br />
	<br />
	<a href="${pageContext.request.contextPath}/ControladorPersona" class="btn btn-success btn-lg" style="height:50px; width:400px" 
	data-toggle="modal" data-target="#listarNotasAlumnoModal">Listado de notas de un alumno</a>
	<br />
	<br />
	<br />
	<%}%>
	<a class="btn btn-danger btn-lg" style="height:50px; width:400px" href="index.jsp" role="button">Cerrar sesión</a>


</div>

<!-- Listar plan Modal -->
<jsp:include page="/WEB-INF/paginas/listarMateriasPlan/buscarMateriasPlan.jsp"></jsp:include>

<!-- Listar notas Modal -->
<jsp:include page="/WEB-INF/paginas/listarNotasAlumno/buscarNotasAlumno.jsp"></jsp:include>