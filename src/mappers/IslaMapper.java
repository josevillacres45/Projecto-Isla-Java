package mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import modelo.Isla;

public class IslaMapper implements RowMapper<Isla>{
	//los mappers son como constructores
	@Override
	public Isla mapRow(ResultSet rs, int numeroFilas) throws SQLException {
		Isla islaNueva=new Isla();
		islaNueva.setNombre(rs.getString("nombre"));
		islaNueva.setPrecio(rs.getBigDecimal("precio"));
		islaNueva.setPais(rs.getString("pais"));
		islaNueva.setTelefono(rs.getInt("telefono"));
		islaNueva.setEmail(rs.getString("email"));
		islaNueva.setId(rs.getLong("id"));
		return islaNueva;
	}

}
