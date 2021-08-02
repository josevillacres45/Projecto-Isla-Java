package modelo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Entity
@Table(name = "tabla_islas")
public class Isla {
	private String nombre;
	private BigDecimal precio;
	private String pais;
	private Integer telefono;
	private String email;
	private Integer metros_cuadrados;
	private String descripcion;
	private int numeroFotos;
	@Id
	@GeneratedValue
	private long id;
	@Transient
	private CommonsMultipartFile portada;
	@ManyToOne(cascade = { CascadeType.MERGE }, targetEntity = Usuario.class, optional = false, fetch = FetchType.EAGER)
	private Usuario usuario;
	
	// relacion con las categorias;
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
	@JoinTable(name="categorias_islas",
			   joinColumns = {
					   @JoinColumn(name="isla_id",nullable = false,updatable = false)
			   },
			   inverseJoinColumns = {
					   @JoinColumn(name="categoria_id",nullable = false,updatable = false)
			   })
	private List<Categorias>categorias = new ArrayList<Categorias>();
	
	
	public Isla() {
		super();
	}

	public Isla(String nombre, BigDecimal precio, String pais, Integer telefono, String email) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.pais = pais;
		this.telefono = telefono;
		this.email = email;
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getMetros_cuadrados() {
		return metros_cuadrados;
	}

	public void setMetros_cuadrados(Integer metros_cuadrados) {
		this.metros_cuadrados = metros_cuadrados;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public CommonsMultipartFile getPortada() {
		return portada;
	}

	public void setPortada(CommonsMultipartFile portada) {
		this.portada = portada;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	

	public int getNumeroFotos() {
		return numeroFotos;
	}

	public void setNumeroFotos(int numeroFotos) {
		this.numeroFotos = numeroFotos;
	}
	

	public List<Categorias> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categorias> categorias) {
		this.categorias = categorias;
	}

	@Override
	public String toString() {
		return "Isla [nombre=" + nombre + ", precio=" + precio + ", pais=" + pais + ", telefono=" + telefono
				+ ", email=" + email + ", id=" + id + "]";
	}

}
