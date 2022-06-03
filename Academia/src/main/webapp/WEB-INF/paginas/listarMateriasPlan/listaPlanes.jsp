<%@ page contentType="text/html; charset=UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal fade" id="listaPlanesModal">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header bg-warning text-white">
				<h5 class="modal-title">Listado de planes</h5>
				<button class="close" data-dismiss="modal">
					<span>&times;</span>
				</button>
			</div>
			
			<section id="planes">
				<div class="container">
					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<table class="table table-striped">
									<thead class="thead-dark">
										<tr>
											<th>Id</th>
											<th>Descripción</th>
											<th>Especialidad</th>
										</tr>
									</thead>
										<tbody>
											<c:forEach var="plan" items="${planes}">
												<tr>
													<td>${plan.getIdPlan()}</td>
													<td>${plan.getDescripcion()}</td>
													<td>${plan.getEspecialidad()}</td>
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