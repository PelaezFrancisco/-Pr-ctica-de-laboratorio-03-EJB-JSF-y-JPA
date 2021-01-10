package ec.edu.ups.entidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Categoria
 *
 */
@Entity
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String nombre;
    
    private String descripcion;
    
    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;
    
    @Transient
    private boolean editable;

    public Categoria() {

    }
    
    public Categoria(int id, String nombre, String descripcion, List<Producto> productos, boolean editable) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.productos = productos;
		this.editable = editable;
	}


	public int getId() {
	return id ;
    }

    public void setId(int id ) {
	this.id  = id ;
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
	
	public Categoria(String descripcion) {
		this.descripcion = descripcion;
    }
	
    public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
    }

    public List<Producto> getProductos() {
	return productos;
    }

    public void setProductos(List<Producto> productos) {
	this.productos = productos;
    }

    public boolean isEditable() {
	return editable;
    }

    public void setEditable(boolean editable) {
	this.editable = editable;
    }
}
