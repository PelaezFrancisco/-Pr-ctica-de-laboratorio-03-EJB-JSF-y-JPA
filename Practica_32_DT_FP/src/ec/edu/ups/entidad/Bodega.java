package ec.edu.ups.entidad;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.*;

@Entity
public class Bodega implements  Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    private String direccion;
    
    @ManyToOne
<<<<<<< HEAD
	@JoinColumn(name = "cd_id")
=======
	@JoinColumn(name = "cd_id", nullable = false)
>>>>>>> 4f4b4652bba8ac632ce0fa3d9e566dc79591d92c
	private Ciudad ciudad;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bodega" )
    private ArrayList<Producto> productos;
    
	public Bodega() {
		super();
	}

	public Bodega(int id, String nombre, String direccion, Ciudad ciudad) {
		super();
		this.id = id;
		this.nombre = nombre;
<<<<<<< HEAD
		this.direccion = direccion;
=======
		this.direccion= direccion;
>>>>>>> 4f4b4652bba8ac632ce0fa3d9e566dc79591d92c
		this.ciudad = ciudad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	}

	public Ciudad getCuidad() {
		return ciudad;
	}

<<<<<<< HEAD
	public void setCuidad(Ciudad ciudad) {
		this.ciudad = ciudad;
=======
	public void setCuidad(Ciudad cuidad) {
		this.ciudad = cuidad;
>>>>>>> 4f4b4652bba8ac632ce0fa3d9e566dc79591d92c
	}
    
}
