package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.BodegaFacade;
import ec.edu.ups.ejb.CategoriaFacade;
import ec.edu.ups.ejb.ProductoFacade;
import ec.edu.ups.entidad.Bodega;
import ec.edu.ups.entidad.Categoria;
import ec.edu.ups.entidad.Producto;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class ProductoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EJB
    private ProductoFacade ejbProductoFacade;
    
    @EJB
    private CategoriaFacade ejCategoriaFacade;
    
    @EJB
    private BodegaFacade ejBodegaFacade;
    
    private List<Producto> listaProductos;
    private List<Producto> listaProductoBodegas;
    private List<Categoria>listaCategorias;
    private List<Bodega> listaBodegas;
    
    
    private Categoria categoria;
    private Bodega bodega;
    
    private String nombre;
    private String descripcion;
    private String stock;
    private String precio;
    private String cat;
    private int id;
    
    private double precio1;
    private int stock1;
    
	public ProductoBean() {
		
	}
	
	@PostConstruct
	public void init() {
		//ejbCategoryFacade.create(new Category("Hola"));
		//ejbCategoryFacade.create(new Category("1211"));
		//listaProductos = new ArrayList<Producto>();
		//listaCategorias= new ArrayList<Categoria>();
		//listaBodegas = new ArrayList<Bodega>();
		
		//listaProductoBodegas= ejbProductoFacade.findAll();
		//listaProductos = ejbProductoFacade.findAll();
		//listaProductos = ejbProductoFacade.listaProductosInventario();
		//listaProductoBodegas =ejbProductoFacade.listaInventarioBodega(3);
	    }

	public Producto[] getListaProductos() {
		return listaProductos.toArray(new Producto[0]);
	}

	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
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

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public ProductoFacade getEjbProductoFacade() {
		return ejbProductoFacade;
	}

	public void setEjbProductoFacade(ProductoFacade ejbProductoFacade) {
		this.ejbProductoFacade = ejbProductoFacade;
	}

	public CategoriaFacade getEjCategoriaFacade() {
		return ejCategoriaFacade;
	}

	public void setEjCategoriaFacade(CategoriaFacade ejCategoriaFacade) {
		this.ejCategoriaFacade = ejCategoriaFacade;
	}

	public BodegaFacade getEjBodegaFacade() {
		return ejBodegaFacade;
	}

	public void setEjBodegaFacade(BodegaFacade ejBodegaFacade) {
		this.ejBodegaFacade = ejBodegaFacade;
	}

	public int getStock1() {
		return stock1;
	}

	public void setStock1(int stock1) {
		this.stock1 = stock1;
	}

	public double getPrecio1() {
		return precio1;
	}

	public void setPrecio1(double precio1) {
		this.precio1 = precio1;
	}

	
	public List<Categoria> getListaCategorias() {
		return listaCategorias;
	}

	public void setListaCategorias(List<Categoria> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}

	public List<Bodega> getListaBodegas() {
		return listaBodegas;
	}

	public void setListaBodegas(List<Bodega> listaBodegas) {
		this.listaBodegas = listaBodegas;
	}
	

	public List<Producto> getListaProductoBodegas() {
		return listaProductoBodegas;
	}

	public void setListaProductoBodegas(List<Producto> listaProductoBodegas) {
		this.listaProductoBodegas = listaProductoBodegas;
	}

	/*public String add() {
			int codigoB = Integer.valueOf(bod);
			bodega= ejBodegaFacade.buscarBodegaC(codigoB);
			System.out.println("La Bodega si existe");
			
			categoria = ejCategoriaFacade.buscarCategoria(cat);
			System.out.println("Si existe la categoria");
			
			precio1 = Double.parseDouble(precio);
			stock1 = Integer.valueOf(stock);
			System.out.println("|"+nombre+ "|"+"|"+descripcion+ "|"+"|"+stock1+ "|"+"|"+precio1+ "|"+"|"+bod+ "|"+"|"+cat+ "|");
			//ejbProductoFacade.create(new Producto(0,  this.descripcion,this.nombre, precio1, stock1, bodega, categoria));
			listaProductos=ejbProductoFacade.findAll();
		return null;
		
	}
	public String inventarioBodega(){
		
		bodega= ejBodegaFacade.buscarBodega(nombre);
		System.out.println("Bodega: "+nombre);
		
		id = bodega.getId();
		System.out.println("Id de bodega: "+ id);
		listaProductoBodegas = ejbProductoFacade.listaInventarioBodega(3);
		return null;
		
	}
	public String delete() {	
		Producto producto = ejbProductoFacade.buscarProducto(this.nombre);
		System.out.println("Nombre Producto"+ this.nombre);
		ejbProductoFacade.remove(producto);
		return null;
	    }*/
	
	
	
 
}