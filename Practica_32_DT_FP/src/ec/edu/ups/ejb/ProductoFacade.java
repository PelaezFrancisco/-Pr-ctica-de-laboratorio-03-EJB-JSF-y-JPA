package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidad.Bodega;
import ec.edu.ups.entidad.Producto;

@Stateless
public class ProductoFacade extends AbstractFacade<Producto>{

	@PersistenceContext(unitName = "Prueba")
    private EntityManager em;

	
	public ProductoFacade() {
		super(Producto.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	/*
	public List<Producto>listaProductosInventario(){
		String jpql = "SELECT pro FROM Producto pro ORDER BY pro.nombre ASC";
		List<Producto> productos = em.createQuery(jpql).getResultList();
		return productos;
		
	}
	public List<Producto>listaInventarioBodega(int id){
		String jpql = "SELECT pro FROM Producto pro WHERE pro.bod_id=3";
		List<Producto> productos = em.createQuery(jpql).getResultList();
		return productos;
	}
	public Producto buscarProducto(String nombre) {
		try {
			String jpql = "SELECT pro FROM Producto pro WHERE pro.nombre='" + nombre + "'";
			Producto pro = (Producto) em.createQuery(jpql).getSingleResult();
			return pro;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}*/
	
}
