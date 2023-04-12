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


@WebServlet("/SuaTC")
public class SuaTCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SuaTCServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Connection conn = null; //connect SQL
	    request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String id_temp=request.getParameter("id");
		int id = Integer.parseInt(id_temp);
		String tentc=request.getParameter("ten");
			
		request.setAttribute("id", id);
		request.setAttribute("tenTC", tentc);
		
		request.getRequestDispatcher("/Edittc.jsp").forward(request, response); //đổi link
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			conn = MySQLConntUtils.getMySQLConnection();
			
			int id=Integer.parseInt(request.getParameter("id"));
			String ten=request.getParameter("tenTC");
			
			TrieuChung tc =new TrieuChung(id, ten); 
			DBUtils.updateTC(conn, tc); 
			request.getRequestDispatcher("/TrieuChung").forward(request, response); //ch sửa link
		
		}catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(SuaTCServlet.class.getName()).log(Level.SEVERE, null, ex);
        } 
	 
	}

}
