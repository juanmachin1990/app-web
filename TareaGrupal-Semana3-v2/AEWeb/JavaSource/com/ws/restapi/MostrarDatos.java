package com.ws.restapi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.json.JsonValue.ValueType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.*;

import com.capa3Persistencia.dao.UsuariosPDTDAO;
import com.capa3Persistencia.entities.UsuarioPDT;

/**
 * Servlet implementation class CargarDatos
 */
@WebServlet("/MostrarDatos")
public class MostrarDatos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	UsuariosPDTDAO usuariosPDTDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MostrarDatos() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath()+"\n");
		PrintWriter out = response.getWriter();
		try {
			List<UsuarioPDT> listaUsuarios = usuariosPDTDAO.buscarUsuarios();
			for(UsuarioPDT u: listaUsuarios ) {
				//out.println("Usuario:"+ u.getId()+ " Nombre de usuario:" + u.getNombreUsuario() );

				JSONObject jsonObj = new JSONObject();

				jsonObj.put("nombre", u.getNombre());
				jsonObj.put("apellido", u.getApellido());
				jsonObj.put("nombre_usuario", u.getNombreUsuario());
				jsonObj.put("contrasena", u.getContrasena());
				jsonObj.put("mail", u.getMail());
				jsonObj.put("tipo_usuario", u.getTipoUsuario());
				// Generar cadena de texto JSON
				out.print(jsonObj);
				
			}
			

		}catch(Exception e) {
			out.println("Se generó un error al mostrar el JSON:"+ e.getClass().getSimpleName()+"-"+e.getMessage());
		}



	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
