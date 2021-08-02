<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
<title>Registrar Isla</title>
</head>
<body>
    <jsp:include page="menuIslasAdmin.jsp"></jsp:include>
    <springform:form method="post" commandName="islaNueva"
    action="registrarIsla">
        <div class="d-flex">
            <h3>Nombre</h3>
            <springform:input path="nombre"/> 
            <span class="text-danger d-none">No puede dejar el nombre vacio ni agregar numeros</span>
            
        </div>
        <div class="d-flex">
            <h3>Precio</h3> 
            <springform:input path="precio"/> 
            <span class="text-danger d-none">Introduzca numeros</span> 
        </div>
        <div class="d-flex">
            <h3>Pais</h3> 
            <springform:input path="pais"/> 
            <span class="text-danger d-none">Introduzca caracteres</span> 
        </div>
        <div class="d-flex">
            <h3>Email</h3> 
            <springform:input path="email" /> 
            <span class="text-danger d-none">Introduzca un email correcto</span> 
         </div>
        <div class="d-flex">
            <h3>Telefono</h3> 
            <springform:input path="telefono"/> 
            <span class="text-danger d-none">Introduzca un telefono correcto</span> 
        </div>
        <div class="d-flex">
            <h3>Metros cuadrados</h3> 
            <springform:input path="metros_cuadrados"/> 
            <span class="text-danger d-none">Introduzca numeros</span> 
        </div>
        <div class="d-flex">
            <h3>Descripcion</h3> 
            <springform:input path="descripcion"/> 
            <span class="text-danger d-none">Rellene el campo descripcion</span> 
        </div>
        <select name="categoriaIsla">
            <c:forEach var="categoria" items="${listarCategorias}">
                <option value="${categoria.id}" >${categoria.nombre}</option>
            </c:forEach>
        </select>
        <input type="submit" value="Registro"/>
        </springform:form>
    
    <script type="text/javascript" src="../jsExterno/jquery.js"></script>
	<script type="text/javascript" src="../jsExterno/Bootstrap.js"></script>
    <script type="text/javascript" src="../jsExterno/Popper.js"></script>
    <script type="text/javascript" src="../js/validaciones.js"></script>
    <script>
        $("form").submit((e) => {
            let nombre = $("#nombre").val();
            let precio = parseInt($("#precio").val());
            let pais = $("#pais").val();
            let email = $("#email").val();
            let telefono = $("#telefono").val();
            let metrosCuadrados = parseInt($("#metros_cuadrados").val());
            let descripcion = $("#descripcion").val();
            let cont = 0;

            if(validateName(nombre)){
                cont++;
                $("#nombre").siblings("span").addClass("d-none");
            }else{
                $("#nombre").siblings("span").removeClass("d-none");
            }
            
            if(validateNumber(precio)){
                cont++;
                $("#precio").siblings("span").addClass("d-none");
            }else{
                $("#precio").siblings("span").removeClass("d-none");
            }
            
            if(validateName(pais)){
                cont++;
                $("#pais").siblings("span").addClass("d-none");
            }else{
                $("#pais").siblings("span").removeClass("d-none");
            }

            if(validateDescripcion(descripcion)){
                cont++;
                $("#descripcion").siblings("span").addClass("d-none");
            }else{
                $("#descripcion").siblings("span").removeClass("d-none");
            }

            if(validateEmail(email)){
                cont++;
                $("#email").siblings("span").addClass("d-none");
            }
            else{
                $("#email").siblings("span").removeClass("d-none");
            }
            
            if(validatePhone(telefono)){
                cont++;
                $("#telefono").siblings("span").addClass("d-none");
            }
            else{
                $("#telefono").siblings("span").removeClass("d-none");
            }
            
            if(validateNumber(metrosCuadrados)){
                cont++;
                $("#metros_cuadrados").siblings("span").addClass("d-none");
            }
            else{
                $("#metros_cuadrados").siblings("span").removeClass("d-none");
            }

            if( cont!==7 ) e.preventDefault();

        });
    </script>
</body>
</html>