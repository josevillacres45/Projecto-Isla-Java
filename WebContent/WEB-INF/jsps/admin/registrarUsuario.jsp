<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
<title>Registrar Usuario</title>
</head>
<body>
    <jsp:include page="menuIslasAdmin.jsp"></jsp:include>
    <springform:form method="POST" commandName="usuarioNuevo" action="registrarUsuario">
        <div class="d-flex">
            <h3>Nombre</h3>
            <springform:input path="nombre" id="nombre"/> 
            <span class="text-danger d-none">Nombre campo erroneo, no incluyas numeros</span> 
        </div>
        <div class="d-flex">
            <h3>Email</h3>
            <springform:input path="email" id="email"/>
            <span class="text-danger d-none">Email erroneo</span> 
            <span class="text-danger"> ${mensaje}</span> 
        </div>
        <div class="d-flex">
            <h3>Password</h3>
            <springform:input path="password"  id="password"/> 
            <span class="text-danger d-none">Password erroneo.incluya mayuscula y minuscula, caracter especial. NO ESPACIOS EN BLANCO EJ: '123$MnHolis'</span> 
        </div>
        <input type="submit" value="Registro" />
        
    </springform:form>
    <script type="text/javascript" src="../jsExterno/jquery.js"></script>
	<script type="text/javascript" src="../jsExterno/Bootstrap.js"></script>
    <script type="text/javascript" src="../jsExterno/Popper.js"></script>
    <script type="text/javascript" src="../js/validaciones.js"></script>
    <script>
         $("form").submit((e) => {
            let nombre = $("#nombre").val();
            let email = $("#email").val();
            let password = $("#password").val();
            let cont = 0;

            if(validateName(nombre)){
                cont++;
                $("#nombre").siblings("span").addClass("d-none");
            }else{
                $("#nombre").siblings("span").removeClass("d-none");
            }

            if(validateEmail(email)) {
                cont++;
                $("#email").siblings("span").addClass("d-none");
            }else{
                $("#email").siblings("span").removeClass("d-none");
            }
            
            if(validatePassword(password)) {
                cont++;
                $("#password").siblings("span").addClass("d-none");
            }else{
                $("#password").siblings("span").removeClass("d-none");
            } 

            if( cont !== 3 ) e.preventDefault();
            
        });
    </script>
</body>
</html>