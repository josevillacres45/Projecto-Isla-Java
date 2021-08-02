package servicios;

import java.util.List;
import java.util.Map;

import modelo.Isla;



public interface ServicioIsla {
	public int totalIslas(String tituloAnuncio); 
	public void registrarIsla(Isla islaNueva,long idUsuario,int idCategoria);
	public void borrarIsla(long id);
	public List<Isla>obtenerIslas(String tituloAnuncio, int comienzoPagina);
	public Map<String,Object>obtenerIsla_Editar(long id);
	public List<Map<String,Object>>obtenerIslaPor_IdUsuario(long idUsuario);
	public Isla obtenerIslaPorId(long id);
	public void guardarCambiosIsla(Isla islaModificada,long idUsuario);
	
}
