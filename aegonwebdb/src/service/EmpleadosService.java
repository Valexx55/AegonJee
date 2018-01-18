package service;

import java.util.List;

import basedatos.EmpleadoDAO;
import dto.EmpleadoDTO;
import oracle.net.aso.l;

public class EmpleadosService {
	
	private EmpleadoDAO edao;
	
	public List<EmpleadoDTO> obtenerEmpleados ()
	{
		List<EmpleadoDTO> lista_empleados = null;
		
			edao = new EmpleadoDAO();
			lista_empleados = edao.getEmpleados();
		
		return lista_empleados;
		
	}

}
