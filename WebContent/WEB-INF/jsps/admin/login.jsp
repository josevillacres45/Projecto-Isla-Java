<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
</head>
<body>


<jsp:include page="../menuIslas.jsp"></jsp:include>
<h3>Introduce tu contraseña de administracion:</h3>
<div style="color: red">${mensaje}</div>
<form method="post" action="identificarAdmin">

contraseña: <input type="password" name="pass"/><br/>
<input type="submit" value="ENTRAR"/>

</form>
	<script type="text/javascript" src="../jsExterno/jquery.js"></script>
	<script type="text/javascript" src="../jsExterno/Popper.js"></script>
	<script type="text/javascript" src="../jsExterno/Bootstrap.js"></script>
</body>
</html>