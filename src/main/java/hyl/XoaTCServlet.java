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


@WebServlet("/XoaTC")
public class XoaTCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public XoaTCServlet() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn = null;
		String id_temp=request.getParameter("id");
		int id = Integer.parseInt(id_temp);
		try {
			conn = MySQLConntUtils.getMySQLConnection();
			DBUtils.deleteTC(conn, id);
			request.setAttribute("trieuchung", id);
			request.getRequestDispatcher("/TrieuChung").forward(request, response); 
		}catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(XoaThuocServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
	}

}