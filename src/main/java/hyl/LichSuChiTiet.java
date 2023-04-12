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

@WebServlet("/ChiTiet")
public class LichSuChiTiet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LichSuChiTiet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at:").append(request.getContextPath());
		
		Connection conn = null;
		String userName = request.getParameter("userName") ;
		request.setAttribute("userName", userName);
		
		String id_temp=request.getParameter("idDon");
		int id = Integer.parseInt(id_temp);
//		request.setAttribute("idDon", id);
		
		List<ChiTietDonThuoc> list = new ArrayList<ChiTietDonThuoc>();
		try {
			conn = MySQLConntUtils.getMySQLConnection();
			list = DBUtils.queryChiTietDon(conn, id);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
		
		List<Thuoc> list1 = new ArrayList<Thuoc>();
		try {
			conn = MySQLConntUtils.getMySQLConnection();
			list1 = DBUtils.ChiTietThuoc(conn, id);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		DonThuoc dt = new DonThuoc();
		try {
			conn = MySQLConntUtils.getMySQLConnection();
			dt = DBUtils.TimDon(conn, id);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		int i = dt.getIdBenh();
		
		Benh b = new Benh();
		try {
			conn = MySQLConntUtils.getMySQLConnection();
			b = DBUtils.TimBenhID(conn, i);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
//		request.setAttribute("don", list2);

//		request.setAttribute("don", dt);
		request.setAttribute("benh", b);
		request.setAttribute("don", dt);
		request.setAttribute("all", list1);
		request.setAttribute("ds", list);
		request.getRequestDispatcher("/Ctdt.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
