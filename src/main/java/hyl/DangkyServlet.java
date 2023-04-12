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


@WebServlet("/Dangky")
public class DangkyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = null;
		try {
			conn = MySQLConntUtils.getMySQLConnection();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			int admin= 0;
			
			UserAccount us = new UserAccount(username, password, email, admin);
			DBUtils.insertUserAccount(conn, us);
			request.setAttribute("username", username);
			/* request.getRequestDispatcher("/home").forward(request, response); */
			 response.sendRedirect(request.getContextPath() + "/Home.jsp"); 
		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(DangkyServlet.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
