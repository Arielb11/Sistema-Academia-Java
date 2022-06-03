<div class="modal" tabindex="-1" id="confirmaEliminarPersona">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Eliminar persona</h5>
        	<a href="personas.jsp" class="close"><span>&times;</span></a>
      </div>
      <div class="modal-body">
        <p>¿Desea eliminar la persona seleccionada?</p>
      </div>
      <div class="modal-footer">
        <a href="personas.jsp" class="btn btn-secondary">Volver</a>
        <a href="${pageContext.request.contextPath}/ControladorPersona?accion=eliminar&idPersona=${persona.getIdPersona()}" 
				class="btn btn-danger btn-block">Eliminar</a>
      </div>
    </div>
  </div>
</div>