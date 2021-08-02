<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
<title>Mustango Islas</title>
</head>
<body>
<jsp:include page="menuIslasAdmin.jsp"></jsp:include>
<springform:form method="post" commandName="islaModificar" 
action="guardarCambiosIsla">
	
		<div class="d-flex">
			Nombre: <springform:input path="nombre" id="nombre"/>
			<span class="d-none is-invalid">El nombre puede estar vacio, ni incluir numeros</span>
		</div>
		<div class="d-flex">
			Precio: <springform:input path="precio" id="precio"/>
			<span class="d-none is-invalid">Solo numeros</span>
		</div> 
		<div class="d-flex">
			Pais: <springform:input path="pais" id="pais"/> 
			<span class="d-none is-invalid">El campo pais no puede estar vacio, ni incluir numeros</span>
		</div>
		<div class="d-flex">
			Email: <springform:input path="email" id="email"/>
			<span class="d-none is-invalid">El campo email es incorrecto</span>
		</div>
		<div class="d-flex">
			Telefono: <springform:input path="telefono" id="telefono"/>
			<span class="d-none is-invalid">El campo telefono no incluye 9 digitos, esta vacio o incluye letras</span>
		</div> 
		<div class="d-flex">
			Metros cuadrados: <springform:input path="metros_cuadrados" id="metros_cuadrados"/>
			<span class="d-none is-invalid">El campo metros cuadrados no estar vacio o incluye letras</span>
		</div>
		<div class="d-flex">
			Descripcion: <springform:input path="descripcion" id="descripcion"/>
			<span class="d-none is-invalid">El campo descripcion esta vacio</span>
		</div> 
		<springform:hidden path="id"/>
		<springform:hidden path="usuario.id"/>
		<input type="submit" value="GUARDAR CAMBIOS">
</springform:form>
	<script type="text/javascript" src="../jsExterno/jquery.js"></script>
	<script type="text/javascript" src="../jsExterno/Bootstrap.js"></script>
	<script type="text/javascript" src="../jsExterno/Popper.js"></script>
	<script type="text/javascript" src="../js/validaciones.js"></script>
	<script>
		$("form").submit(() =>{
			
			let nombreForm = $("#nombre").val();
			let precioForm = $("#nombre").val();
			let paisForm = $("#nombre").val();
			let emailForm = $("#nombre").val();
			let telefonoForm = $("#nombre").val();
			let descripcionForm = $("#nombre").val();
			$("#nombre").siblings("span").removeClass("d-none")
			
			
		});
	</script>
</body>
</html>