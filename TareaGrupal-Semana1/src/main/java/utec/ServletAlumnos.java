package utec;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.utec.alumnos.BuscarAlumnos;
import org.utec.alumnos.Alumno;

/**
 * Servlet implementation class ServletAlumnos
 */
@WebServlet("/buscar")
public class ServletAlumnos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAlumnos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BuscarAlumnos buscarAlumnos = new BuscarAlumnos();
		Alumno alumno = new Alumno();
		
		String cedula = request.getParameter("cedula");
		Integer ci = new Integer(cedula);
		
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		
		Alumno a1 = new Alumno();
		
		a1=buscarAlumnos.buscarAlumno(nombre, apellido, ci);
		
		System.out.println(a1.toString());
		StringBuilder strBuilder = new StringBuilder();
		
		strBuilder.append("<h2> Resultado </h2>");
		strBuilder.append("<p> El nombre es: " + a1.getNombre() +  "</p>");
		strBuilder.append("<p> El apellido es: " + a1.getApellido() +  "</p>");
		strBuilder.append("<p> La cedula es: " + a1.getCi() +  "</p>");
		
		String resp = strBuilder.toString();
		System.out.println(a1);
		response.setContentType("text/html");
		// TODO Auto-generated method stub
		
		response.getWriter().append(resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
