package hyl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ThemTC")
public class ThemTCSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ThemTCSevlet () {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/NewTC.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Connection conn = null; //connect SQL
	 
	try {
		 request.setCharacterEncoding("utf-8");
		 response.setCharacterEncoding("utf-8");
		 conn = MySQLConntUtils.getMySQLConnection();
		 
		 //xử lý tham số từ form
		// int id=Integer.parseInt(request.getParameter("ID"));			 
		 String tentc=request.getParameter("tenTC");
		

		 TrieuChung tc= new TrieuChung( tentc);
		 DBUtils.ThemTC(conn, tc);
		 request.getRequestDispatcher("/TrieuChung").forward(request, response);
	 
		}catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(ThemThuocServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
	 
	}

}