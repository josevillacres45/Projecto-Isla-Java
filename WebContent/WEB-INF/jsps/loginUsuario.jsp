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
                <form class="col-12" action="loginUsuario" method="POST">
                    <div class="form-group" id="user-group">
                        <input type="text" class="form-control" placeholder="Email de usuario" name="email"/>
                    </div>
                    <div class="form-group" id="contrasena-group">
                        <input type="password" class="form-control" placeholder="Contrasena" name="password"/>
                    </div>
                    <button type="submit" class="btn btn-primary" id="botonLoginUsuario"><i class="fas fa-sign-in-alt"></i>  Ingresar </button>
                </form>

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