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


@WebServlet("/SuaThuoc")
public class SuaThuocServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SuaThuocServlet() {
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
			
			Thuoc t = new Thuoc(DBUtils.findThuoc(conn, id));
				request.setAttribute("id", id);
				request.setAttribute("ten", t.getTenthuoc());
				request.setAttribute("hc", t.getHoatchat());
				request.setAttribute("cty", t.getCtysx());
				request.setAttribute("nuoc", t.getNuocsx());
				request.setAttribute("dvt", t.getDvt());
			
			request.getRequestDispatcher("/Editthuoc.jsp").forward(request, response); //đổi link
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
			String ten=request.getParameter("ten");
			String hc=request.getParameter("hc"); 
			String cty=request.getParameter("cty"); 
			String nuoc=request.getParameter("nuoc"); 
			String dvt=request.getParameter("dvt");
			
			
			Thuoc thuoc =new Thuoc(id, ten, hc, cty, nuoc, dvt); 
			
			DBUtils.updateThuoc(conn, thuoc); 
			request.getRequestDispatcher("/Thuoc").forward(request, response); //ch sửa link
		
		}catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(SuaThuocServlet.class.getName()).log(Level.SEVERE, null, ex);
        } 
	 
	}

}
