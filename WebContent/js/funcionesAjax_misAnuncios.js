	function mostrarIslas(){
			$.ajax("ServicioWebAnuncios/obtenerAnuncios",{
				success:function(data){
					var Islas=JSON.parse(data);
					var contenido="";
					contenido=Mustache.render(plantillaListarIslas,Islas);
					$("#contenidoEnlaces").html(contenido);

					$(".enlaceBorrar").click(function(){
						borrarIsla($(this));
					});
					
					$(".enlaceEditar").click(function(){
						$("#informacion").html("Editar Anuncio");
						editarIsla($(this).attr("idp"));
					});
				}
			});
		}
		
function borrarIsla(elementoClick){
	var aceptar=confirm("¿Deseas borrar esta Isla? De ID: " + elementoClick.attr("idp"));
	if (!aceptar) {
		//esto hace que finalize la funcion
		return;
		}
	$.ajax("ServicioWebAnuncios/borrarAnuncios?id="+elementoClick.attr("idp"),{
			type:"DELETE",
			success:function(){
					mostrarIslas();
			}
		});
}

function editarIsla(idEditar){
						$.ajax("ServicioWebAnuncios/obtenerAnuncioPorId?id="+idEditar,{
							success:function(respuestaDelServlet){
								var islaEncontrada=JSON.parse(respuestaDelServlet);
								var registroSi= confirm("¿Deseas modificar la isla: "+islaEncontrada.nombre+" de ID:"+idEditar+"?");
								if (registroSi) {
									$("#contenidoEnlaces").html(plantillaEditarIsla);

									$("#nombre").val(islaEncontrada.nombre);
									$("#precio").val(islaEncontrada.precio);
									$("#pais").val(islaEncontrada.pais);
									$("#telefono").val(islaEncontrada.telefono);
									$("#email").val(islaEncontrada.email);
									$("#metros_cuadrados").val(islaEncontrada.metros_cuadrados);
									$("#descripcion").val(islaEncontrada.descripcion);
									$("#formularioEditarIsla").submit(function(e){
										var nombre=$("#nombre").val();
										var precio=$("#precio").val();
										var pais=$("#pais").val();
										var telefono=$("#telefono").val();
										var email= $("#email").val();
										var metros_cuadrados=$("#metros_cuadrados").val();
										var descripcion=$("#descripcion").val();
										var idIsla=idEditar;
										if (validateName(nombre) && validateNumber(precio) 
										&& validateName(pais) && validatePhone(telefono) 
										&& validateEmail(email) && validateNumber(metros_cuadrados) 
										&& validateDescripcion(descripcion)){
											var Isla={nombre:nombre,
													precio:precio,
													pais:pais,
													telefono:telefono,
													email:email,
													metros_cuadrados:metros_cuadrados,
													descripcion:descripcion,
													id:idIsla};
											var json=JSON.stringify(Isla);
											$.ajax("ServicioWebAnuncios/guardarCambiosAnuncio",{
												type:"POST",
												data:"islaCambios="+json,
												success:function(){
													alert("Enviado correctamente");
													mostrarIslas();
												}
											});
										}else{
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
							
							}
										e.preventDefault();
									
									});
								}else{
									return;
								}
							}
						});
}