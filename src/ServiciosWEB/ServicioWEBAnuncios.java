package ServiciosWEB;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import modelo.Isla;
import servicios.ServicioCategorias;
import servicios.ServicioIsla;
import utilidadesArchivos.GestorArchivos;

@Controller
@RequestMapping("ServicioWebAnuncios")
public class ServicioWEBAnuncios {
	@Autowired
	private ServicioIsla serviciosIsla;
	
	@Autowired 
	private ServicioCategorias servicioCategoria;
	
	@RequestMapping("/registrarAnuncio")
	public ResponseEntity<String> registrarAnuncio(@RequestParam Map<String, Object> formData,
			@RequestParam("portada") CommonsMultipartFile portada,
			@RequestParam("portada2") CommonsMultipartFile portada2,
			@RequestParam("portada3") CommonsMultipartFile portada3, HttpServletRequest request) {
		Gson gson = new Gson();
		JsonElement jsonElement = gson.toJsonTree(formData);
		Isla islaFormulario = gson.fromJson(jsonElement, Isla.class);
		long idUsuario = (long) request.getSession().getAttribute("idUsuario");
		serviciosIsla.registrarIsla(islaFormulario, idUsuario,Integer.parseInt(formData.get("idCategoria").toString()));
		/*Portadas*/
		String rutaRealProyecto = request.getServletContext().getRealPath("");
		if (portada.isEmpty()) {
			System.out.println("Es nulo la Portada 1");
		} else {
			islaFormulario.setPortada(portada);
			GestorArchivos.guardarPortadaIsla(islaFormulario, rutaRealProyecto);
		}
		if (portada2.isEmpty()) {
			System.out.println("Es nulo la Portada 2");
		} else {
			islaFormulario.setPortada(portada2);
			GestorArchivos.guardarPortadaIsla(islaFormulario, rutaRealProyecto);
		}
		if (portada3.isEmpty()) {
			System.out.println("Es nulo la Portada 3");
		} else {
			islaFormulario.setPortada(portada3);
			GestorArchivos.guardarPortadaIsla(islaFormulario, rutaRealProyecto);
		}
		islaFormulario.setNumeroFotos(GestorArchivos.devolverNumeroElementosCarpeta(rutaRealProyecto, islaFormulario));
		serviciosIsla.guardarCambiosIsla(islaFormulario, idUsuario);
		for (String nombreCampo : formData.keySet()) {
			System.out.println("He recibido: " + nombreCampo);
		}
		return new ResponseEntity<String>("He recibido", HttpStatus.OK);
	}

	@RequestMapping("/obtenerAnuncios")
	public ResponseEntity<String> obtenerAnuncios(HttpServletRequest request) {
		long idUsuario=(long)request.getSession().getAttribute("idUsuario");
		System.out.println(idUsuario);
		String json = new Gson().toJson(serviciosIsla.obtenerIslaPor_IdUsuario(idUsuario));
		return new ResponseEntity<String>(json, HttpStatus.OK);
	}

	@RequestMapping("/borrarAnuncios")
	public ResponseEntity<String> borrarAnuncio(@RequestParam("id") long id) {
		serviciosIsla.borrarIsla(id);
		return new ResponseEntity<String>("", HttpStatus.OK);
	}

	@RequestMapping("/obtenerAnuncioPorId")
	public ResponseEntity<String> obtenerAnuncioPorId(@RequestParam("id") long id) {
		String json = new Gson().toJson(serviciosIsla.obtenerIsla_Editar(id));
		return new ResponseEntity<String>(json, HttpStatus.OK);
	}

	@RequestMapping("/guardarCambiosAnuncio")
	public ResponseEntity<String> guardarCambiosAnuncio(@RequestParam("islaCambios") String jsonIsla,HttpServletRequest request) {
		Isla islaModificada = new Gson().fromJson(jsonIsla, Isla.class);
		serviciosIsla.guardarCambiosIsla(islaModificada,(long)request.getSession().getAttribute("idUsuario"));
		return new ResponseEntity<String>("", HttpStatus.OK);
	}
	@RequestMapping("/listarCategorias")
	public ResponseEntity<String>listarCategorias(){
		String json = new Gson().toJson(servicioCategoria.obtenerCategoriasListado());
		return new ResponseEntity<String>(json, HttpStatus.OK);
	}
}
