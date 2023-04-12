package hyl;

public class BenhThuoc {
	private int id;
	public int idBenh;
	public int idThuoc;
	private int slg;
	
	public BenhThuoc() {
		super();
	}

	public BenhThuoc(int id, int idBenh, int idThuoc, int slg) {
		this.id = id;
		this.idBenh = idBenh;
		this.idThuoc = idThuoc;
		this.slg = slg;
	}

	public BenhThuoc(int idBenh, int idThuoc, int slg) {
		this.idBenh = idBenh;
		this.idThuoc = idThuoc;
		this.slg = slg;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdBenh() {
		return idBenh;
	}

	public void setIdBenh(int idBenh) {
		this.idBenh = idBenh;
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
