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
	private String telefono;
	private String direccion;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
	private ArrayList<FacturaCabecera> facturas;


	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(int id, String cedula, String nombre, String apellido, String telefono, String direccion) {
		super();
		this.id = id;
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.direccion = direccion;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
}
