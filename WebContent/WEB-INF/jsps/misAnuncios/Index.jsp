<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/design.css">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../menuIslas.jsp"/>
<h1 id="informacion" class="ml-3">Tus Anuncios</h1>
	<div id="pagina">
		<div id="enlaces" class="ml-3">
			<a href="#" id="enlaceListado">Ver mis anuncios</a>
			<a href="#" id="enlaceRegistro">Registrar anuncio</a>
		</div>
		<div id="contenidoEnlaces"></div>
	</div>
	<script type="text/javascript" src="jsExterno/jquery.js"></script>
	<script type="text/javascript" src="jsExterno/mustache.js"></script>
	<script type="text/javascript" src="js/cargaPlantilla.js"></script>
	<script type="text/javascript" src="js/validaciones.js"></script>
	<script type="text/javascript" src="jsExterno/Bootstrap.js"></script>
	<script type="text/javascript" src="jsExterno/Popper.js"></script>
	<script type="text/javascript" src="js/funcionesAjax_misAnuncios.js"></script>
	<script type="text/javascript">
		//Cargar Plantillas
		let plantillaRegistrarIsla = cargarPlantillaRegistrarIsla();
		let plantillaListarIslas = cargarPlantillaListarIslas();
		let plantillaEditarIsla = cargarPlantillaEditarIsla();
		//Funciones

		$("#enlaceListado").click(function(){
			$("#informacion").html("Tus Anuncios");
			mostrarIslas();
		});
		$("#enlaceRegistro").click(function(){
			$("#informacion").html("Registrar Anuncio");
			mostrarRegistroIsla();
		});
		
		
		function mostrarRegistroIsla(){
			$.ajax("ServicioWebAnuncios/listarCategorias", {
				success : function(resultado){
					var categorias = JSON.parse(resultado);
					var contenido = Mustache.render(plantillaRegistrarIsla,categorias);
					$("#contenidoEnlaces").html(contenido);

				$("#formData").submit((e) => {

					let nombre = $("#nombre").val();
					let precio = parseInt($("#precio").val());
					let pais = $("#pais").val();
					let telefono = parseInt($("#telefono").val());
					let email = $("#email").val();
					let metros_cuadrados = parseInt($("#metros_cuadrados").val());
					let descripcion = $("#descripcion").val();
					let portada = $("#portada1").val();
					let categoria = $("#idCategoria").val();
					if (validateName(nombre) && validateNumber(precio) 
						&& validateName(pais) && validatePhone(telefono) 
						&& validateEmail(email) && validateNumber(metros_cuadrados) 
						&& validateDescripcion(descripcion) && validatePortada(portada)
						&& validateCategoria(categoria)) {
						var tuIsla = {
							nombre: nombre,
							precio:precio,
							pais:pais,
							telefono:telefono,
							email:email,
							metros_cuadrados:metros_cuadrados,
							descripcion:descripcion };

						var json = JSON.stringify(tuIsla); 
						alert("Vamos a mandar el servlet: " + json);
						var form = document.getElementById("formData");
						var formData = new FormData(form);
						$.ajax("ServicioWebAnuncios/registrarAnuncio", {
							type: "POST",
							data: formData,
							cache: false,
							contentType: false,
							processData: false,
							success: function(res){
								alert("isla enviada al servicio correctamente"+res);
								
								}
								});
						} else {
							e.preventDefault();
							validateName(nombre)
							? $("#nombre").siblings("span").addClass("d-none") 
							: $("#nombre").siblings("span").removeClass("d-none");
							
							validateNumber(precio)
							? $("#precio").siblings("span").addClass("d-none") 
							: $("#precio").siblings("span").removeClass("d-none");

							validateName(pais)
							 ? $("#pais").siblings("span").addClass("d-none")
							 : $("#pais").siblings("span").removeClass("d-none");

							validatePhone(telefono)
							 ? $("#telefono").siblings("span").addClass("d-none")
							 : $("#telefono").siblings("span").removeClass("d-none");
							
							validateEmail(email)
							 ? $("#email").siblings("span").addClass("d-none")
							 : $("#email").siblings("span").removeClass("d-none");

							validateNumber(metros_cuadrados)
							 ? $("#metros_cuadrados").siblings("span").addClass("d-none")
							 : $("#metros_cuadrados").siblings("span").removeClass("d-none"); 

							validateDescripcion(descripcion)
							 ? $("#descripcion").siblings("span").addClass("d-none")
							 : $("#descripcion").siblings("span").removeClass("d-none"); 
							
							validatePortada(portada)
							 ? $("#portada1").siblings("span").addClass("d-none")
							 : $("#portada1").siblings("span").removeClass("d-none"); 
							
							validateCategoria(categoria)
							 ? $("#idCategoria").siblings("span").addClass("d-none")
							 : $("#idCategoria").siblings("span").removeClass("d-none"); 
							}
						});

					}
				});
		
		}
		mostrarIslas();
	</script>
</body>
</html>