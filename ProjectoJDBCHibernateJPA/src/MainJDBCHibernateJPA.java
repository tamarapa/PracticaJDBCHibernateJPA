import jdbc.DAO.EmpleadoJDBCDAO;
import jdbc.DTO.EmpleadoDTO;
import jpa.EmpleadoJPADAO;
import jpa.Employee;
import hibernate.DAO.EmployeesHibernateDAO;
import hibernate.DAO.IRecuperable;
import hibernate.DTO.Employees;
import hibernate.service.SessionManager;



public class MainJDBCHibernateJPA {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EmployeesService employeesService = new EmployeesService();
		
		IRecuperable i_hibernate = new EmployeesHibernateDAO();		
		employeesService.setRecuperable(i_hibernate);
		System.out.println("HIBERNATE: "+((Employees) employeesService.obtenerEmpleado(100)).getFirstName());	
		
		IRecuperable i_jdbc = new EmpleadoJDBCDAO();
		employeesService.setRecuperable(i_jdbc);
		System.out.println("JDBC: "+((EmpleadoDTO) employeesService.obtenerEmpleado(100)).getFirst_name());
		
		
		IRecuperable i_jpa = new EmpleadoJPADAO();
		employeesService.setRecuperable(i_jpa);
		System.out.println("JPA: "+((Employee) employeesService.obtenerEmpleado(100)).getFirstName());
		
		SessionManager.getSessionFactory().close();
	}

}
