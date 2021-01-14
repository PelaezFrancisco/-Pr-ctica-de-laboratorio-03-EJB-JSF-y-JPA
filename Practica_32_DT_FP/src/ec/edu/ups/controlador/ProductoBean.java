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
    
    
    private List<Producto> listaProductos;
    private List<Categoria>listaCategorias;
    
    private Producto producto;
    private Categoria categoria;
    
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
		listaProductos = new ArrayList<Producto>();
		listaCategorias = new ArrayList<Categoria>();
		listaProductos = ejbProductoFacade.findAll();
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


	public String add() {
		System.out.println("Nombre Categoria: "+ this.cat);
		try {
			Categoria categoria = ejCategoriaFacade.buscarCategoria(this.cat);
			System.out.println("El nombre de la Categoria Buscado: " +categoria.getNombre() +" El ID : "+ categoria.getId());
			stock1 = Integer.valueOf(this.stock);
			precio1 = Double.parseDouble(this.precio);
			
			System.out.println("|"+this.nombre+ "|"+"|"+this.descripcion+ "|"+"|"+stock1+ "|"+"|"+precio1+ "|"+"|"+this.cat+ "|");
			ejbProductoFacade.create(new Producto(0, this.descripcion, this.nombre, precio1, stock1,  categoria));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
	}
	/*
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
