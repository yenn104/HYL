package hyl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DBUtils {


//OK
	public static void insertUserAccount(Connection conn, UserAccount user) throws SQLException{
        String sql = "INSERT INTO user_account (Username, Password, Email, Admin) VALUES (?,?,?,?)";
	        PreparedStatement pstm = conn.prepareStatement(sql);
		        pstm.setString(1,user.getUserName());
		        pstm.setString(2,user.getPassword());
		        pstm.setString(3,user.getEmail());
		        pstm.setInt(4,user.getAdmin());
        pstm.executeUpdate();
    }		
	
//	OK
    public static UserAccount findAdmin(Connection conn, UserAccount user) throws SQLException{
        //để đăng nhập --tìm trên csdl và trả về một user_account
        String sql ="SELECT u.UserName, u.Password, u.admin FROM user_account u WHERE u.userName =? AND u.passWord =?";        
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1,user.getUserName());
        pstm.setString(2,user.getPassword());
        ResultSet rs = pstm.executeQuery(); 
        
        if(rs.next()){
            UserAccount us = new UserAccount();            
            user.setUserName(rs.getString("userName")); 
            user.setPassword(rs.getString("passWord"));
            user.setAdmin(rs.getInt("admin"));            
            return us;
        }return null;     
    }

	

//THUOC
	
	public static List<BenhThuoc> BenhThuoc(Connection conn, int idBenh) throws SQLException {
		String sql = "SELECT * FROM benhthuoc WHERE idBenh = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1,idBenh);
		ResultSet rs = pstm.executeQuery();
		List<BenhThuoc> list = new ArrayList<BenhThuoc>();
		while (rs.next()) {
			int id = rs.getInt("ID");
			int idB = rs.getInt("idBenh");
			int idThuoc = rs.getInt("idThuoc");
			int slg = rs.getInt("slg");
			
			BenhThuoc t = new BenhThuoc();
				t.setId(id);
				t.setIdBenh(idB);
				t.setIdThuoc(idThuoc);
				t.setSlg(slg);
				list.add(t);
		}return list;
	}
	
	
//OK	
	public static List<Thuoc> ChiTietThuoc(Connection conn, int idDon) throws SQLException {
		String sql = "SELECT DISTINCT t.ID, t.Ten, t.dvt FROM ctdt, thuoc t WHERE ctdt.idDon = ? AND ctdt.idThuoc = t.ID;";
		PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1,idDon);
		ResultSet rs = pstm.executeQuery();
		List<Thuoc> list = new ArrayList<Thuoc>();
		while (rs.next()) {
			int id = rs.getInt("ID");
			String tenthuoc = rs.getString("Ten");
			String dvt = rs.getString("dvt");
			
			Thuoc t = new Thuoc();
				t.setId(id);
				t.setTenthuoc(tenthuoc);
				t.setDvt(dvt);
			list.add(t);
		}return list;
	}
	
//OK	
// truy vấn lấy danh sách toàn bộ thuốc    
	public static List<Thuoc> queryThuoc(Connection conn) throws SQLException {
		String sql = "Select * from Thuoc ";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<Thuoc> list = new ArrayList<Thuoc>();
		while (rs.next()) {
			int id = rs.getInt("Id");
			String ten = rs.getString("Ten");
			String hoatchat = rs.getString("Hoatchat");
			String dvt = rs.getString("DVT");
			String ctysx = rs.getString("Ctysx");
			String nuocsx = rs.getString("Nuocsx");
			
			
			Thuoc t = new Thuoc();
			t.setId(id);
			t.setTenthuoc(ten);
			t.setHoatchat(hoatchat);
			t.setCtysx(ctysx);
			t.setNuocsx(nuocsx);
			t.setDvt(dvt);
			list.add(t);
			
		}return list;
	}
	
//OK	
//tìm thuốc bằng id truyền vào, rồi lấy toàn bộ thông tin của 1 thuốc	
	public static Thuoc findThuoc(Connection conn, int id) throws SQLException {
	String sql = "Select a.Ten, a.Hoatchat, a.Ctysx, a.Nuocsx, a.DVT from Thuoc a where a.ID=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, id);
		ResultSet rs = pstm.executeQuery();
		if (rs.next()) {
			String ten = rs.getString("Ten");
			String Hoatchat= rs.getString("Hoatchat");
			String Ctysx= rs.getString("Ctysx");
			String Nuocsx= rs.getString("Nuocsx");
			String DVT= rs.getString("DVT");
			
			Thuoc t = new Thuoc();
			t.setId(id);
			t.setTenthuoc(ten);
			t.setHoatchat(Hoatchat);
			t.setCtysx(Ctysx);
			t.setNuocsx(Nuocsx);
			t.setDvt(DVT);
				
		return t;
		}
		return null;
		}

