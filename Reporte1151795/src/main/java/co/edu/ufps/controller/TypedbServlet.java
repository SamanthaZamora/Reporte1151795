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

import co.edu.ufps.dao.GenericDao;
import co.edu.ufps.dao.TypedbDao;
import co.edu.ufps.entities.Typedb;



@WebServlet("/TypedbServlet")
public class TypedbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private GenericDao newType;
	
    public TypedbServlet() {
        super();
        this.newType = new TypedbDao();
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
			default:
				list(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void showNewForm(HttpServletRequest request,HttpServletResponse response ) throws ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("type.jsp");
		dispatcher.forward(request,response);
	}

	private void insert(HttpServletRequest request,HttpServletResponse response ) throws ServletException, SQLException, IOException{
		
		String driver = request.getParameter("driver");
		String descripcion = request.getParameter("description");
		String aditional = request.getParameter("aditional");
		
		Typedb base = new Typedb(descripcion, driver, aditional);
		
		newType.insert(base);		
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
