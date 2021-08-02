package modelo;

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
import javax.persistence.Table;

@Entity
@Table(name = "tabla_categorias")
public class Categorias {
	private String nombre;
	private String descripcion;
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
	@JoinTable(name = "categorias_islas",
				joinColumns = {
					@JoinColumn(name="categoria_id",nullable = false,updatable = false)
				},
				inverseJoinColumns = {
					@JoinColumn(name ="isla_id",nullable = false,updatable = false)
				}
			)
	private List<Isla>islas=new ArrayList<Isla>();
	@Id
	@GeneratedValue
	private int id;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Isla> getIslas() {
		return islas;
	}

	public void setIslas(List<Isla> islas) {
		this.islas = islas;
	}
	
	
}
