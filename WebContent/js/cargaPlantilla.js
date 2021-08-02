function cargarPlantillaListarIslas(){
		var res = "";
		$.ajax({
		url : "plantillas-mustache/listarIslas.html",
		async: false,//Con Async:false, hasta que no acabe el Ajax, JS no sigue
		success: function(data){
		res = data;
		}
	});
return res;
}
function cargarPlantillaRegistrarIsla(){
		var res = "";
		$.ajax({
		url : "plantillas-mustache/registraIslas.html",
		async: false,//Con Async:false, hasta que no acabe el Ajax, JS no sigue
		success: function(data){
		res = data;
		}
	});
return res;
}
function cargarPlantillaEditarIsla(){
		var res = "";
		$.ajax({
		url : "plantillas-mustache/editarIsla.html",
		async: false,//Con Async:false, hasta que no acabe el Ajax, JS no sigue
		success: function(data){
		res = data;
		}
	});
return res;
}

function cargarPlantillaMenuIsla(){
		var res = "";
		$.ajax({
		url : "plantillas-mustache/menuIsla.html",
		async: false,//Con Async:false, hasta que no acabe el Ajax, JS no sigue
		success: function(data){
		res = data;
		}
	});
return res;
}

