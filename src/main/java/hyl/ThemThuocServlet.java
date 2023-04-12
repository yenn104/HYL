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


@WebServlet("/ThemThuoc")
public class ThemThuocServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ThemThuocServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/Thuoc");
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
		 String tenthuoc=request.getParameter("tenthuoc");
		 String hoatchat=request.getParameter("hoatchat");
		 String ctysx=request.getParameter("ctysx");
		 String nuocsx=request.getParameter("nuocsx");
		 String dvt=request.getParameter("dvt");
		 
		 Thuoc t= new Thuoc( tenthuoc, hoatchat, ctysx, nuocsx, dvt);
		 DBUtils.themThuoc(conn, t);
		 request.getRequestDispatcher("/Thuoc").forward(request, response);
	 
		}catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(ThemThuocServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
	 
	}

}
