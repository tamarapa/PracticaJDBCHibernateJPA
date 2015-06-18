package hibernate.DAO;


import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.DTO.Employees;
import hibernate.service.SessionManager;


public class EmployeesHibernateDAO extends SuperClassDAO implements IRecuperable {
	
	private final static Logger log = Logger.getLogger("logTami");

	public EmployeesHibernateDAO()
	{
		
	}

	@Override
	public Object leerEmpleado(int id) {
		// TODO Auto-generated method stub
		Employees e1 = null;
		log.trace("EmployeesService - obtenerEmpleado() - INICIO");
		Transaction transaction = null;
		Session s = SessionManager.obtenerSesionNueva();
		try 
    	{			
    		transaction = s.beginTransaction();
    		e1 = (Employees) s.get(Employees.class,id);
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    		transaction.rollback();//si algo ha ido mal, deshago la transacción
    		log.error("obtenerEmpleado");
    	}
    	finally 
    	{
    		SessionManager.cerrarSession(s);
    		log.trace("obtenerEmpleado() FIN");
    	}
		return e1;
	}
}
