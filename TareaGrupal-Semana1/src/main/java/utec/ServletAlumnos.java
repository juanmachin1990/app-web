package utec;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		String cedula = request.getParameter("cedula");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		
		
		StringBuilder strBuilder = new StringBuilder();
		
		strBuilder.append("<h2> Resultado </h2>");
		strBuilder.append("<p> El nombre es: " + nombre +  "</p>");
		strBuilder.append("<p> El apellido es: " + apellido +  "</p>");
		strBuilder.append("<p> La cedula es: " + cedula +  "</p>");
		
		String resp = strBuilder.toString();
		System.out.println("hola");
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
