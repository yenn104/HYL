package hyl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "KeDon",  urlPatterns = {"/KeDon"})
public class KeDonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public KeDonServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at:").append(request.getContextPath());
		
		HttpSession session = request.getSession();
		Connection conn = null;
		String userName;
		userName = (String)session.getAttribute("name");
		
		response.setContentType("text/html");	// Set response content type
		String sql = null;
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
                	if(sql == null)  sql = "(" + paramValue;
                	else sql = sql + "," + paramValue;
                }
            }
         } String key = sql + ")";

         
		try {
			Benh benh = new Benh();
			conn = MySQLConntUtils.getMySQLConnection();
			benh = DBUtils.TimBenh(conn, key);
			request.setAttribute("idB", benh.getIdB());
			long millis=System.currentTimeMillis(); 
			java.sql.Date date=new java.sql.Date(millis);   
			
			int idBenh = benh.getIdB();
			float xs = benh.getXs();
			DonThuoc don = new DonThuoc(idBenh, userName, xs);
			DBUtils.TaoDon(conn, don);
			request.setAttribute("benh", benh);
			request.setAttribute("don", don);
			request.setAttribute("date", date);
			
			
			String errorString = "Không có thuốc phù hợp!";
			
			List<BenhThuoc> list = new ArrayList<BenhThuoc>();
			try {
				conn = MySQLConntUtils.getMySQLConnection();
				list = DBUtils.BenhThuoc(conn, benh.getIdB());
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}		
			
			List<Thuoc> list1 = new ArrayList<Thuoc>();
			try {
				conn = MySQLConntUtils.getMySQLConnection();
				list1 = DBUtils.queryThuoc(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			request.setAttribute("errorString", errorString);
			request.setAttribute("ds", list);
			request.setAttribute("all", list1);
			
			List<DonThuoc> list2 = new ArrayList<DonThuoc>();
			try {
				conn = MySQLConntUtils.getMySQLConnection();
				list2 = DBUtils.queryDon(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			int idDon = list2.get(list2.size()-1).getIdDon();
			
			for (int i = 0; i < list.size(); i++) {
				int idThuoc = list.get(i).getIdThuoc();
				int slg = list.get(i).getSlg();
				
				ChiTietDonThuoc ct = new ChiTietDonThuoc(idDon, idThuoc, slg);
				DBUtils.createDonDetail(conn, ct);
			}
			
			
			request.getRequestDispatcher("/donthuoc.jsp").forward(request, response); 
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
	       }

}
