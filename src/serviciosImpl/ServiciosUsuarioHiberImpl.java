package serviciosImpl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import constantesSQL.ConstantesIslas;
import modelo.Usuario;
import servicios.ServicioUsuario;

@Service
@Transactional
public class ServiciosUsuarioHiberImpl implements ServicioUsuario{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Usuario> listarUsuarios() {
		return sessionFactory.getCurrentSession().createCriteria(Usuario.class).addOrder(Order.asc("id")).setMaxResults(10).list();
	}
	@Override
	public void borrarUsuario(long id) {
		Usuario usuario=(Usuario)sessionFactory.getCurrentSession().get(Usuario.class, id);
		sessionFactory.getCurrentSession().delete(usuario);
	}
	@Override
	public Usuario obtenerUsuarioPorId(long idUsuario) {
		Usuario unicoUsuario=(Usuario)sessionFactory.getCurrentSession().get(Usuario.class, idUsuario);
		return unicoUsuario;
	}
	@Override
	public void modificarUsuario(Usuario usuarioModificar) {
		sessionFactory.getCurrentSession().merge(usuarioModificar);
	}
	@Override
	public void registrarUsuario(Usuario u) {
		sessionFactory.getCurrentSession().save(u);
	}

	@Override
	public Usuario obtenerUsuarioPorEmailYPass(String email, String contraseña) {
		Usuario u = (Usuario)sessionFactory.getCurrentSession().
				createCriteria(Usuario.class) //esto seria como "dame todos los usuarios"
				.add(Restrictions.eq("email", email))//de todos ellos "dame los del email indicado"
				.add(Restrictions.eq("password",contraseña)).uniqueResult();
		return u;
	}

	@Override
	public boolean validarUsuario(String emailUsuario) {
		boolean encontrado = false;
		
		Usuario u = (Usuario)sessionFactory.getCurrentSession().createCriteria(Usuario.class).add(Restrictions.eq("email",emailUsuario)).uniqueResult();
		
		if(u != null) encontrado = true;
		
		return encontrado;
	}
	
	@Override
	public long buscarUsuario_ConEmail(String emailUsuario) {
		Usuario u = (Usuario) sessionFactory.getCurrentSession().createCriteria(Usuario.class)
				.add(Restrictions.eq("email", emailUsuario)).uniqueResult();
		return u.getId();
	}
	
	
	
		
}
