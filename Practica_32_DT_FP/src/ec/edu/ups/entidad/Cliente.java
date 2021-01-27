package ec.edu.ups.entidad;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.*;

@Entity
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	private String cedula;
	private String nombre;
	private String apellido;
	private String email;
	private String username;
	private String password;
	private String telefono;
	private String direccion;
	private char estado;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
	private ArrayList<FacturaCabecera> facturas;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
	private ArrayList<Pedido_Cabecera> pedidos;


	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Cliente(int id, String cedula, String nombre, String apellido, String email, String username,
			String password, String telefono, String direccion, char estado) {
		super();
		this.id = id;
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.username = username;
		this.password = password;
		this.telefono = telefono;
		this.direccion = direccion;
		this.estado = estado;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public ArrayList<FacturaCabecera> getFacturas() {
		return facturas;
	}

	public void setFacturas(ArrayList<FacturaCabecera> facturas) {
		this.facturas = facturas;
	}

	
	public ArrayList<Pedido_Cabecera> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<Pedido_Cabecera> pedidos) {
		this.pedidos = pedidos;
	}
	public char getEstado() {
		return estado;
	}
	public void setEstado(char estado) {
		this.estado = estado;
	}
	
}
