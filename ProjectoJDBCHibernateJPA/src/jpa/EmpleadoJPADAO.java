package jpa;

import hibernate.DAO.IRecuperable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmpleadoJPADAO implements IRecuperable {
    public EmpleadoJPADAO() 
    {
    	
    }

    @Override
	public Object leerEmpleado(int id) {
		// TODO Auto-generated method stub
    	//long empId = 190;  // emp 190 - Timothy Gates
        Employee yo = null;
        Long id_l = new Long(id);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadPersonas");
        EntityManager em = emf.createEntityManager();
        try 
        {
        	em.getTransaction().begin();
        	yo = em.find(Employee.class, id_l);
        	em.getTransaction().commit();
        } 
        catch (Exception e) 
        {
        	e.printStackTrace();
        }
        finally {
        	em.close();
        	emf.close();
        	//System.exit(0);//no sé pporqué no acaba sólo...parace que se queda conlgando si no le pongo esto
        }
		return yo;
    }
}