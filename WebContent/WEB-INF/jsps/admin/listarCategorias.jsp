<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, 	initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
  	<link rel="stylesheet" type="text/css" href="../css/design.css">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="menuIslasAdmin.jsp"></jsp:include>
		<div class="album py-5 bg-light">
		<div class="container">
			<div class="col-xl-12">
      			<div class="row">
						<c:forEach var="categorias" items="${todasCategorias}">
							<div class="col-md-4 col-xl-12">
          							<div class="card mb-4 box-shadow">
           							 <div class="flex-xl-row d-xl-flex">
           							 	<div class="col-xl-8">
            								<div class="card-body">
            							  		<p>Nombre:${categorias.nombre}</p>
            							 		<div class="d-flex justify-content-between align-items-center">
                										<div class="btn-group align-items-center">
              							    				<small class="text-muted text-center" style="margin-left: 10px">Descripcion:${categorias.descripcion}</small>
               							 				</div>
            							  			</div>
            							  			<a class="btn btn-danger" onclick="return confirm('¿Estas seguro?')" href="borrarCategoria?id=${categorias.id}">Borrar Categoria</a>
            							  			<a class="btn btn-primary" href="editarCategoria?id=${categorias.id}">Editar Categoria</a>
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
</body>
	<script type="text/javascript" src="../jsExterno/jquery.js"></script>
	<script type="text/javascript" src="../jsExterno/Bootstrap.js"></script>
	<script type="text/javascript" src="../jsExterno/Popper.js"></script>
</html>