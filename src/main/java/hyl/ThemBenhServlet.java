package hyl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ThemBenh")
public class ThemBenhServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ThemBenhServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	
    	RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/Benh");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null; 
	 
	try {
		 request.setCharacterEncoding("utf-8");
		 response.setCharacterEncoding("utf-8");
		 conn = MySQLConntUtils.getMySQLConnection();
		 
		 String tenb =request.getParameter("ten");
		 String info=request.getParameter("info");
		
		 Benh b = new Benh(tenb, info);
		 DBUtils.themBenh(conn, b);
		 
		 
		 List<Benh> list = new ArrayList<Benh>();
		try {
			conn = MySQLConntUtils.getMySQLConnection();
			list = DBUtils.queryBenh(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		 
		int idB = list.get(list.size()-1).getIdB();
		 
		request.setAttribute("benh", list);
		request.setAttribute("idB", idB);
		request.setAttribute("tenB", tenb);
		 
		 request.getRequestDispatcher("/Benh").forward(request, response);
	 
		}catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(ThemBenhServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
	 
	}

}