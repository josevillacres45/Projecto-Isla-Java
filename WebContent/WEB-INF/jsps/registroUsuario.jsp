<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springform"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/solid.css">
<link rel="stylesheet" type="text/css" href="css/design.css">
<title>Mustango Islas</title>
</head>
<body id="loginUser">
	<jsp:include page="menuIslas.jsp"/>
	 <div class="modal-dialog text-center">
        <div class="col-sm-8 main-section">
            <div class="modal-content">
                <div class="col-12 user-img">
                    <img src="imagenesEstaticas/user.png"/>
                </div>
					<springform:form method="post" class="col-12" commandName="nuevoUsuario"
						action="guardarNuevoUsuario">
						<div class="form-group">
							<springform:input path="nombre" placeholder="Nombre de usuario"  />
						</div>
						<div class="form-group">
							<springform:input path="email" placeholder="Email de usuario"  />
						</div>
						<div class="form-group">
							<springform:input type="password" path="password" placeholder="Contraseña"  />
						</div>
						<button type="submit" class="btn btn-primary" id="botonLoginUsuario"><i class="fas fa-sign-in-alt"></i>Registrar</button>
					</springform:form>
				<div class="alert alert-danger" role="alert">
                    ${mensaje}
                </div>
            </div>
        </div>
    </div>

	<script type="text/javascript" src="jsExterno/jquery.js"></script>
	<script type="text/javascript" src="jsExterno/Bootstrap.js"></script>
	<script type="text/javascript" src="jsExterno/Popper.js"></script>
	<script src="https://use.fontawesome.com/releases/v5.0.7/js/all.js"></script>
	<script type="text/javascript">
        var alert=document.getElementsByClassName("alert");
        console.log(alert[0].innerText);
        if (alert[0].innerText=="") {
            alert[0].className+="d-none";
        }
    </script>
</body>
</html>