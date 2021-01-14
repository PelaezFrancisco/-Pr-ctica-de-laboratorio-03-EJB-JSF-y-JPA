package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidad.BodegaProducto;

@Stateless
public class BodegaProductoFacade extends AbstractFacade<BodegaProducto>{
	
	public BodegaProductoFacade() {
		super(BodegaProducto.class);
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "Prueba")
    private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
	
}
