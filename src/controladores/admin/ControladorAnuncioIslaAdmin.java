package controladores.admin;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import modelo.Categorias;
import modelo.Isla;
import servicios.ServicioCategorias;
import servicios.ServicioIsla;
import servicios.ServicioUsuario;

@Controller
@RequestMapping("admin/")
public class ControladorAnuncioIslaAdmin {
	@Autowired
	private ServicioIsla serviciosIslas;
	@Autowired
	private ServicioUsuario servicioUsuario;
	@Autowired
	private ServicioCategorias servicioCategoria;
	
	@PostConstruct
	public List<Categorias>categorias(){
		return servicioCategoria.obtenerCategorias();
	}
	
	@RequestMapping("registrarIsla")
	public String registrarIsla(@ModelAttribute("islaNueva")Isla islaNueva, @RequestParam("categoriaIsla") int idCategoria,Model model) {
		
		if(servicioUsuario.validarUsuario(islaNueva.getEmail())) {
			long idUser = servicioUsuario.buscarUsuario_ConEmail(islaNueva.getEmail());
			serviciosIslas.registrarIsla(islaNueva, idUser, idCategoria);
			return listarIslas(model);
		}else {
			model.addAttribute("mensaje", "Este Usuario no existe");
			model.addAttribute("islaNueva", islaNueva);
			model.addAttribute("listarCategorias", categorias());
			return "admin/registrarIsla";
		}
	}
	@RequestMapping("islaNueva")
	public String islaNueva(Model model) {
		model.addAttribute("islaNueva", new Isla());
		model.addAttribute("listarCategorias", categorias());
		return "admin/registrarIsla";
	}
	
	
	//ARREGLARRRRRRRRRRRRRRR
	
	@RequestMapping("listarIslas")
	public String listarIslas(Model model) {
		model.addAttribute("todasIslas",serviciosIslas.obtenerIslas("", 0));
		return "admin/listarIslas";
	}
	
	@RequestMapping("borrarIsla")
	public String borrarIsla(Model model,String id) {
		serviciosIslas.borrarIsla(Long.parseLong(id));
		return listarIslas(model);
	}
	
	@RequestMapping("editarIsla")
	public String editarIsla(Model model,String id) {
		model.addAttribute("islaModificar",serviciosIslas.obtenerIslaPorId(Long.parseLong(id)));
		return "admin/editarIsla"; 
	}
	
	@RequestMapping("guardarCambiosIsla")
	public String guardarCambiosIsla(@ModelAttribute("islaModificar")Isla islaModificada,Model model){
		System.out.println("El id del usuario de la isla es: " + islaModificada.getUsuario().getId());
		serviciosIslas.guardarCambiosIsla(islaModificada, islaModificada.getUsuario().getId());
		return listarIslas(model);
	}
	
}
