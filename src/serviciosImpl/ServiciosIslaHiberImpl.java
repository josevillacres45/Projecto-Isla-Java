package serviciosImpl;

import java.util.List;



import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import modelo.Categorias;
import modelo.Isla;
import modelo.Usuario;
import servicios.ServicioIsla;
import constantesSQL.ConstantesIslas;

@Service
@Transactional
public class ServiciosIslaHiberImpl implements ServicioIsla {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void registrarIsla(Isla islaNueva,long idUsuario,int idCategoria) {
		Usuario u = (Usuario)sessionFactory.getCurrentSession().get(Usuario.class, idUsuario);
		islaNueva.setUsuario(u);
		Categorias c = (Categorias)sessionFactory.getCurrentSession().get(Categorias.class, idCategoria);
		islaNueva.getCategorias().add(c);
		sessionFactory.getCurrentSession().save(islaNueva);
	}

	@Override
	public void borrarIsla(long id) {
		Isla islaEliminada=(Isla)sessionFactory.getCurrentSession().get(Isla.class, id);
		sessionFactory.getCurrentSession().delete(islaEliminada);
	}
	//Esta anotación nos permite decir qué tipo de advertencias debemos ignorar
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Isla> obtenerIslas(String titulo, int comienzoPagina) {
		
		return sessionFactory.getCurrentSession().createCriteria(Isla.class).
				add(Restrictions.like("nombre","%" + titulo + "%")).
				setFirstResult(comienzoPagina).
				setMaxResults(4).
				addOrder(Order.desc("id")).list();
	}

	@Override
	public Isla obtenerIslaPorId(long id) {
		return (Isla)sessionFactory.getCurrentSession().get(Isla.class, id);
	}

	@Override
	public void guardarCambiosIsla(Isla islaModificada,long idUsuario) {
		Usuario u = (Usuario)sessionFactory.getCurrentSession().get(Usuario.class, idUsuario);
		if (u == null) {
			return;
		}
		islaModificada.setUsuario(u);
		sessionFactory.getCurrentSession().merge(islaModificada);
	}

	@Override
	public List<Map<String, Object>> obtenerIslaPor_IdUsuario(long id_Usuario) {
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(ConstantesIslas.OBTENER_ISLAS_POR_IDUsuario);
		query.setParameter("idUsuario", id_Usuario);
		query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
		List<Map<String, Object>> res = query.list();
		return res;
	}

	@Override
	public Map<String, Object> obtenerIsla_Editar(long id) {
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(ConstantesIslas.OBTENER_ISLA_PARA_EDITAR);
		query.setParameter("idIsla", id);
		query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE).uniqueResult();
		return (Map<String, Object>)query.uniqueResult();
	}

	@Override
	public int totalIslas(String tituloAnuncio) {
		SQLQuery sql = sessionFactory.getCurrentSession().createSQLQuery(ConstantesIslas.OBTENER_TOTALISLA);
		sql.setParameter("nombreIsla", "%" + tituloAnuncio + "%");
		return Integer.parseInt(sql.list().get(0).toString()); 
	}
	
}
