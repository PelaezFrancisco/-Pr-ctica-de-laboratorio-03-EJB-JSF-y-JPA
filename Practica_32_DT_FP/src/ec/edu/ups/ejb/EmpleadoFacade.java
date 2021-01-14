package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import ec.edu.ups.entidad.Empleados;

@Stateless
public class EmpleadoFacade extends AbstractFacade<Empleados>{
	
	@PersistenceContext(unitName = "Prueba")
    private EntityManager em;
	
	public EmpleadoFacade() {
		super(Empleados.class);
		// TODO Auto-generated constructor stub
	}

	

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Empleados buscarEmp (String email, String contrasena) {
		try {
			String jpql = "SELECT emp FROM Empleados emp WHERE emp.email='" + email + "'"+"  AND  emp.password='"+contrasena+"'";
			Empleados empleado = (Empleados) em.createQuery(jpql).getSingleResult();
			return empleado;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	

}
