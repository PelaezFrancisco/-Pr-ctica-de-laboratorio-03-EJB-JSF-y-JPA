package ec.edu.ups.entidad;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.*;

@Entity
public class Empleados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	private String cedula;
	private String nombre;
	private String apellido;
	private char rol;
	private String telefono;
	private String direccion;
	private String email;
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
	private ArrayList<FacturaCabecera> facturas;
	
	public Empleados() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Empleados(int id, String cedula, String nombre, String apellido, char rol, String telefono, String direccion,
			String email, String password) {
		super();
		this.id = id;
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.rol = rol;
		this.telefono = telefono;
		this.direccion = direccion;
		this.email = email;
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
	public char getRol() {
		return rol;
	}
	public void setRol(char rol) {
		this.rol = rol;
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
	
	

}
