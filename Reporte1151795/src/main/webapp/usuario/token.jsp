<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- JSTL PREFIJO C -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SISTEMA REPORTE UFPS</title>
<link rel="stylesheet" 	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/style2.css">
</head>
<body>

	<header class="header">
        <a href="index.jsp">
            <img class="header__logo" src="img/logo.png" alt="LogoTipo">
        </a>
    </header>
    
    <nav class="navegacion">
        <a class="navegacion__enlace navegacion__enlace--activo" href="index.jsp" style="text-decoration: none">Inicio</a>
        <a class="navegacion__enlace navegacion__enlace--activo" href="#" style="text-decoration: none">Seguimiento</a>
    </nav>

	<br>
	
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">

				<c:if test="${connectiontoken == null}">
					<form action="TokenServlet?action=insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${connectiontoken == null}"> Registro  Token  </c:if>
					</h2>
				</caption>

				<c:if test="${connectiontoken != null}">
					<input type="hidden" name="id" value="<c:out value='${connectiontoken.id}' />" />
				</c:if>

				<br>
				<fieldset class="form-group">
					<label>Host</label> <input type="text"
						value="<c:out value='${connectiontoken.host}' />" class="form-control"
						name="host" required="required" placeholder="Direcci?n del servidor de base de datos">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Userdb</label> <input type="email"
						value="<c:out value='${connectiontoken.userdb}' />" class="form-control"
						name="userdb" required="required" placeholder="Nombre del usuario de conexi?n a la base de datos">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Password</label> <input type="password"
						value="<c:out value='${connectiontoken.pass}' />" class="form-control"
						name="pass" required="required" >
				</fieldset>
				
				<fieldset class="form-group">
					<label>Nombre de la Base de Datos </label> <input type="text"
						value="<c:out value='${connectiontoken.db}' />" class="form-control"
						name="db" required="required" placeholder="Nombre de  la base de datos" >
				</fieldset>
				
				<fieldset class="form-group">
					<label>Token </label> <input type="text"
						value="<c:out value='${connectiontoken.token}' />" class="form-control"
						name="token" required="required" placeholder="Token para la busqueda" >
				</fieldset>
				
				<fieldset class="form-group">
					<label>Port</label> <input type="text"
						value="<c:out value='${connectiontoken.port}' />" class="form-control"
						name="port" required="required" placeholder="Puerto para la conexion"  >
				</fieldset>
				
				<fieldset class="form-group">
					<label>State</label> <input type="text"
						value="<c:out value='${connectiontoken.state}' />" class="form-control"
						name="state" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Tipo de Base de Datos</label> <br> <select name="rol"
						class="rounded form-control">
						<option value="">Tipos registrados</option>
						<c:forEach var="type" items="${listaT}">
							<option value="${type.id}">${type.description}</option>
						</c:forEach>
					</select>
				</fieldset>
				
				<fieldset class="form-group">
					<label>Usuario</label> <br> <select name="rol"
						class="rounded form-control">
						<option value="">Usuarios registrados</option>
						<c:forEach var="usuario" items="${listaU}">
							<option value="${usuario.id}">${usuario.usuario}</option>
						</c:forEach>
					</select>
				</fieldset>
				<br>
				<div class="d-grid gap-2 col-3 mx-auto">
					<button type="submit" class="btn boton" >Guardar</button>
				</div>
				</form>
			</div>
		</div>
	</div>
	
	<br>
	<footer class="footer">
        <p class="footer__texto"> UFPS 2021 </p>
    </footer>
</body>
</html>