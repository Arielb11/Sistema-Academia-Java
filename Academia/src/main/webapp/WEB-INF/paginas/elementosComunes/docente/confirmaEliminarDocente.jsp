<div class="modal" tabindex="-1" id="confirmaEliminarDocente">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Eliminar cargo y/o materia</h5>
        	<a href="docentes.jsp" class="close"><span>&times;</span></a>
      </div>
      <div class="modal-body">
        <p>¿Desea eliminar los datos del cargo y materia del docente seleccionado?</p>
      </div>
      <div class="modal-footer">
        <a href="docentes.jsp" class="btn btn-secondary">Volver</a>
        <a href="${pageContext.request.contextPath}/ControladorDocente?accion=eliminar&idDocente=${docente.getIdDocente()}" 
				class="btn btn-danger btn-block">Eliminar</a>
      </div>
    </div>
  </div>
</div>