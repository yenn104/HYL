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


@WebServlet("/Thuoc")
public class ThuocListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ThuocListServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at:").append(request.getContextPath());
		
		String errorString = "Không có thuốc phù hợp!";
		String userName = request.getParameter("userName") ;
		
		List<Thuoc> list = new ArrayList<Thuoc>();
		try {
			Connection conn = MySQLConntUtils.getMySQLConnection();
			list = DBUtils.queryThuoc(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		request.setAttribute("all", list);
		
		request.setAttribute("userName", userName);
		request.setAttribute("errorString", errorString);
		request.getRequestDispatcher("/Thuoc.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
