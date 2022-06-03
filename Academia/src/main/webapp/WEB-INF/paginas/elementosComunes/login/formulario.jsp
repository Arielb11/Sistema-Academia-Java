<%@ page contentType="text/html; charset=UTF-8"%>

	<form action="${pageContext.request.contextPath}/ControladorLogin" method="post">
		<table align="center">
			<tr><td>
				<h2>Inicio de Sesion</h2>
			</td></tr>
			
			<tr>
			<td align="left">
				<label for="usuario" class="h5">Usuario</label>
			</td>
			</tr>
			<tr>
			<td align="center">
				<input type="text" class="h5" name="user" required>
			</td>
			</tr>
			
			<tr>
			<td align="left">
				<label for="clave" class="h5">Contraseña</label>
			</td>
			</tr>
			<tr>
			<td align="center">
				<input type="password" class="h5" name="password" required>
			</td>
			</tr>
			<tr><td align="center"></td></tr>
			<tr><td align="center"></td></tr>
			<tr><td align="center"></td></tr>
			<tr>
			<td align="center">
				<input class="btn btn-success btn-lg" type="submit" value="Ingresar">
				
			</td>
			</tr>
		</table>
	</form>