//OK
	public static void updateThuoc(Connection conn, Thuoc thuoc) throws SQLException {
		String sql = "Update Thuoc set Ten =?, Hoatchat=?, Ctysx=?, Nuocsx=?, DVT=?  where id=? ";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, thuoc.getTenthuoc());
			pstm.setString(2, thuoc.getHoatchat());
			pstm.setString(3, thuoc.getCtysx());
			pstm.setString(4, thuoc.getNuocsx());
			pstm.setString(5, thuoc.getDvt());
			pstm.setInt(6, thuoc.getId()); 
		pstm.executeUpdate();
	}
	
//OK
	public static void themThuoc(Connection conn, Thuoc thuoc) throws SQLException {
		String sql = "Insert into Thuoc (Ten, Hoatchat, Ctysx, Nuocsx, DVT) values (?,?,?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setString(1, thuoc.getTenthuoc());
				pstm.setString(2, thuoc.getHoatchat());
				pstm.setString(3, thuoc.getCtysx());
				pstm.setString(4, thuoc.getNuocsx());
				pstm.setString(5, thuoc.getDvt());
		pstm.executeUpdate();
	}
	

//OK
	public static void deleteThuoc(Connection conn, int id) throws SQLException {
		String sql = "Delete From Thuoc where id= ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
		pstm.executeUpdate();
	}

//TRIEUCHUNG

//OK
	public static List<TrieuChung> TrieuChungList(Connection conn) throws SQLException {
		String sql = "Select a.ID, a.Ten from TrieuChung a ";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<TrieuChung> list = new ArrayList<TrieuChung>();
		while (rs.next()) {
		int id = rs.getInt("Id");
		String ten = rs.getString("Ten");
		
		TrieuChung tc = new TrieuChung();
		tc.setIdTC(id);
		tc.setTenTC(ten);;
		
		list.add(tc);
	}
	return list;
	}

//OK
	public static void ThemTC(Connection conn, TrieuChung tc) throws SQLException {
		String sql = "Insert into trieuchung (Ten) values (?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, tc.getTenTC());
			pstm.executeUpdate();
	}
	
//OK
	public static void deleteTC(Connection conn, int id) throws SQLException {
		String sql = "Delete From Trieuchung where id= ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.executeUpdate();
	}
	
//OK
	public static void xoaTCB(Connection conn, int idB) throws SQLException {
		String sql = "Delete From Trieuchung where idB= ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idB);
			pstm.executeUpdate();
	}
	
//OK
	public static void updateTC(Connection conn, TrieuChung tc) throws SQLException {
		String sql = "Update trieuchung set Ten =? where id=? ";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, tc.getTenTC());
			pstm.setInt(2, tc.getIdTC());
		pstm.executeUpdate();
	}
	
 //DON THUOC
//OK
	public static void TaoDon1(Connection conn, DonThuoc don) throws SQLException {
		String sql = "Insert INTO donthuoc (idBenh, UserName) values (?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, don.getIdBenh());
		pstm.setString(2, don.getUserName());
		pstm.executeUpdate();
		}

//OK
	public static void TaoDon(Connection conn, DonThuoc don) throws SQLException {
		String sql = "Insert INTO donthuoc (idBenh, UserName, xs) values (?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, don.getIdBenh());
		pstm.setString(2, don.getUserName());
		pstm.setFloat(3, don.getXs());
		pstm.executeUpdate();
		}
	
