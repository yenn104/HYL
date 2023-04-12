package hyl;

public class ChiTietBenh {
	private int idCTB;
	public int idBenh;
	public int idTC;
	
	
	public ChiTietBenh() {
		super();
	}
	public ChiTietBenh(int idCTB, int idBenh, int idTC) {
		this.idCTB = idCTB;
		this.idBenh = idBenh;
		this.idTC = idTC;
	}
	
	public ChiTietBenh( int idBenh, int idTC) {
		this.idBenh = idBenh;
		this.idTC = idTC;
	}
	
	public ChiTietBenh( int idBenh) {
		this.idBenh = idBenh;
	}
	
	
	public int getIdCTB() {
		return idCTB;
	}
	public void setIdCTB(int idCTB) {
		this.idCTB = idCTB;
	}
	public int getIdBenh() {
		return idBenh;
	}
	public void setIdBenh(int idBenh) {
		this.idBenh = idBenh;
	}
	public int getIdTC() {
		return idTC;
	}
	public void setIdTC(int idTC) {
		this.idTC = idTC;
	}
	
	
	
	
}
