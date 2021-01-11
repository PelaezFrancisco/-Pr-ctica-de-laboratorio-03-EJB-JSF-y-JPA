package ec.edu.ups.entidad;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.*;

@Entity
public class Bodega implements  Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String nombre;
    private String descripcion;
    
    @ManyToOne
	@JoinColumn(name = "cd_id")
	private Ciudad cuidad;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bodega" )
    private ArrayList<Producto> productos;
    
	public Bodega() {
		super();
	}

	public Bodega(int id, String nombre, String descripcion, Ciudad cuidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.cuidad = cuidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public Ciudad getCuidad() {
		return cuidad;
	}

	public void setCuidad(Ciudad cuidad) {
		this.cuidad = cuidad;
	}
    
}
