package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import org.jboss.weld.context.ejb.Ejb;

import ec.edu.ups.ejb.BodegaFacade;
import ec.edu.ups.ejb.BodegaProductoFacade;
import ec.edu.ups.ejb.ProductoFacade;
import ec.edu.ups.entidad.Bodega;
import ec.edu.ups.entidad.BodegaProducto;
import ec.edu.ups.entidad.Ciudad;
import ec.edu.ups.entidad.Producto;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class BodegaProductoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private BodegaProductoFacade ejBodegaProductoFacade;
    
    @EJB
    private BodegaFacade ejBodegaFacade;
    
    @EJB
    private ProductoFacade ejProductoFacade;
    
    private List<BodegaProducto> listaBodPro;
    private BodegaProducto bodegaProducto;
    
    private List<Producto>listaProductos;  
    private Producto producto;
    
    private List<Bodega> listaBodegas;
    private Bodega bodega;
    
   private String nombrePro;
   private String nombreBodega;
   private String stock;
   
   private int stock1;
   
   public BodegaProductoBean() {
	super();
	// TODO Auto-generated constructor stub
   }
   
   @PostConstruct
   public void init() {
		listaBodPro = new ArrayList<BodegaProducto>();
		listaBodegas= new ArrayList<Bodega>();
		listaProductos = new ArrayList<Producto>();
		listaBodPro = ejBodegaProductoFacade.findAll();
	
   }

	public BodegaProducto[] getListaBodPro() {
		return listaBodPro.toArray(new BodegaProducto[0]);
	}
	
	public void setListaBodPro(List<BodegaProducto> listaBodPro) {
		this.listaBodPro = listaBodPro;
	}
	
	public BodegaProducto getBodegaProducto() {
		return bodegaProducto;
	}
	
	public void setBodegaProducto(BodegaProducto bodegaProducto) {
		this.bodegaProducto = bodegaProducto;
	}
	
	public List<Producto> getListaProductos() {
		return listaProductos;
	}
	
	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}
	
	public Producto getProducto() {
		return producto;
	}
	
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public List<Bodega> getListaBodegas() {
		return listaBodegas;
	}
	
	public void setListaBodegas(List<Bodega> listaBodegas) {
		this.listaBodegas = listaBodegas;
	}
	
	public Bodega getBodega() {
		return bodega;
	}
	
	public void setBodega(Bodega bodega) {
		this.bodega = bodega;
	}
	
	public String getNombrePro() {
		return nombrePro;
	}
	
	public void setNombrePro(String nombrePro) {
		this.nombrePro = nombrePro;
	}
	
	public String getNombreBodega() {
		return nombreBodega;
	}
	
	public void setNombreBodega(String nombreBodega) {
		this.nombreBodega = nombreBodega;
	}
	
	public String getStock() {
		return stock;
	}
	
	public void setStock(String stock) {
		this.stock = stock;
	}
	
	public int getStock1() {
		return stock1;
	}
	
	public void setStock1(int stock1) {
		this.stock1 = stock1;
	}
	
	public String add() {
		System.out.println("Producto: "+this.nombrePro+ "| Bodega: "+ this.nombreBodega+ "| Stock"+ this.stock);
		try {
		
			Bodega bodega = ejBodegaFacade.buscarBodega(this.nombreBodega);
			System.out.println("La bodega encontra es :"+bodega.getNombre()+ "| ID: "+bodega.getId());
			
			Producto producto = ejProductoFacade.buscarProducto(this.nombrePro);
			System.out.println("El Producto encontrado es: "+ producto.getNombre()+ "| ID: "+producto.getId());
			
			stock1 = Integer.valueOf(stock);
			ejBodegaProductoFacade.create(new BodegaProducto(0, stock1, bodega, producto));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
   
   
   
   
   

}
