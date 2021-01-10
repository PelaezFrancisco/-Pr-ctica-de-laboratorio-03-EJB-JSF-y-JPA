package ec.edu.ups.entidad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Cuidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    private String nombre;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuidad" )
    private ArrayList<Bodega>bodega;
    
	public Cuidad() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cuidad(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
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
	public ArrayList<Bodega> getBodega() {
		return bodega;
	}

	public void setBodega(ArrayList<Bodega> bodega) {
		this.bodega = bodega;
	}
  

}
