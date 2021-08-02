package mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import modelo.Isla;

public class IslaMapperCompleto implements RowMapper<Isla>{

	@Override
	public Isla mapRow(ResultSet rs, int numeroDeFilas) throws SQLException {
		Isla islaBuscada=new Isla();
		islaBuscada.setNombre(rs.getString("nombre"));
		islaBuscada.setPrecio(rs.getBigDecimal("precio"));
		islaBuscada.setPais(rs.getString("pais"));
		islaBuscada.setTelefono(rs.getInt("telefono"));
		islaBuscada.setEmail(rs.getString("email"));
		islaBuscada.setMetros_cuadrados(rs.getInt("metros_cuadrados"));
		islaBuscada.setDescripcion(rs.getString("descripcion"));
		islaBuscada.setId(rs.getLong("id"));
		return islaBuscada;
	}
	
}
