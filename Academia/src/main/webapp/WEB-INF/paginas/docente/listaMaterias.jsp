<%@ page contentType="text/html; charset=UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal fade" id="listaMateriasModal">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header bg-warning text-white">
				<h5 class="modal-title">Listado de materias</h5>
				<button class="close" data-dismiss="modal">
					<span>&times;</span>
				</button>
			</div>
			
			<section id="docentes">
				<div class="container">
					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<table class="table table-striped">
									<thead class="thead-dark">
										<tr>
											<th>Id</th>
											<th>Descripción</th>
											<th>Horas semanales</th>
											<th>Horas totales</th>
											<th>Cupo</th>
											<th>Plan</th>
										</tr>
									</thead>
										<tbody>
											<c:forEach var="mat" items="${materiasAcademia}">
												<tr>
													<td>${mat.getIdMateria()}</td>
													<td>${mat.getDescripcion()}</td>
													<td>${mat.getHsSemanales()}</td>
													<td>${mat.getHsTotales()}</td>
													<td>${mat.getCupo()}</td>
													<td>${mat.getDescPlan()}</td>
												</tr>
											</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</section>
		</div>
	</div>
</div>