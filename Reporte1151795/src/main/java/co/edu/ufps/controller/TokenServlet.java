package co.edu.ufps.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.ufps.dao.ConnectiontokenDao;
import co.edu.ufps.dao.GenericDao;
import co.edu.ufps.dao.TypedbDao;
import co.edu.ufps.dao.UsuarioDao;
import co.edu.ufps.entities.Connectiontoken;
import co.edu.ufps.entities.Typedb;
import co.edu.ufps.entities.Usuario;

@WebServlet("/TokenServlet")
public class TokenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private GenericDao newToken;
	private GenericDao newUsuario;
	private GenericDao newType;
	
    public TokenServlet() {
        super();
        this.newToken = new ConnectiontokenDao();
        this.newUsuario = new UsuarioDao();
        this.newType = new TypedbDao();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		System.out.println(action);

		try {
			switch (action) {
			case "insert":
				insert(request, response);
				break;
			default:
				list(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void insert(HttpServletRequest request,HttpServletResponse response ) throws ServletException, SQLException, IOException{
		
		String host = request.getParameter("host");
		String userdb = request.getParameter("userdb");
		String pass = request.getParameter("pass");
		String db = request.getParameter("db");
		String token = request.getParameter("token");
		int port = Integer.parseInt(request.getParameter("port"));
		
		int idU = Integer.parseInt(request.getParameter("usuario"));
		Usuario user = (Usuario) newUsuario.find(idU);
		
		
		int state =  Integer.parseInt(request.getParameter("state"));
		
		String ty = request.getParameter("type");
		Typedb type = (Typedb) newType.find(ty);
		
		
		Connectiontoken tokenC = new Connectiontoken(db, host, pass, port, state, token, userdb, type, user);
		
		newType.insert(tokenC);		
		this.list(request, response);
	}
	
	private void list(HttpServletRequest request,HttpServletResponse response ) throws ServletException, SQLException, IOException{
		
		List<Typedb> listT  = newType.list();
		request.setAttribute( "listT", listT);

		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
