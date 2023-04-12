package hyl;

public class TrieuChung {
	private int idTC;
	private String tenTC;
	
	public TrieuChung() {
		super();
	}

	public TrieuChung(int idTC, String tenTC) {
		this.idTC = idTC;
		this.tenTC = tenTC;
	}
	
	public TrieuChung(int idTC) {
		this.idTC = idTC;
	}
	
	public TrieuChung(String tenTC) {
		super();
		this.tenTC = tenTC;
	}

	public int getIdTC() {
		return idTC;
	}

	public void setIdTC(int idTC) {
		this.idTC = idTC;
	}

	public String getTenTC() {
		return tenTC;
	}

	public void setTenTC(String tenTC) {
		this.tenTC = tenTC;
	}

	
	
}
