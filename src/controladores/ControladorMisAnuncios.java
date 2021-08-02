package controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class ControladorMisAnuncios {
	@RequestMapping("misAnuncios")
	public String misAnuncios(HttpServletRequest request,Model model) {
		if(request.getSession().getAttribute("idUsuario") != null) {
			return "misAnuncios/Index";
		}else {
			model.addAttribute("mensaje","para entrar en mis anuncios debes "
					+ "identificarte");
			return "loginUsuario";
		}
	}
}
