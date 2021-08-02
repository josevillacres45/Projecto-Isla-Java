package servicios;

import java.util.List;

import modelo.Usuario;

public interface ServicioUsuario {
	
	public List<Usuario>listarUsuarios();
	public Usuario obtenerUsuarioPorId(long idUsuario);
	public void modificarUsuario(Usuario usuarioModificar);
	public void borrarUsuario(long id);
	public void registrarUsuario(Usuario u);
	public Usuario obtenerUsuarioPorEmailYPass(String email, String contraseña);
	public boolean validarUsuario(String emailUsuario);
	public long buscarUsuario_ConEmail(String emailUsuario);
}
