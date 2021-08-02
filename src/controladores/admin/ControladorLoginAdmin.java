package controladores.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/")
public class ControladorLoginAdmin {

	@RequestMapping("")
	public String login() {
		return "/admin/login";
	}
	
	@RequestMapping("/identificarAdmin")
	public String identificarAdmin(String pass, Model model) {
		System.out.println("Funciona");
		if (pass.equals("123")) {
			return "/admin/bienvenido";
		}else {
			model.addAttribute("mensaje", "pass incorrecto");
			return "/admin/login";
		}
	}
}
