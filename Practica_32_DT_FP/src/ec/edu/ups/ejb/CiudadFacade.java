package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ec.edu.ups.entidad.Ciudad;

@Stateless
public class CiudadFacade extends AbstractFacade<Ciudad> {

	@PersistenceContext(unitName = "Prueba")
    private EntityManager em;
	
	public CiudadFacade() {
		super(Ciudad.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected EntityManager getEntityManager() {
        return em;
    }

}
