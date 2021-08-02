<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, 	initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/solid.css">
	<link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="menuIslasAdmin.jsp"></jsp:include>
	<springform:form method="post" commandName="categoriaModificar" action="guardarCambiosCategoria">
		Nombre: <springform:input path="nombre"/> <br/>
		Descripcion: <springform:input path="descripcion"/><br/>
		<springform:hidden path="id"/>
		<input type="submit" value="GUARDAR CAMBIOS"/>
	</springform:form>
	<script type="text/javascript" src="../jsExterno/jquery.js"></script>
	<script type="text/javascript" src="../jsExterno/Bootstrap.js"></script>
	<script type="text/javascript" src="../jsExterno/Popper.js"></script>
</body>

</html>