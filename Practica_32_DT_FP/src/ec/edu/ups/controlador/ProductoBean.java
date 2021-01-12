package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.CiudadFacade;
import ec.edu.ups.ejb.ProductFacade;
import ec.edu.ups.entidad.Bodega;
import ec.edu.ups.entidad.Categoria;
import ec.edu.ups.entidad.Producto;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class ProductoBean {

	private static final long serialVersionUID = 1L;
	@EJB
	private ProductFacade ejbproductFacade;
	
	private List<Producto> lista;
	private String nombre;
	private String descripcion;
	private Double precio;
	private int stock;
	private Bodega bodega;
	private Categoria categoria;

	public ProductoBean() {
		
	}
	
	@PostConstruct
	public void init() {
		lista = ejbproductFacade.findAll();
	}
	
	public String add() {
		ejbproductFacade.create(new Producto(0, this.descripcion,this.nombre,this.precio,this.stock,this.bodega,this.categoria));
		lista = ejbproductFacade.findAll();
		return null;
	}

	public Producto[] getLista() {
		return lista.toArray(new Producto[0]);
	}

	public void setLista(List<Producto> lista) {
		this.lista = lista;
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

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Bodega getBodega() {
		return bodega;
	}

	public void setBodega(Bodega bodega) {
		this.bodega = bodega;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	

	
	
}
