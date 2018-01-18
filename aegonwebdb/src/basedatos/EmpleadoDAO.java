package basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.EmpleadoDTO;

public class EmpleadoDAO {
	
	
	
	public List<EmpleadoDTO> getEmpleados ()
	{
		List<EmpleadoDTO> l_emp = null;
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = Pool.getConnection();//DriverManager.getConnection(CADENA_CONEXION, USER, PASSWORD);
			statement = connection.createStatement();
			resultSet = statement.executeQuery("Select first_name from employees");
		
			l_emp = new ArrayList<EmpleadoDTO>();
			String nom_aux = null;
			EmpleadoDTO empDto = null;
			while (resultSet.next())
			{
				nom_aux = resultSet.getString("first_name");
				empDto = new EmpleadoDTO(nom_aux);
				l_emp.add(empDto);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally 
		{
			Pool.liberarRecursos(connection, statement, resultSet);
		}

		
		return l_emp;
	}

}
