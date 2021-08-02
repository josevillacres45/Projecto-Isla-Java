<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,  initial-scale=1, shrink-to-fit=no">
  <link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
<title>Insert title here</title>
</head>
<body>	
	<jsp:include page="menuIslasAdmin.jsp"></jsp:include>
	<div class="album py-5 bg-light">
		<div class="container">
			<div class="col-xl-12">
      			<div class="row">
						<c:forEach var="usuario" items="${todosUsuarios}">
							<div class="col-md-4 col-xl-12">
          							<div class="card mb-4 box-shadow">
           							 <div class="flex-xl-row d-xl-flex">
           							 	<div class="col-xl-8">
            								<div class="card-body">
            							  		<p>Nombre:${usuario.nombre}</p>
            							 		<div class="d-flex justify-content-between align-items-center">
                										<div class="btn-group align-items-center">
              							   					<button type="button" class="btn btn-sm btn-outline-secondary">Ver mas</button>
              							    				<small class="text-muted text-center" style="margin-left: 10px">Email:${usuario.email}</small>
              							    				<small class="text-muted text-center" style="margin-left: 10px">Contraseña:${usuario.password}</small>
               							 				</div>
            							  			</div>
            							  			<a class="btn btn-danger" onclick="return confirm('¿Estas seguro?')" href="borrarUsuario?id=${usuario.id}">Borrar Usuario</a>
            							  			<a class="btn btn-primary" href="editarUsuario?id=${usuario.id}">Editar Usuario</a>
           							 			</div>
            								</div>
            							</div>
       								 </div>
        						</div>
						</c:forEach>
				</div>
			</div>
		</div>
	</div>		
  <script type="text/javascript" src="../jsExterno/jquery.js"></script>
  <script type="text/javascript" src="../jsExterno/Bootstrap.js"></script>
  <script type="text/javascript" src="../jsExterno/Popper.js"></script>
</body>
</html>