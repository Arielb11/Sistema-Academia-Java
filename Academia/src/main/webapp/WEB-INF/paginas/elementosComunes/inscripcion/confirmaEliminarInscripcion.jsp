<div class="modal" tabindex="-1" id="confirmaEliminarInscripcion">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Eliminar inscripción</h5>
        	<a href="inscripciones.jsp" class="close"><span>&times;</span></a>
      </div>
      <div class="modal-body">
        <p>¿Desea eliminar la inscripción?</p>
      </div>
      <div class="modal-footer">
        <a href="inscripciones.jsp" class="btn btn-secondary">Volver</a>
        <a href="${pageContext.request.contextPath}/ControladorInscripcion?accion=eliminar&idMateria=${inscripcion.getIdMateria()}&idPersona=${inscripcion.getIdPersona()}" 
				class="btn btn-danger btn-block">Eliminar inscripcion</a>
      </div>
    </div>
  </div>
</div>