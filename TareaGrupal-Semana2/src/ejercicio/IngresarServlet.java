package ejercicio;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IngresarServlet
 */
@WebServlet("/ingresar")
public class IngresarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Long id = Long.valueOf(0);
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IngresarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Encontró un nombre en el campo name
		String name=request.getParameter("name");
		String age=request.getParameter("age");
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");

		Persona persona=new Persona(name,age,address,phone);
		//salvamos en el Request scope
		request.setAttribute("persona", persona);
		request.setAttribute("identificador", id);
		id=Long.valueOf(id.longValue()+1);
		RequestDispatcher rd = request.getRequestDispatcher("/mostrarDato.jsp");
		
		
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
