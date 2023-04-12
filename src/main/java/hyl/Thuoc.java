package hyl;


public class Thuoc {
	private int id;
	private String tenthuoc;
	private String hoatchat;
	private String ctysx;
	private String nuocsx;
	private String dvt;
	
	public Thuoc() {
		super();
	}

	public Thuoc(int id, String tenthuoc, String hoatchat, String ctysx,String nuocsx, String dvt) {
		this.id = id;
		this.tenthuoc = tenthuoc;
		this.hoatchat= hoatchat;
		this.ctysx = ctysx;
		this.nuocsx = nuocsx;
		this.dvt =dvt;
	}
	
	public Thuoc(Thuoc thuoc) {
		this.id = thuoc.id;
		this.tenthuoc = thuoc.tenthuoc;
		this.hoatchat = thuoc.hoatchat;
		this.ctysx= thuoc.ctysx;
		this.nuocsx = thuoc.nuocsx;
		this.dvt = thuoc.dvt;
	}
	
	public Thuoc(String tenthuoc, String hoatchat, String ctysx,String nuocsx, String dvt) {
		this.tenthuoc = tenthuoc;
		this.hoatchat = hoatchat;
		this.ctysx= ctysx;
		this.nuocsx = nuocsx;
		this.dvt = dvt;
	}

	public Thuoc(int id, String tenthuoc, String hoatchat, String dvt) {
		this.id = id;
		this.tenthuoc = tenthuoc;
		this.hoatchat = hoatchat;
		this.dvt = dvt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenthuoc() {
		return tenthuoc;
	}

	public void setTenthuoc(String tenthuoc) {
		this.tenthuoc = tenthuoc;
	}

	public String getHoatchat() {
		return hoatchat;
	}

	public void setHoatchat(String hoatchat) {
		this.hoatchat = hoatchat;
	}

	public String getCtysx() {
		return ctysx;
	}

	public void setCtysx(String ctysx) {
		this.ctysx = ctysx;
	}

	public String getNuocsx() {
		return nuocsx;
	}

	public void setNuocsx(String nuocsx) {
		this.nuocsx = nuocsx;
	}

	public String getDvt() {
		return dvt;
	}

	public void setDvt(String dvt) {
		this.dvt = dvt;
	}

}
	