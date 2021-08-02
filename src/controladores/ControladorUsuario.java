package controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import modelo.Usuario;
import servicios.ServicioUsuario;

@Controller
public class ControladorUsuario {
	@Autowired
	private ServicioUsuario servicioUsuarios;
	
	//LOGEARSE
	
	@RequestMapping("prepararIdentificacionUsuario")
	public String prepararIdentificacionUsuario() {
		return "loginUsuario";
	}
	@RequestMapping("loginUsuario")
	public String loginUsuario(@RequestParam("email") String email, 
			@RequestParam("password") String password, Model model, HttpServletRequest request) {
		
		Usuario u = servicioUsuarios.obtenerUsuarioPorEmailYPass(email, password);
		if(u != null) {
			request.getSession().setAttribute("idUsuario", u.getId());
			request.getSession().setAttribute("nombre", u.getNombre());
			request.getSession().setAttribute("email", u.getEmail());
			return "bienvenidoUsuario";
		}else {
			model.addAttribute("mensaje", "Email o pass incorrectos");
			return "loginUsuario";
		}
		
	}
	//REGISTRO
	
	@RequestMapping("prepararRegistroUsuario")
	public String prepararRegistroUsuario(Model model) {
		model.addAttribute("nuevoUsuario", new Usuario());
		return "registroUsuario";
	}
	
	@RequestMapping("guardarNuevoUsuario")
	public String guardarNuevoUsuario(Model model,Usuario nuevoUsuario) {
		if (!servicioUsuarios.validarUsuario(nuevoUsuario.getEmail())) {
			servicioUsuarios.registrarUsuario(nuevoUsuario);
			return "registroUsuarioOk";
		}else {
			model.addAttribute("mensaje", "Este email ya esta registrado");
			return prepararRegistroUsuario(model);
		}
	}
	
	//CERRAR SESION
	
	@RequestMapping("cerrarSesionUsuario")
	private String cerrarSesionUsuario(HttpServletRequest request) {
		request.getSession().invalidate();
		return "logOutUsuario";		
	}
	
}
