package hyl;

import java.sql.Date;
//Them float xs
public class DonThuoc {
	private int idDon;
	public int idBenh;
	public String userName;
	private float xs;
	private Date date;
	
	public DonThuoc() {
		super();
	}

	public DonThuoc(int idDon, int idBenh, String userName, float xs, Date date) {
		this.idDon = idDon;
		this.idBenh = idBenh;
		this.userName = userName;
		this.xs = xs;
		this.date = date;
	}


	public DonThuoc(DonThuoc don) {
		this.idDon = don.idDon;
		this.idBenh = don.idBenh;
		this.userName = don.userName;
		this.xs = don.xs;
		this.date = don.date;
	}

	public DonThuoc(String userName, float xs, Date date) {
		this.userName = userName;
		this.xs = xs;
		this.date = date;
	}

	public DonThuoc( int idBenh, String userName) {
		this.idBenh = idBenh;
		this.userName = userName;
	}
	
	public DonThuoc( int idBenh,  String userName, float xs) {
		this.idBenh = idBenh;
		this.userName = userName;
		this.xs = xs;
	}

	public int getIdDon() {
		return idDon;
	}

	public void setIdDon(int idDon) {
		this.idDon = idDon;
	}

	public int getIdBenh() {
		return idBenh;
	}

	public void setIdBenh(int idBenh) {
		this.idBenh = idBenh;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public float getXs() {
		return xs;
	}

	public void setXs(float xs) {
		this.xs = xs;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
