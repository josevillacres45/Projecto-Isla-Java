package controladores;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import servicios.ServicioIsla;

@Controller
public class ControladorAnuncioIsla {
	@Autowired
	private ServicioIsla servicioIslas;

	@SuppressWarnings("unchecked")
	@RequestMapping("listarAnunciosIsla")
	public String listarAnuncios(@RequestParam(defaultValue = "")String tituloAnuncio, Integer numPagina, Map model) {
		int comienzoInteger = 0;
		if (numPagina != null) {
			comienzoInteger = numPagina.intValue();
		}
		model.put("tituloAnuncio", tituloAnuncio);
		model.put("islas", servicioIslas.obtenerIslas(tituloAnuncio, comienzoInteger));
		model.put("anterior", comienzoInteger - 4 );
		model.put("siguiente", comienzoInteger + 4 );
		model.put("total",servicioIslas.totalIslas(tituloAnuncio));
		
		return "listarIslas";
	}

//	@RequestMapping("registrarIsla")
//	public String registrarAnuncioIsla(Map model) {
//		model.put("nuevaIsla", new Isla());
//		return "registrarIsla";
//	}
//
//	@RequestMapping("guardarNuevoAnuncio")
//	public String insertarNuevaIsla(Isla islaNueva, Map model, BindingResult br, HttpServletRequest request) {
//		if (br.hasErrors()) {
//			model.put("nuevaIsla", islaNueva);
//			return "registrarIsla";
//		} else {
//			long idUsuario=(long)request.getSession().getAttribute("idUsuario");
//			servicioIslas.registrarIsla(islaNueva,idUsuario);
//			String rutaRealProyecto = request.getServletContext().getRealPath("");
//			GestorArchivos.guardarPortadaIsla(islaNueva, rutaRealProyecto);
//			return listarAnuncios(model);
//		}
//
//	}
}
