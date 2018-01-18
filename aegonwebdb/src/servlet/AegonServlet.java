package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basedatos.Pool;
import dto.EmpleadoDTO;
import edu.femxa.val.imc.IMC;
import edu.femxa.val.imc.Persona;
import edu.femxa.val.imc.TipoIMC;
import service.EmpleadosService;

/**
 * Servlet implementation class AegonServlet
 */
@WebServlet("/AegonServlet")
public class AegonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AegonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    //	http://localhost/aegonweb/AegonServlet?empresa=AEGON
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    /*
     * 
     * https://www.google.es/search?q=aegon&oq=aegon&aqs=chrome..69i57j69i60l3j0l2.1402j0j7&sourceid=chrome&ie=UTF-8
     * 
     * (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
	protected void doGet
	(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println();
		EmpleadosService es = new EmpleadosService();
		List<EmpleadoDTO> le = es.obtenerEmpleados();
		EmpleadoDTO empleado = le.get(0);
		request.setAttribute("empleado", empleado);
		request.getRequestDispatcher("listaempleados.jsp").forward(request, response);
		
		/*String empresa = request.getParameter("empresa");
		System.out.println(empresa);
		System.out.println("Llamó a GET");
		
		
		Persona p = new Persona(80, 1.80);
		double imc = IMC.calcula(p);
		System.out.println("IMC es = " + imc);
		
		PrintWriter pw = response.getWriter(); //append("Served at: ").append(request.getContextPath());
		pw.write("El cocido estaba bien rico " + empresa);
	*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//System.out.println();
		System.out.println("PESO = " +request.getParameter("peso"));
		System.out.println("ESTATURA = " +request.getParameter("estatura"));
		String peso = request.getParameter("peso");
		String estatura = request.getParameter("estatura");
		//HASTA AQUÍ, EL CONTROLADOR, AHORA EL MODELO
		double imc = IMC.calcula(new Persona(Double.parseDouble(peso), Double.parseDouble(estatura)));
		//fin del modelo
		//hago la vista
		PrintWriter pw = response.getWriter();
		pw.write("SU IMC es "+imc);
		//fin
		
	}

}
