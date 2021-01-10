package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ec.edu.ups.entidad.Producto;

@Stateless
public class ProductFacade extends AbstractFacade<Producto> {

    @PersistenceContext(unitName = "Prueba")
    private EntityManager em;
    
    public ProductFacade() {
	super(Producto.class);
    }    

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
