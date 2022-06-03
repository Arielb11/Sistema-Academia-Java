<div class="modal" tabindex="-1" id="confirmaEliminarMateria">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Eliminar materia</h5>
        	<a href="materias.jsp" class="close"><span>&times;</span></a>
      </div>
      <div class="modal-body">
        <p>¿Desea eliminar la materia seleccionada?</p>
      </div>
      <div class="modal-footer">
        <a href="materias.jsp" class="btn btn-secondary">Volver</a>
        <a href="${pageContext.request.contextPath}/ControladorMateria?accion=eliminar&idMateria=${materia.getIdMateria()}" 
				class="btn btn-danger btn-block">Eliminar</a>
      </div>
    </div>
  </div>
</div>