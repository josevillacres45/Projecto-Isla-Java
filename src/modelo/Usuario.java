package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="tabla_usuarios")
public class Usuario {
	private String nombre;
	private String email;
	private String password;
	@OneToMany(cascade = {CascadeType.ALL}, mappedBy = "usuario" , fetch = FetchType.LAZY)
	private List<Isla> islasUsuario = new ArrayList<Isla>();
	@Id
	@GeneratedValue
	private long id;
	
	public Usuario() {
		super();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<Isla> getIslasUsuario() {
		return islasUsuario;
	}
	public void setIslasUsuario(List<Isla> islasUsuario) {
		this.islasUsuario = islasUsuario;
	}
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", email=" + email + ", password=" + password + ", id=" + id + "]";
	}
	
	
	
	
}
