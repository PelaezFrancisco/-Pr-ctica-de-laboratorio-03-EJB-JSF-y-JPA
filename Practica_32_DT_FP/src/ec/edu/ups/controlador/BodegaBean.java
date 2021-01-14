package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Default;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;
import javax.ws.rs.DefaultValue;

import ec.edu.ups.ejb.BodegaFacade;
import ec.edu.ups.ejb.CiudadFacade;
import ec.edu.ups.entidad.Bodega;
import ec.edu.ups.entidad.Categoria;
import ec.edu.ups.entidad.Ciudad;
import ec.edu.ups.entidad.Producto;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class BodegaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private BodegaFacade ejbBodegaFacade;
    
    @EJB
    private CiudadFacade ejbCiudadFacade;
    
    
    private List<Bodega> lista;
    private Bodega bodega;
    
    private Ciudad ciudad;
    private List<Ciudad> listaCiudad;
    
    private List<Producto>listaProductos;  
    private Producto producto;
    
    private String nombre;
    private String direccion;
    private String nombreCuidad;
    private int idCiudad;
    
    
    
	public BodegaBean() {
		
	}
	
	@PostConstruct
    public void init() {
		lista = new ArrayList<Bodega>();
		listaCiudad = new ArrayList<Ciudad>();
		lista = ejbBodegaFacade.findAll();
	
    }

	public Bodega[] getList() {
		return lista.toArray(new Bodega[0]);
	}

	public void setLista(List<Bodega> lista) {
		this.lista = lista;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}

	public List<Bodega> getLista() {
		return lista;
	}

	
	public String getNombreCuidad() {
		return nombreCuidad;
	}

	public void setNombreCuidad(String nombreCuidad) {
		this.nombreCuidad = nombreCuidad;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	
	
	public String add() {
		System.out.println("Nombre: "+this.nombre);
		try {
			
			Ciudad ciudad= ejbCiudadFacade.buscarNombre(this.nombreCuidad);
			System.out.println("El nombre de la ciudad es: "+ciudad.getNombre() + " Id: "+ciudad.getId());
			ejbBodegaFacade.create(new Bodega(0, this.direccion, this.nombre,ciudad));	
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public String delete() {
		Bodega bodega = ejbBodegaFacade.buscarBodega(this.nombre);
		System.out.println("Nombre de la Bodega: "+bodega.getNombre());
		ejbBodegaFacade.remove(bodega);
		
		return null;
	    }
	
}
