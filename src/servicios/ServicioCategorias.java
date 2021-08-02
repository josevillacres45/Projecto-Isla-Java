package servicios;

import java.util.List;
import java.util.Map;

import modelo.Categorias;



public interface ServicioCategorias {
	public void registrarCategoria(Categorias c);
	public List<Categorias>obtenerCategorias();
	public void borrarCategoria(int idCategoria);
	public Categorias obtenerCategoria_PorId(int idCategoria);
	public void modificarCategoria(Categorias c);
	public List<Map<String,Object>>obtenerCategoriasListado();
}
