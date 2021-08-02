package controladores.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import modelo.Usuario;
import servicios.ServicioIsla;
import servicios.ServicioUsuario;

@Controller
@RequestMapping("admin/")
public class ControladorUsuarioAdmin {
	@Autowired
	private ServicioUsuario serviciosUsuario;
	
	
	@RequestMapping("usuarioNuevo")
	public String usuarioNuevo(Model model) {
		model.addAttribute("usuarioNuevo", new Usuario());
		return "admin/registrarUsuario";
	}
	@RequestMapping("registrarUsuario")
	public String registrarUsuario(@ModelAttribute("usuarioNuevo")Usuario u, Model model) {
		if (!serviciosUsuario.validarUsuario(u.getEmail())) {
			serviciosUsuario.registrarUsuario(u);
			return listarUsuarios(model);
		}else {
			model.addAttribute("mensaje", "Este usuario ya existe");
			model.addAttribute("usuarioNuevo", u);
			return "admin/registrarUsuario";
		}
	}
	@RequestMapping("listarUsuarios")
	public String listarUsuarios(Model model){
		model.addAttribute("todosUsuarios",serviciosUsuario.listarUsuarios());
		return "admin/listarUsuarios";
	}
	@RequestMapping("borrarUsuario")
	public String borrarUsuario(@ModelAttribute("id")String idUsuario,Model model) {
		serviciosUsuario.borrarUsuario(Long.parseLong(idUsuario));
		return listarUsuarios(model);
	}
	@RequestMapping("editarUsuario")
	public String editarUsuario(Model model,@ModelAttribute("id")String idUsuario) {
		model.addAttribute("usuarioModificar",serviciosUsuario.obtenerUsuarioPorId(Long.parseLong(idUsuario)));
		return "admin/editarUsuario";
	}
	@RequestMapping("guardarCambiosUsuario")
	public String guardarCambiosUsuario(Model model,@ModelAttribute("usuarioModificar")Usuario usuarioModificar) {
		System.out.println(usuarioModificar.getPassword());
		serviciosUsuario.modificarUsuario(usuarioModificar);
		return listarUsuarios(model);
	}
}
