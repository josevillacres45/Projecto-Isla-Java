package controladores.admin;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import modelo.Categorias;
import servicios.ServicioCategorias;

@Controller
@RequestMapping("admin/")
public class ControladorCategoria {
	@Autowired
	private ServicioCategorias serviciosCategorias;
	
	@RequestMapping("addCategoria")
	public String addCategoria(Model model) {
		model.addAttribute("nuevaCategoria",new Categorias());
		return "admin/addCategoria";
	}
	@RequestMapping("insertarNuevaCategoria")
	public String insertarNuevaCategoria(Model model,@ModelAttribute("nuevaCategoria")Categorias categoria) {
		serviciosCategorias.registrarCategoria(categoria);
		return listarCategorias(model);
	}
	@RequestMapping("listarCategorias")
	public String listarCategorias(Model model) {
		model.addAttribute("todasCategorias", serviciosCategorias.obtenerCategorias());
		return "admin/listarCategorias";
	}

	@RequestMapping("borrarCategoria")
	public String borrarCategoria(Model model, @ModelAttribute("id") String idCategoria) {
		serviciosCategorias.borrarCategoria(Integer.parseInt(idCategoria));
		return listarCategorias(model);
	}

	@RequestMapping("editarCategoria")
	public String editarCategoria(Model model, @ModelAttribute("id") String idCategoria) {
		model.addAttribute("categoriaModificar",
				serviciosCategorias.obtenerCategoria_PorId(Integer.parseInt(idCategoria)));
		return "admin/editarCategoria";
	}

	@RequestMapping("guardarCambiosCategoria")
	public String guardarCambiosCategoria(Model model,
			@ModelAttribute("categoriaModificar") Categorias categoriaModificada) {
		serviciosCategorias.modificarCategoria(categoriaModificada);
		return listarCategorias(model);
	}

}
