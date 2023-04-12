package hyl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenhTC")
public class BenhTCList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BenhTCList() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at:").append(request.getContextPath());
		
		Connection conn = null;
		String tenB = request.getParameter("tenB") ;
		String idB_temp = request.getParameter("idB") ;
		int idB = Integer.parseInt(idB_temp);
		
		String errorString = "Hệ thống đang được bảo trì, mời bạn quay lại sau.";
		
		List<TrieuChung> list = new ArrayList<TrieuChung>();
		try {
			conn = MySQLConntUtils.getMySQLConnection();
			list = DBUtils.TrieuChungList(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("errorString", errorString);
		request.setAttribute("TCList", list);
		request.setAttribute("idB", idB);
		request.setAttribute("tenB", tenB);
//		request.setAttribute("benh", b);
		request.getRequestDispatcher("/benhtc.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
}
