package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.EmpleadoFacade;
import ec.edu.ups.entidad.Empleados;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class EmpleadoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private EmpleadoFacade ejEmpleadoFacade;
    
    private List<Empleados> lista;
    
    private String email;
    private String pass;
    
	public EmpleadoBean() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	@PostConstruct
    public void init() {
		lista = new ArrayList<Empleados>();
		
	}

	public Empleados[] getLista() {
		return lista.toArray(new Empleados[0]);
	}

	public void setLista(List<Empleados> lista) {
		this.lista = lista;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String IniciarSesion() {
			String url =null;
			Empleados empleados= ejEmpleadoFacade.buscarEmp(this.email, this.pass);
			System.out.println("Nombre :" + empleados.getNombre()+ " Rol: "+ empleados.getRol());
			
			char rol = empleados.getRol();
			if (rol == 'A') {
				url= "/private/admin/Admin.xhtml";
			}else {
				if (rol == 'E') {
					url = "/private/emp/Empleado.xhtml";
				}else {
					if (rol == 'C') {
						url= "/private/user/Cliente.html";
					}else {
						url="/public/IniciarSesion.xhtml";
					}
				}
			}
			return url;
	}

}