//OK
	public static DonThuoc TimDon(Connection conn, int idDon) throws SQLException{
        String sql ="SELECT d.ID, d.idBenh, d.userName, d.Date, d.xs FROM donthuoc d WHERE d.ID= ?";        
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, idDon);
        ResultSet rs = pstm.executeQuery(); 
        
        if(rs.next()){
        	DonThuoc dt = new DonThuoc();
        	dt.setIdDon(rs.getInt("ID"));
            dt.setIdBenh(rs.getInt("idBenh")); 
            dt.setUserName(rs.getString("userName"));
            dt.setDate(rs.getDate("Date")); 
            dt.setXs(rs.getFloat("xs"));
            return dt;
        }return null;     
    }
	
	
	public static List<DonThuoc> queryDonThuoc(Connection conn, int idDon) throws SQLException {
		String sql = "SELECT d.ID, d.userName, d.Date FROM donthuoc d WHERE d.ID= ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, idDon);
		ResultSet rs = pstm.executeQuery();
		List<DonThuoc> list = new ArrayList<DonThuoc>();
		while (rs.next()) {
			int idBenh = rs.getInt("idBenh");
			String userName = rs.getString("userName");
			Date date = rs.getDate("Date");
			
			DonThuoc d = new DonThuoc();
			d.setIdDon(idDon);
			d.setIdBenh(idBenh);
			d.setUserName(userName);
			d.setDate(date);

		list.add(d);
	}
	return list;
	}
	
	public static DonThuoc TimDon(Connection conn, DonThuoc don) throws SQLException {
		String sql = "Select a.ID, a.idBenh, a.userName, a.Date from DonThuoc a where a.idBenh=? and a.userName=? ";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, don.getIdBenh());
			pstm.setString(2, don.getUserName());
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				int idDon = rs.getInt("ID");
				int idBenh = rs.getInt("idBenh");
				String userName = rs.getString("userName");
				Date date = rs.getDate("Date");
				
				DonThuoc d = new DonThuoc();
				d.setIdDon(idDon);
				d.setIdBenh(idBenh);
				d.setUserName(userName);
				d.setDate(date);

			return d;
			}
			return null;
			}
	
	public static List<DonThuoc> queryDon(Connection conn) throws SQLException {
		String sql = "SELECT a.ID, a.idBenh, a.userName, a.Date, a.xs FROM donthuoc a";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<DonThuoc> list = new ArrayList<DonThuoc>();
		while (rs.next()) {
			int idDon = rs.getInt("ID");
			int idBenh = rs.getInt("idBenh");
			String userName = rs.getString("userName");
			Date date = rs.getDate("Date");
			
			DonThuoc d = new DonThuoc();
			d.setIdDon(idDon);
			d.setIdBenh(idBenh);
			d.setUserName(userName);
			d.setDate(date);

		list.add(d);
	}
	return list;
	}
	
	public static List<DonThuoc> LSDon(Connection conn, String userName) throws SQLException {
		String sql = "SELECT a.ID, a.idBenh, a.username, a.Date FROM donthuoc a WHERE UserName = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1,userName);
		ResultSet rs = pstm.executeQuery();
		List<DonThuoc> list = new ArrayList<DonThuoc>();
		while (rs.next()) {
			int idDon = rs.getInt("ID");
			int idBenh = rs.getInt("idBenh");
			Date date = rs.getDate("Date");
			
			DonThuoc d = new DonThuoc();
			d.setIdDon(idDon);
			d.setIdBenh(idBenh);
			d.setUserName(userName);
			d.setDate(date);
		list.add(d);
	}
	return list;
	}
	
	
//CHITIETDONTHUOC
	public static void createDonDetail(Connection conn, ChiTietDonThuoc ct) throws SQLException {
		String sql = "Insert INTO ctdt ( idDon, idThuoc, slg ) values (?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, ct.getIdDon());
		pstm.setInt(2, ct.getIdThuoc());
		pstm.setInt(3, ct.getSlg());
		pstm.executeUpdate();
		}
	
	//OK
	public static List<ChiTietDonThuoc> queryChiTietDon(Connection conn, int idDon) throws SQLException {
		String sql = "SELECT DISTINCT ctdt.idThuoc, ctdt.slg FROM ctdt WHERE ctdt.idDon = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1,idDon);
		ResultSet rs = pstm.executeQuery();
		List<ChiTietDonThuoc> list = new ArrayList<ChiTietDonThuoc>();
		while (rs.next()) {
		int idThuoc = rs.getInt("idThuoc");
		int slg = rs.getInt("slg");
		ChiTietDonThuoc ct = new ChiTietDonThuoc();
		ct.setIdThuoc(idThuoc);
		ct.setSlg(slg);
		
		list.add(ct);
	}
	return list;
	}

	
//BENH	

