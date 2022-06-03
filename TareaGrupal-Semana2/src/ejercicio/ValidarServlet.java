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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String age=request.getParameter("age");
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");
		request.setAttribute("errorMessage","");
		if (!name.equals("")&&name!=null) {
			errorMessage=" ";
			request.setAttribute("name", name);
			request.setAttribute("age", age);
			request.setAttribute("address", address);
			request.setAttribute("phone", phone);

			request.setAttribute("errorMessage", errorMessage);
			//después de asignarle la id a la persona, le sumamos 1 al contador global de id
			RequestDispatcher rd = request.getRequestDispatcher("ingresar");
			
			
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
