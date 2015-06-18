package jdbc.DAO;

import hibernate.DAO.IRecuperable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.Conexion;
import jdbc.DTO.EmpleadoDTO;

public class EmpleadoJDBCDAO implements IRecuperable {
	public EmpleadoDTO leerEmpleado(int id)
	{
		ResultSet rset = null;
		Statement stmt = null;		
		Connection conn = null;
		
		try {
			conn = Conexion.obtenerConexion();
			stmt = conn.createStatement();
			rset = stmt.executeQuery("SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID="+id);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		EmpleadoDTO e = null;
		try {
			rset.next();
			e = new EmpleadoDTO(
					rset.getInt(1),
					rset.getString(2),
					rset.getString(3),
					rset.getString(4),
					rset.getString(5),
					rset.getString(6),
					rset.getString(7),
					rset.getString(8),
					rset.getString(9),
					rset.getString(10),
					rset.getString(11));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		Conexion.liberarRecursos(conn, stmt, rset);
		return e;		
	}
}
