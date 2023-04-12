package hyl;

public class ChiTietDonThuoc {
	private int idCTDon;
	private int idDon;
	private int idThuoc;
	private int slg;
     
     
    public ChiTietDonThuoc() {
		super();
	}
	
    public ChiTietDonThuoc(int idCTDon, int idDon, int idThuoc, int slg) {
		this.idCTDon = idCTDon;
		this.idDon = idDon;
		this.idThuoc = idThuoc;
		this.slg = slg;
	}


	public ChiTietDonThuoc(int idDon, int idThuoc, int slg) {
		this.idDon = idDon;
		this.idThuoc = idThuoc;
		this.slg = slg;
	}

	public ChiTietDonThuoc(ChiTietDonThuoc ctdt) {
		this.idDon = ctdt.idDon;
		this.idThuoc = ctdt.idThuoc;
     }


	public int getIdCTDon() {
		return idCTDon;
	}

	public void setIdCTDon(int idCTDon) {
		this.idCTDon = idCTDon;
	}

	public int getIdDon() {
		return idDon;
	}

	public void setIdDon(int idDon) {
		this.idDon = idDon;
	}

	public int getIdThuoc() {
		return idThuoc;
	}

	public void setIdThuoc(int idThuoc) {
		this.idThuoc = idThuoc;
	}

	public int getSlg() {
		return slg;
	}

	public void setSlg(int slg) {
		this.slg = slg;
	}
	
}


