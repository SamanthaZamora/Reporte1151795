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
        <a class="navegacion__enlace navegacion__enlace--activo" href="<%=request.getContextPath()%>/TokenServlet?action=list" style="text-decoration: none">listado</a>
    </nav>
    
    <br>
	
	<div class="row">
		<div class="container">
		<br>
			<h2 class="text-center"><strong>Listado de Tokens </strong></h2>
			<hr>
			
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/TokenServlet?action=new" class="btn boton" >Nuevo Token</a>
			</div>
			
			<br>
			
			<table class="table table-bordered">
				<thead>
					<tr>				
						<th>Id</th>																
						<th>Host</th>
						<th>Userdb </th>
						<th>Pass </th>
						<th>Base de Datos </th>					
						<th>Token </th>
						<th>Port </th>
						<th>Usuario </th>					
						<th>State </th>
						<th>Type </th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="votante" items="${listaVotante}">
						<tr>
							<td><c:out value="${votante.id}" /></td>
							<td><c:out value="${votante.nombre}" /></td>							
							<td><c:out value="${votante.email}" /></td>
							<td><c:out value="${votante.tipodocumentoBean.descripcion}" /></td>
							<td><c:out value="${votante.documento}" /></td>
							<td><c:out value="${votante.eleccionBean.nombre}" /></td>
							<td>
								<a href="<%=request.getContextPath()%>/VotanteServlet?action=edit&id=${votante.id}">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
								<a href="VotanteServlet?action=delete&id=${votante.id}">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>