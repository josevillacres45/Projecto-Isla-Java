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
						<c:forEach var="islas" items="${todasIslas}">
							<div class="col-md-4 col-xl-12">
          							<div class="card mb-4 box-shadow">
           							 <div class="flex-xl-row d-xl-flex">
             							 <div class="col-xl-4">
              							 <div class="divImagen" id="${islas.id}-${islas.numeroFotos}" style="background-image: url('../subidas/${islas.id}/1.jpg');"></div>
              							</div>
           							 	<div class="col-xl-8">
            								<div class="card-body">
            							  		<p>Nombre:${islas.nombre}</p>
            							 		<div class="d-flex justify-content-between align-items-center">
                										<div class="btn-group align-items-center">
              							   					<button type="button" class="btn btn-sm btn-outline-secondary">Ver mas</button>
              							    				<small class="text-muted text-center" style="margin-left: 10px">Precio:${islas.precio}</small>
              							    				<small class="text-muted text-center" style="margin-left: 10px">Pais:${islas.pais}</small>
              							    				<small class="text-muted text-center" style="margin-left: 10px">Telefono:${islas.telefono}</small>
               							 				</div>
            							  			</div>
            							  			<a class="btn btn-danger" onclick="return confirm('¿Estas seguro?')" href="borrarIsla?id=${islas.id}">Borrar Isla</a>
            							  			<a class="btn btn-primary" href="editarIsla?id=${islas.id}">Editar Isla</a>
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
	<script type="text/javascript" src="../jsExterno/jquery.js"></script>
	<script type="text/javascript" src="../jsExterno/Bootstrap.js"></script>
	<script type="text/javascript" src="../jsExterno/Popper.js"></script>
  <script type="text/javascript">
    var imagenesTotales=0;
    var mostrarNombreImagen=1;
    var id="";
    var encontradoMatriz=new Boolean(true);
    var intervalo;
    $(".divImagen").mouseover(function(e){
      var nombreId=e.currentTarget.id;
      var encontrado=false;
      for (var i = 0; i < nombreId.length; i++) {
        if(nombreId[i]=="-"){
          encontrado=true;
        }
        if (encontrado && nombreId[i]!="-") {
          imagenesTotales=nombreId[i];
        }else if(nombreId[i]!="-"){
          id+=nombreId[i];
        }
      }
      intervalo=setInterval(moverIntervalo,4000,$(this),id);
    });

    $(".divImagen").mouseout(function(){
      clearInterval(intervalo);
      mostrarNombreImagen=1;
      imagenesTotales=0;
      encontradoMatriz=true;
      $(this).css("background-image","url('../subidas/"+id+"/1.jpg')");
      id="";
    });

    function moverIntervalo(recibidor,id){
      if (encontradoMatriz && imagenesTotales>mostrarNombreImagen) {
        mostrarNombreImagen++;
        recibidor.addClass("horizTranslate");
        recibidor.css("background-image","url('../subidas/"+id+"/"+mostrarNombreImagen+".jpg')");
      }else{
        if (imagenesTotales==1) {
          mostrarNombreImagen==1;
          recibidor.removeClass("horizTranslate");
          recibidor.addClass('horizTranslate');
          recibidor.css("background-image","url('../subidas/"+id+"/"+mostrarNombreImagen+".jpg')");
        }else{
          mostrarNombreImagen--;
          recibidor.removeClass("horizTranslate");
          recibidor.addClass('horizTranslate');
          recibidor.css("background-image","url('../subidas/"+id+"/"+mostrarNombreImagen+".jpg')");
        }
        if (mostrarNombreImagen==1) {
          encontradoMatriz=true;
        }else{
          encontradoMatriz=false;
        }
      }
    }
  </script>
</body>
</html>