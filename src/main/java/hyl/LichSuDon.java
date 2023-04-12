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


@WebServlet("/LSD")
public class LichSuDon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LichSuDon() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Connection conn = null;
		String userName = request.getParameter("username") ;
		String errorString = "Lịch sử trống!.";
		List<DonThuoc> list = new ArrayList<DonThuoc>();
		try {
			conn = MySQLConntUtils.getMySQLConnection();
			list = DBUtils.LSDon(conn, userName);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		List<Benh> list1 = new ArrayList<Benh>();
		try {
			conn = MySQLConntUtils.getMySQLConnection();
			list1 = DBUtils.queryBenh(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		request.setAttribute("all", list1);
		request.setAttribute("lsd", list);
		request.setAttribute("errorString", errorString);
		request.getRequestDispatcher("/History.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
