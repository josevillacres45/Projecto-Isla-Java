package interceptores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class InterceptorUsuarioIdentificador extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if(request.getSession().getAttribute("idUsuario") == null) {
			//usuario no identificado
			response.sendRedirect("../error.jsp");
			return false;
		}else {
			return true;
		}
		
	}
}
