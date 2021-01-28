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
import ec.edu.ups.ejb.PedidoCabeceraFacade;
import ec.edu.ups.ejb.PedidoDetalleFacade;
import ec.edu.ups.ejb.ProductoFacade;
import ec.edu.ups.entidad.Empleados;
import ec.edu.ups.entidad.Pedido_Cabecera;
import ec.edu.ups.entidad.Pedido_Detalle;
import ec.edu.ups.entidad.Producto;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class PedidoDetalleBean implements Serializable {

private static final long serialVersionUID = 1L;
    
    @EJB
    private ProductoFacade ejbProductoFacade;
    
    @EJB
    private PedidoCabeceraFacade ejbPedCabFacade;
    
    @EJB
    private PedidoDetalleFacade ejbPedDetFacade;
    
    @EJB
    private EmpleadoFacade ejbEmpleadoFacade;
    
    
    private List<Producto> listaProductos;
    private List<Pedido_Detalle> listaPedDet;
    private List<Empleados> listaEmpleados;
    
    private List<Pedido_Detalle> listaPD;
    
    private int num_detalle;
    private int cantidad;
    
    private Producto producto;
    private Pedido_Cabecera pedCabecera;
    private Empleados empleado;
    
    
    
    public PedidoDetalleBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
    public void init() {
    	listaPedDet = new ArrayList<Pedido_Detalle>();
    	listaPedDet = ejbPedDetFacade.findAll();
    	
    }

	public ProductoFacade getEjbProductoFacade() {
		return ejbProductoFacade;
	}

	public void setEjbProductoFacade(ProductoFacade ejbProductoFacade) {
		this.ejbProductoFacade = ejbProductoFacade;
	}

	public PedidoCabeceraFacade getEjbPedCabFacade() {
		return ejbPedCabFacade;
	}

	public void setEjbPedCabFacade(PedidoCabeceraFacade ejbPedCabFacade) {
		this.ejbPedCabFacade = ejbPedCabFacade;
	}

	public PedidoDetalleFacade getEjbPedDetFacade() {
		return ejbPedDetFacade;
	}

	public void setEjbPedDetFacade(PedidoDetalleFacade ejbPedDetFacade) {
		this.ejbPedDetFacade = ejbPedDetFacade;
	}

	public EmpleadoFacade getEjbEmpleadoFacade() {
		return ejbEmpleadoFacade;
	}

	public void setEjbEmpleadoFacade(EmpleadoFacade ejbEmpleadoFacade) {
		this.ejbEmpleadoFacade = ejbEmpleadoFacade;
	}

	public List<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public Pedido_Detalle[] getListaPedDet() {
		return listaPedDet.toArray(new Pedido_Detalle[0]);
	}

	public void setListaPedDet(List<Pedido_Detalle> listaPedDet) {
		this.listaPedDet = listaPedDet;
	}

	public List<Empleados> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(List<Empleados> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	public int getNum_detalle() {
		return num_detalle;
	}

	public void setNum_detalle(int num_detalle) {
		this.num_detalle = num_detalle;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Pedido_Cabecera getPedCabecera() {
		return pedCabecera;
	}

	public void setPedCabecera(Pedido_Cabecera pedCabecera) {
		this.pedCabecera = pedCabecera;
	}
	
    public Empleados getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleados empleado) {
		this.empleado = empleado;
	}

	
	public List<Pedido_Detalle> getListaPD() {
		return listaPD;
	}

	public void setListaPD(List<Pedido_Detalle> listaPD) {
		this.listaPD = listaPD;
	}

	public String aux_add_detalle(int id) {
    	
		System.out.println("Id de producto entrante="+id);
		System.out.println("Cantidad del producto="+cantidad);
		//Recopilamos el producto
		producto = ejbProductoFacade.find(id);
		Pedido_Detalle p = new Pedido_Detalle();
		p.setCantidad(cantidad);
		p.setNum_detalle(id);
		p.setProductos(producto);
		
		listaPedDet.add(p);
    	return null;
    }
    
    public String makePedido(int id) {
    		System.out.println("Id del cliente"+id);
    		empleado = ejbEmpleadoFacade.findEmp(id);
    		Pedido_Cabecera pc = new Pedido_Cabecera();
    		pc.setEstado('Y');
    		pc.setEmpleado(empleado);
    		pc.setEmpleado(empleado);
    		
    		//Creamos el pedido cabecera en db
    		ejbPedCabFacade.create(pc);
    		
    		//creamos la lista de pedidos detalles
    		for (int i = 0; i < listaPedDet.size(); i++) {
				listaPedDet.get(i).setPedidoCab(pc);
				ejbPedDetFacade.create(listaPedDet.get(i));
			}
    		
    	return null;
    }
    
    public String detalles(int num_cabecera) {
    	System.out.println("Id del PedidoCabecera " + num_cabecera);
    	//listaPD=ejbPedDetFacade.buscarDetalle(num_cabecera);
    	//System.out.println("Tamaño de la lista por busqueda" + listaPedDet.size());
    	return "listarPedidosDetalle.xhtml";
    }
    
}
