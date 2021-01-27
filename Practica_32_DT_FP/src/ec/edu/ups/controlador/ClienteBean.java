package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.ClienteFacade;
import ec.edu.ups.entidad.Cliente;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class ClienteBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ClienteFacade ejbClienteFacade;
	
	private List<Cliente> listaClientes;
	
	private Cliente cliente;
	
	private int id;
	private String apellido;
	private String cedula;
	private String direccion;
	private String nombre;
	private String telefono;
	
	public ClienteBean() {
		
	}
	
	@PostConstruct
	public void init() {
		listaClientes = new ArrayList<Cliente>();
		listaClientes = ejbClienteFacade.findAll();
		
	}

	public ClienteFacade getEjbClienteFacade() {
		return ejbClienteFacade;
	}

	public void setEjbClienteFacade(ClienteFacade ejbClienteFacade) {
		this.ejbClienteFacade = ejbClienteFacade;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	/*
	 * Metodo para buscar cliente por cedula
	 * */
	public String editarCliente() {
		System.out.println("Hola");
		System.out.println("Cedula a buscar="+this.cedula);
		try {
			cliente = new Cliente();
			cliente = ejbClienteFacade.buscarCliente(this.cedula);
			if (cliente!=null) {
				cliente.setNombre(this.nombre);
				cliente.setApellido(this.apellido);
				cliente.setDireccion(this.direccion);
				cliente.setTelefono(this.telefono);
				ejbClienteFacade.edit(cliente);
				return "Ediccion Exitosa";
			}else {
				return "No existe el cliente a editar";
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return "Error al editar cliente";
		}
		
	}
	
	public String buscarCliente() {
		try {
			cliente = new Cliente();
			cliente = ejbClienteFacade.buscarCliente(this.cedula);
			
		} catch (Exception e) {
		
		return null;
		}
		return null;
	}
	
	public String add() {
		try {
			cliente = new Cliente();
			cliente.setCedula(this.cedula);
			cliente.setApellido(this.apellido);
			cliente.setDireccion(this.direccion);
			cliente.setNombre(this.nombre);
			cliente.setTelefono(this.telefono);
			ejbClienteFacade.create(cliente);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return null;
	}

	

}
