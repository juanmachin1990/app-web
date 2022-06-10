package ejercicio;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidarServlet
 */
@WebServlet(name = "Validar", urlPatterns = { "/Validar" })
public class ValidarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static String errorMessage = "";
    public static Long id = Long.valueOf(0);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/plain");
		    response.setCharacterEncoding("UTF-8");

		
		String name=request.getParameter("name");
		String age=request.getParameter("age");
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");
		request.setAttribute("errorMessage","");
		if (!name.equals("")&&name!=null) {
			errorMessage=" ";
			//Encontró un nombre en el campo name
			Persona persona=new Persona(name,age,address,phone);
			//salvamos en el Request scope
			request.setAttribute("persona", persona);
			request.setAttribute("identificador", id);
			request.setAttribute("errorMessage", errorMessage);
			System.out.println(request.getAttribute("identificador"));
			//después de asignarle la id a la persona, le sumamos 1 al contador global de id
			id=Long.valueOf(id.longValue()+1);
			RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
			
			
			rd.forward(request, response);
			//se loguea ok
			
			
		}else {
			//va de vuelta para index.jsp por errores
			errorMessage="El nombre no puede estar vacío";
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			//agrego en el request un nuevo objeto (String)
			request.setAttribute("errorMessage",errorMessage);
            rd.forward(request, response);
		}
		
	}

}
