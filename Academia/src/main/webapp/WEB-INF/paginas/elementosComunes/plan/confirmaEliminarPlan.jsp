<div class="modal" tabindex="-1" id="confirmaEliminarPlan">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Eliminar plan</h5>
        	<a href="planes.jsp" class="close"><span>&times;</span></a>
      </div>
      <div class="modal-body">
        <p>¿Desea eliminar el plan seleccionado?</p>
      </div>
      <div class="modal-footer">
        <a href="planes.jsp" class="btn btn-secondary">Volver</a>
        <a href="${pageContext.request.contextPath}/ControladorPlan?accion=eliminar&idPlan=${plan.getIdPlan()}" 
				class="btn btn-danger btn-block">Eliminar</a>
      </div>
    </div>
  </div>
</div>