<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springform"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, 	initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="../css/design.css">
</head>
<body>
<jsp:include page="menuIslasAdmin.jsp"></jsp:include>

 <div class="modal-dialog text-center">
        <div class="col-sm-8 main-section">
            <div class="modal-content">
                <div class="col-12 user-img">
                    <img src="imagenesEstaticas/isla.jpg"/>
                </div>
				<springform:form method="post" class="col-12" commandName="nuevaCategoria"
						action="insertarNuevaCategoria">
						<div class="form-group">
							<springform:input path="nombre" placeholder="Nombre de categoria"  />
						</div>
						<div class="form-group">
							<springform:input path="descripcion" placeholder="Descripcion de categoria"  />
						</div>
						<button type="submit" class="btn btn-primary" id="botonLoginUsuario"><i class="fas fa-sign-in-alt"></i>Insertar Categoria</button>
				</springform:form>
            </div>
        </div>
    </div>
    <script type="text/javascript" src="../jsExterno/jquery.js"></script>
	<script type="text/javascript" src="../jsExterno/Bootstrap.js"></script>
	<script type="text/javascript" src="../jsExterno/Popper.js"></script>
</body>
</html>