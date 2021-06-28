package co.edu.ufps.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.ufps.dao.GenericDao;
import co.edu.ufps.dao.RolDao;
import co.edu.ufps.dao.UsuarioDao;
import co.edu.ufps.entities.Rol;
import co.edu.ufps.entities.Usuario;



@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private GenericDao newU;
	private GenericDao newR;
	
    public UsuarioServlet() {
        super();
    }

    public void init(ServletConfig config) throws ServletException {
		this.newU = new UsuarioDao();
		this.newR = new RolDao();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action = request.getParameter("action");
		
		System.out.println(action);

		try {
			switch (action) {
			case "new":
				showNewForm(request, response);
				break;
			case "insert":
				insert(request, response);
				break;
			/*case "delete":
				delete(request, response);
				break;
			case "edit":
				showEditForm(request, response);
				break;
			case "update":
				update(request, response);
				break;
			case "newL":
				showLogin(request, response);
				break;
			case "login":
				login(request, response);
				break;*/
			default:
				list(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void showNewForm(HttpServletRequest request,HttpServletResponse response ) throws ServletException, IOException{

		List<Rol> listaRol = newR.list();
		request.setAttribute("listaRol", listaRol);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("usuario/indexP.jsp");
		dispatcher.forward(request,response);
	}

	private void insert(HttpServletRequest request,HttpServletResponse response ) throws ServletException, SQLException, IOException{
		
		String usuario =  request.getParameter("usuario");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		int idR = Integer.parseInt(request.getParameter("rol"));
		Rol  rol = (Rol) newR.find(idR);
		
		//short state = Short.parseShort(request.getParameter("state"));

		Usuario user = new Usuario (usuario, email, pass, 0, rol);	
		
		
		newU.insert(user);		
		this.list(request, response);
	}
	
	private void list(HttpServletRequest request,HttpServletResponse response ) throws ServletException, SQLException, IOException{
		
		List<Usuario> listPer  = newU.list();
		request.setAttribute( "listPer", listPer);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("usuario/listP.jsp");
		dispatcher.forward(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
