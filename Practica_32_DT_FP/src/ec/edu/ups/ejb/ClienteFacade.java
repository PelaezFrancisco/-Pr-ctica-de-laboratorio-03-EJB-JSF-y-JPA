package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidad.Categoria;
import ec.edu.ups.entidad.Cliente;

@Stateless
public class ClienteFacade extends AbstractFacade<Cliente>{

	@PersistenceContext(unitName = "Prueba")
    private EntityManager em;
	
	public ClienteFacade() {
		super(Cliente.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
	/*
	 * Metodo para buscar cliente por cedula
	 * */
	public Cliente buscarCliente(String cedula) {
		try {
			String jpql = "SELECT cli FROM Cliente cli WHERE cli.cedula='" + cedula + "'";
			Cliente cliente = (Cliente) em.createQuery(jpql).getSingleResult();
			return cliente;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