//OKk
	public static Benh TimBenh(Connection conn, String key) throws SQLException {
		String sql = "SELECT B.*, ((COUNT(ctb.idTC)/b.slg)*100-b.slg) as XS" 
				+" FROM ctb, benh b WHERE ctb.idB = b.ID AND ctb.idTC in"+ key +" GROUP BY b.ID ORDER BY XS DESC LIMIT 1";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		if (rs.next()) {
			int idB = rs.getInt("ID");
			String tenB = rs.getString("Ten");
			int slg = rs.getInt("slg");
			String Info = rs.getString("Infor");
			Float xs = rs.getFloat("XS");
			Benh b = new Benh();
			b.setIdB(idB);
			b.setTenB(tenB);
			b.setSlg(slg);
			b.setInfo(Info);
			b.setXs(xs);
			return b;
		} 
	return null;
	}
	
	//DS Bẹnh
	public static List<Benh> queryBenh(Connection conn) throws SQLException {
		String sql = "SELECT a.ID, a.Ten, a.Slg, a.infor FROM Benh a";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<Benh> list = new ArrayList<Benh>();
		while (rs.next()) {
			int idB = rs.getInt("ID");
			String tenB = rs.getString("Ten");
			int slg = rs.getInt("slg");
			String Info = rs.getString("Infor");
			Benh b = new Benh();
			b.setIdB(idB);
			b.setTenB(tenB);
			b.setSlg(slg);
			b.setInfo(Info);

		list.add(b);
	}
	return list;
	}
	
	//OKk
	public static Benh TimBenhID(Connection conn, int id) throws SQLException{
        String sql ="SELECT b.ID, b.Ten, b.Slg, b.infor FROM Benh b WHERE b.ID= ?";        
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        ResultSet rs = pstm.executeQuery(); 
        
        if(rs.next()){
        	int idB = rs.getInt("ID");
			String tenB = rs.getString("Ten");
			int slg = rs.getInt("Slg");
			String info = rs.getString("infor");
			
			Benh b = new Benh();
            b.setIdB(idB); 
            b.setTenB(tenB); 
            b.setSlg(slg);
            b.setInfo(info);
            
            return b;
        }return null;     
    }
	
	
	//OK
	public static void deleteBenh(Connection conn, int id) throws SQLException {
		String sql = "Delete From Benh where id= ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
		pstm.executeUpdate();
	}
	
	//OK
	public static void themBenh(Connection conn,Benh benh) throws SQLException {
		String sql = "Insert into Benh (Ten, infor, slg) values (?,?,0)";
			PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setString(1, benh.getTenB());
				pstm.setString(2, benh.getInfo());

		pstm.executeUpdate();
	}
	//OK
	public static void updateBenh(Connection conn, Benh benh) throws SQLException {
		String sql = "Update Benh set Ten =?, infor=? where id=? ";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, benh.getTenB());
			pstm.setString(2, benh.getInfo());
			pstm.setInt(3, benh.getIdB());
		pstm.executeUpdate();
	}
	//OK
	
	public static void slgTCB(Connection conn, int idB, int slg) throws SQLException {
		String sql = "Update Benh set slg =? where id=? ";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1,slg);
			pstm.setInt(2,idB);
		pstm.executeUpdate();
	}
	

	
//BENHTRIEUCHUNG
	//OK
	public static void XoaCTB(Connection conn, int id) throws SQLException {
		String sql = "Delete From ctb where idB= ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.executeUpdate();
	}
	
	
	//OK
	public static void taoCTB(Connection conn, int idB, int idTC) throws SQLException {
		String sql = "Insert INTO ctb (idB, idTC) values (?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, idB);
		pstm.setInt(2, idTC);
		pstm.executeUpdate();
		}
	
//BENHTHUOC
	public static void XoaTB(Connection conn, int id) throws SQLException {
		String sql = "Delete From benhthuoc where idBenh= ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.executeUpdate();
	}
	
	public static void taoTB(Connection conn, int idBenh, int idThuoc) throws SQLException {
		String sql = "Insert INTO benhthuoc (idBenh, idThuoc, slg) values (?,?,0)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, idBenh);
		pstm.setInt(2, idThuoc);
		pstm.executeUpdate();
		}
	
	public static void updateSlg(Connection conn, int idBenh, int idThuoc, int slg) throws SQLException {
		String sql = "Update benhthuoc set slg =? where idBenh=? AND idThuoc=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, slg);
		pstm.setInt(2, idBenh);
		pstm.setInt(3, idThuoc);
		pstm.executeUpdate();
		}
	
//NguoiDung
//	OK
    public static UserAccount TimTK(Connection conn, String userName, String password) throws SQLException{
        String sql ="SELECT u.Username, u.Password, u.admin FROM user_account u WHERE u.Username =? AND u.Password =?";        
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1,userName);
        pstm.setString(2,password);
        ResultSet rs = pstm.executeQuery(); 
        
        if(rs.next()){
            UserAccount us = new UserAccount();            
            us.setUserName(rs.getString("Username")); 
            us.setPassword(rs.getString("Password"));
            us.setAdmin(rs.getInt("admin"));            
            return us;
        }return null;     
    }

    
}