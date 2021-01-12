package ec.edu.ups.entidad;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Producto
 *
 */
@Entity
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String descripcion;
	private int stock;
	private double precio;
	//private String pro_imagen;
	
	@ManyToOne
	@JoinColumn(name = "cat_id", nullable = false)
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name = "bod_id", nullable = false)
	private Bodega bodega;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "productos" )
	private ArrayList<FacturaDetalle> facturaDet; 

	
	public Producto() {

	}
    
	public Producto(int id, String descripcion, String nombre,  double precio, int stock , Bodega bodega, Categoria categoria) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.bodega= bodega;
		this.categoria = categoria;
		this.bodega = bodega;
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

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	public Bodega getBodega() {
		return bodega;
	}


	public void setBodega(Bodega bodega) {
		this.bodega = bodega;
	}


	public ArrayList<FacturaDetalle> getFacturaDet() {
		return facturaDet;
	}


	public void setFacturaDet(ArrayList<FacturaDetalle> facturaDet) {
		this.facturaDet = facturaDet;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
 
}
