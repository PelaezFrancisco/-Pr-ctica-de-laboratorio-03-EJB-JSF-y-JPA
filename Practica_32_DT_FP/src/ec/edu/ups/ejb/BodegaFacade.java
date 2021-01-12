package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidad.Bodega;

@Stateless
public class BodegaFacade extends AbstractFacade<Bodega>{
	
	@PersistenceContext(unitName = "Prueba")
    private EntityManager em; 
	
	public BodegaFacade() {
		super(Bodega.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	

}
