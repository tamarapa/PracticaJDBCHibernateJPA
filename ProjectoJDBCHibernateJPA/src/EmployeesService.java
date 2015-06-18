import org.apache.log4j.Logger;

import hibernate.DAO.IRecuperable;


public class EmployeesService {
	IRecuperable eDAO = null;
	private final static Logger log = Logger.getLogger("logTami");
	
	public EmployeesService ()
	{			
		log.trace("EmployeesService - employeesService()");
	}
	
	public void setRecuperable (IRecuperable tipo_oDAO)
	{
		this.eDAO = tipo_oDAO;
	}
	
	public Object obtenerEmpleado(int id)
	{
		Object e = null;
		e = this.eDAO.leerEmpleado(id);
		return e;
	}
}
