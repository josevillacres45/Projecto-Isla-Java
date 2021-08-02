package serviciosImpl;

import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import constantesSQL.ConstantesIslas;
import modelo.Categorias;
import servicios.ServicioCategorias;

@Service
@Transactional
public class ServicioCategoriaImpl implements ServicioCategorias{
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public void registrarCategoria(Categorias c) {
		sessionFactory.getCurrentSession().save(c);
	}

	@Override
	public List<Categorias> obtenerCategorias() {
		return sessionFactory.getCurrentSession().createCriteria(Categorias.class).list();
	}

	@Override
	public List<Map<String, Object>> obtenerCategoriasListado() {
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery(ConstantesIslas.OBTENER_LISTADO_CATEGORIA);
		query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
		return query.list();
	}

	@Override
	public void borrarCategoria(int idCategoria) {
		Categorias categoriaEliminada = (Categorias)sessionFactory.getCurrentSession().get(Categorias.class, idCategoria);
		sessionFactory.getCurrentSession().delete(categoriaEliminada);
	}

	@Override
	public void modificarCategoria(Categorias c) {
		sessionFactory.getCurrentSession().merge(c);
	}

	@Override
	public Categorias obtenerCategoria_PorId(int idCategoria) {
		return (Categorias)sessionFactory.getCurrentSession().get(Categorias.class, idCategoria);
	}
	
}
