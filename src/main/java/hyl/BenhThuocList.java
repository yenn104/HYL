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

@WebServlet("/BenhThuoc")
public class BenhThuocList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BenhThuocList() {
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
		
		List<Thuoc> list = new ArrayList<Thuoc>();
		try {
			conn = MySQLConntUtils.getMySQLConnection();
			list = DBUtils.queryThuoc(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		request.setAttribute("errorString", errorString);
		request.setAttribute("thuoc", list);
		request.setAttribute("idB", idB);
		request.setAttribute("tenB", tenB);
		request.getRequestDispatcher("/benhthuoc.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
