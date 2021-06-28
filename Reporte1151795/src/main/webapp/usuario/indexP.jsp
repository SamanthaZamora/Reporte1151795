<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- JSTL PREFIJO C -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ELECIONES UFPS</title>
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
        <a class="navegacion__enlace navegacion__enlace--activo" href="<%=request.getContextPath()%>/UsuarioServlet?action=list" style="text-decoration: none">Usuarios</a>
    </nav>

	<br>
	
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${usuario != null}">
					<form action="UsuarioServlet?action=update" method="post">
				</c:if>

				<c:if test="${usuario == null}">
					<form action="UsuarioServlet?action=insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${usuario != null}"> Editar usuario </c:if>

						<c:if test="${usuario == null}"> Insertar usuario  </c:if>
					</h2>
				</caption>

				<c:if test="${usuario != null}">
					<input type="hidden" name="id" value="<c:out value='${usuario.id}' />" />
				</c:if>

				<br>
				<fieldset class="form-group">
					<label>Nombre de Usuario</label> <input type="text"
						value="<c:out value='${usuario.usuario}' />" class="form-control"
						name="usuario" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Email</label> <input type="email"
						value="<c:out value='${usuario.email}' />" class="form-control"
						name="email" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Password</label> <input type="password"
						value="<c:out value='${usuario.pass}' />" class="form-control"
						name="pass" required="required">
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
        <p class="footer__texto"> UFPS 2021 - 2025</p>
    </footer>
</body>
</html>