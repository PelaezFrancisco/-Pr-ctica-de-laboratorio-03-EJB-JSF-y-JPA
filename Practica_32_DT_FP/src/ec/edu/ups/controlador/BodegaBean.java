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
import ec.edu.ups.entidad.Bodega;
import ec.edu.ups.entidad.Categoria;
import ec.edu.ups.entidad.Ciudad;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class BodegaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private BodegaFacade ejbBodegaFacade;
    
    private List<Bodega> lista;
    private String nombre;
    private String direccion;
    private Ciudad ciudad;
    
	public BodegaBean() {
		
	}
	
	@PostConstruct
    public void init() {
	//ejbCategoryFacade.create(new Category("Hola"));
	//ejbCategoryFacade.create(new Category("1211"));
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

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	
	public String add() {
		ejbBodegaFacade.create(new Bodega(0,this.nombre,this.direccion,this.ciudad));
		lista = ejbBodegaFacade.findAll();
		return null;
	}
	   

}
