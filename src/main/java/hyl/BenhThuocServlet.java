package hyl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenhThuocServlet")
public class BenhThuocServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BenhThuocServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at:").append(request.getContextPath());
		
		Connection conn = null;
		int i = 0;
		int idB = 0;
		int idThuoc=0;
		response.setContentType("text/html");
		Enumeration paramNames = request.getParameterNames();
		
		while (paramNames.hasMoreElements()) 
		{
            String paramName = (String) paramNames.nextElement();
            String[] paramValues = request.getParameterValues(paramName);
            
            if (paramValues.length == 1) 
            {
                String paramValue = paramValues[0];
                if (paramValue.length() != 0) 
                {   
                	if(i== 0) {
                		idB = Integer.parseInt(paramValue);
                		try { 
                			conn = MySQLConntUtils.getMySQLConnection();
                			DBUtils.XoaTB(conn, idB);
                		} catch (SQLException e) { e.printStackTrace();
                		} catch (ClassNotFoundException e) {e.printStackTrace();}
                	}else {
                		
                		if(i %2!=0) {
                			idThuoc = Integer.parseInt(paramValue);
		    				try { 
		    					conn = MySQLConntUtils.getMySQLConnection();
		    					DBUtils.taoTB(conn,idB ,idThuoc);
							} catch (SQLException e) {e.printStackTrace();
							} catch (ClassNotFoundException e) {e.printStackTrace();}
                		}else {
                			int slg = Integer.parseInt(paramValue);
		    				try { 
		    					conn = MySQLConntUtils.getMySQLConnection();
		    					DBUtils.updateSlg(conn,idB ,idThuoc,slg);
							} catch (SQLException e) {e.printStackTrace();
							} catch (ClassNotFoundException e) {e.printStackTrace();}
                		}
                	}i++;
                }
            }
         } 

         request.getRequestDispatcher("/Benh").forward(request, response); 
	}

}
