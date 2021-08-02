<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, 	initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="menuIslasAdmin.jsp"></jsp:include>
	<springform:form method="post" commandName="usuarioModificar" 
action="guardarCambiosUsuario">
		Nombre: <springform:input path="nombre"/> <br/>
		Email: <springform:input path="email"/> <br/>
		Contraseña: <springform:input path="password"/> <br/>
		<springform:hidden path="id"/>
		<input type="submit" value="GUARDAR CAMBIOS"/>
	</springform:form>
	<script type="text/javascript" src="../jsExterno/jquery.js"></script>
	<script type="text/javascript" src="../jsExterno/Bootstrap.js"></script>
	<script type="text/javascript" src="../jsExterno/Popper.js"></script>
</body>
</html>