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
import javax.servlet.http.HttpSession;

@WebServlet("/Dangnhap")
public class DangnhapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    Connection conn;    
        try{
            conn = MySQLConntUtils.getMySQLConnection();     
   
            String username = request.getParameter("username");  
            String password = request.getParameter("password");                    
            UserAccount us = new UserAccount(username,password);
            UserAccount user = new UserAccount(DBUtils.TimTK(conn,us.getUserName(),us.getPassword()));
             
            if(us!=null) {
            	
            	HttpSession session = request.getSession();
	        	session.setAttribute("admin", user);
	        	session.setAttribute("name",  user.getUserName());
	        	response.sendRedirect(request.getContextPath() + "/Home.jsp"); 
	        }
        }catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(DangnhapServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

          @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.getRequestDispatcher("/Home.jsp").forward(request, response);
    }    
      
   

}
