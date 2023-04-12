package hyl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SuaBenh")
public class SuaBenhServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SuaBenhServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Connection conn = null; //connect SQL
	    request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		try {
			String id_temp=request.getParameter("id");
			int id = Integer.parseInt(id_temp);
			
			conn = MySQLConntUtils.getMySQLConnection();
			
			Benh b = new Benh (DBUtils.TimBenhID(conn, id));
				request.setAttribute("id", id);
				request.setAttribute("ten", b.getTenB());
				request.setAttribute("slg", b.getSlg());
				request.setAttribute("info", b.getInfo());
			
			request.getRequestDispatcher("/Editbenh.jsp").forward(request, response);
	   }catch(ClassNotFoundException | SQLException ex){
	        Logger.getLogger(SuaThuocServlet.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			conn = MySQLConntUtils.getMySQLConnection();
			
			
			int id=Integer.parseInt(request.getParameter("id"));			 
			String tenb =request.getParameter("ten");
			String info=request.getParameter("info");
			
			
			Benh benh = new Benh(id, tenb, info); 
			DBUtils.updateBenh(conn, benh);
			
			request.getRequestDispatcher("/Benh").forward(request, response);
		
		}catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(SuaThuocServlet.class.getName()).log(Level.SEVERE, null, ex);
        } 
	 
	}

}